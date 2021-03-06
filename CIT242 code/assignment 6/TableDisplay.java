package tabledisplay;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TableDisplay extends JFrame {
   private Connection connection;
   private JScrollPane scroller;
   private JTable table;
   
   private JPanel popup;
   private JTextField nameField,addressField,socsecField,visaTypeField,majorField;
   private Vector emprecs;
   private Enumeration emprecEnum;

   public TableDisplay() 
   {   
      // The URL specifying the employees database to which 
      // this program connects using JDBC to connect to a
      // Microsoft ODBC database.
   // String url = "jdbc:odbc:MS Access Database"+";DBQ=C:\\TableDisplay-3-Fields\\employee.mdb";  
	   String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:\\TableDisplay-3-Fields\\employee.mdb;"; 
      String username = "anonymous";
      String password = "guest";
      // Load the driver to allow connection to the database
      try {
         Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" );
         connection = DriverManager.getConnection( url, username, password );
      } 
      catch ( ClassNotFoundException cnfex ) {
         System.err.println( "Failed to load JDBC/ODBC driver." );
         cnfex.printStackTrace();
         System.exit( 1 );  // terminate program
      }
      catch ( SQLException sqlex ) {
         System.err.println( "Unable to connect" );
         sqlex.printStackTrace();
      }
      
      // Build our popup panel
      getPopup();
      
      // Build our table (this also saves emprecs in vector)
      getTable();
      
      // Display first emprec in popup
      if ((emprecs != null) &&  !(emprecs.isEmpty())) {          
          getContentPane().add( popup, BorderLayout.CENTER );
          setSize( 500, 400 );
          validate();
          setVisible(true);                        
          emprecEnum = emprecs.elements();
          if (emprecEnum.hasMoreElements()) {              
              Emprec emprec = (Emprec)(emprecEnum.nextElement());  // retuns object so you must cast here !!!!        
              populatePopup(emprec);          
          }      
      }
   }// TableDisplay constructor
      
   private void getPopup()
   {
      popup = new JPanel();
      popup.setLayout(new BorderLayout());
      
      JPanel fieldPanel = new JPanel();
      fieldPanel.setSize(300, 350);
      fieldPanel.setLayout(new GridLayout( 3, 2 ));
      
      JPanel bttnPanel = new JPanel();
      bttnPanel.setLayout(new BorderLayout());
      
      // create the components of the popup
      fieldPanel.add( new JLabel( "Name" ) );
      nameField = new JTextField();
      nameField.setEditable( false );
      fieldPanel.add( nameField );
       
      fieldPanel.add( new JLabel( "Address" ) );
      addressField = new JTextField();
      addressField.setEditable( false );
      fieldPanel.add( addressField );

      fieldPanel.add( new JLabel( "Social Security" ) );
      socsecField = new JTextField();
      socsecField.setEditable( false );
      fieldPanel.add( socsecField );
      
      fieldPanel.add( new JLabel( "Visa Type" ) );
      visaTypeField = new JTextField();
      visaTypeField.setEditable( false );
      fieldPanel.add( visaTypeField );
      
      fieldPanel.add( new JLabel( "Major" ) );
      majorField = new JTextField();
      majorField.setEditable( false );
      fieldPanel.add( majorField );

      
 
      JButton nextBttn = new JButton( "Next" );
      nextBttn.addActionListener(
         // anonymous inner class to handle button event
         new ActionListener() {
            public void actionPerformed( ActionEvent event )
            {     
                if (emprecEnum.hasMoreElements()) {
                  // Display next emprec in popup 
                    Emprec emprec = (Emprec)(emprecEnum.nextElement());          
                    populatePopup(emprec);          
                } else {
                  // We've displayedd all of the emprec
                  // Display the table
                  setVisible(false); 
                  getContentPane().remove(popup);
                  getContentPane().add( scroller, BorderLayout.CENTER );// Now add the JTable
                  setSize( 450, 150 );
                  validate();
                  setVisible(true);                  
                }
            }
         }  // end anonymous inner class         
      ); // end call to addActionListener
      bttnPanel.add( nextBttn, BorderLayout.CENTER );    
      
      popup.add( fieldPanel, BorderLayout.NORTH );
      popup.add( bttnPanel, BorderLayout.SOUTH );      
   }//getPopup
   
   private void populatePopup(Emprec emprec)
   {
       if (emprec == null) return;
       
       nameField.setText( emprec.getName() );
       addressField.setText( emprec.getAddress() );
       socsecField.setText( emprec.getSocsec() );
       visaTypeField.setText( emprec.getVisaType() );
       majorField.setText( emprec.getMajor() );
      
   }
   
   private void getTable()
   {
      Statement statement;
      ResultSet resultSet;
      
      try {
         String query = "SELECT * FROM Employees";
         statement = connection.createStatement();
         resultSet = statement.executeQuery( query );
         displayResultSet( resultSet );
         statement.close();
      }
      catch ( SQLException sqlex ) {
         sqlex.printStackTrace();
      }
   }// getTable
   
   private void displayResultSet( ResultSet rs )
      throws SQLException
   {
      // position to first record
      boolean moreRecords = rs.next();
      // If there are no records, display a message
      if ( ! moreRecords ) {
         JOptionPane.showMessageDialog( this, "ResultSet contained no records" );
         setTitle( "No records to display" );
         return;
      }
      
      setTitle( "Employees" );
      Vector columnHeads = new Vector();
      Vector rows = new Vector();
      emprecs = new Vector();
      try {
         // get column heads
         ResultSetMetaData rsmd = rs.getMetaData();
      
         for ( int i = 2; i <= 4; ++i ) 
            columnHeads.addElement( rsmd.getColumnName( i ) );
			
		
			
			
         // get row data
         do {
            rows.addElement( getNextRow( rs, rsmd ) ); 
         } while ( rs.next() );
         // display table with ResultSet contents
         table = new JTable( rows, columnHeads );
         scroller = new JScrollPane( table );
		table.setAutoCreateRowSorter(true);
      }
      catch ( SQLException sqlex ) {
         sqlex.printStackTrace();
      }
   }// displayResultSet
   
   private Vector getNextRow( ResultSet rs, 
                              ResultSetMetaData rsmd )
       throws SQLException
   {
     Vector currentRow = new Vector();
      
    
           
        String str_name ="";
        String str_address="";
        String str_socsec="";
        String str_visaType="";
        String str_major="";
              
      
        try {
             str_name =rs.getString("Name");
            str_address=rs.getString("Address");
            str_socsec=rs.getString("SocialSecurityNumber");
            str_visaType=rs.getString("VisaType");
            str_major=rs.getString("Major");
                       
        } catch(NumberFormatException errmsg) {
            System.out.println("Invalid format "+ errmsg);
           
        }

        currentRow.addElement( str_name );
        currentRow.addElement( str_address );
        currentRow.addElement( str_socsec );
        currentRow.addElement( str_visaType );
        currentRow.addElement( str_major );
        
        
        //Use constructor that passes actual data types
        Emprec employee22=new Emprec(str_name,str_address,str_socsec,str_visaType,str_major);

        //Save our Emprecs, we'll display them later
        emprecs.addElement(employee22);        
        System.out.println(employee22); 
   
       // break;
     
      
     return currentRow;
   }// getNextRow
   
   public void shutDown()
   {
      try {
         connection.close();
      }
      catch ( SQLException sqlex ) {
         System.err.println( "Unable to disconnect" );
         sqlex.printStackTrace();
      }
   }// shutDown
   
   public static void main( String args[] ) 
   {
      final TableDisplay app = new TableDisplay();
      app.addWindowListener( 
         new WindowAdapter() {
            public void windowClosing( WindowEvent e ) 
            {  
               app.shutDown();
               System.exit( 0 );
            }
         }
      );
   }// main
}// TableDisplay
 