package tabledisplay;

import java.text.*;

class Emprec {
    String name;
    String address;
    String socsec;
    String visaType;
    String major;


Emprec (String name,String address,String socsec,String visaType,String major)
{
    this.name=name;
    this.address=address;
    this.socsec=socsec;
    this.visaType=visaType;
    this.major=major;
    
}

public String toString() 
{ 
    return
        ("\n your name is "+ this.name+
        "\n your address is "+ this.address+
        "\n your social security is "+ this.socsec +"\n your visa type is "+ this.visaType +
        "\n your major is "+ this.major
         );
}

public String getName()
{
    return this.name;
}

public String getAddress()
{
    return this.address;
}

public String getSocsec()
{
    return this.socsec;
}

public String getVisaType()
{
	return this.visaType;
}

public String getMajor()
{
	return this.major;
}

}
