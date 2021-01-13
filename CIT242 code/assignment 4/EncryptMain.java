package assignment4;

import java.util.Scanner;

public class EncryptMain {

	public static void main(String []args) {
		int choice;
		Scanner input = new Scanner(System.in);
		EncryptDecrypt EAD = new EncryptDecrypt();
		String name;
		
		while(true) {
			System.out.println("Please press 1 insert the date you want to put in");
			System.out.println("Please press 2 if you want to quit");
			
			choice = input.nextInt();
			Scanner inputName = new Scanner(System.in);
			switch(choice) {
				case 1: 
					System.out.println("Enter full name you want to insert in");
					name = inputName.nextLine();
					EAD.jiinput(name);
					
					System.out.println("Please press 1 to encrypt your data");
					System.out.println("Please press 2 to decrypt your data");
					System.out.println("Please press 3 if you want to quit");
					choice = input.nextInt();
			///////////////////////////////////////////////////////////////////////////////////	
					switch(choice) {
					case 1: 
						if(EAD.getSize() > 0) {
							EAD.jisangEncrypt();
							}
							else
								System.out.println("No data. Please check your data.");
			///////////////////////////////////////////////////////////////////////////////////	
						System.out.println("Please press 1 to display your data");
						System.out.println("Please press 2 if you want to quit");
						choice = input.nextInt();
						switch(choice) {
						case 1:
							EAD.jioutput();
							break;
						case 2:
							System.out.println("Do not come back lol");
							System.exit(0);
						default:
							System.out.println("This is not option. Try again");
							}
							break;
					case 2:
						if(EAD.getSize() > 0) {
							EAD.jisangDecrypt();
							
							}
							else
								System.out.println("No data. Please check your data.");
						System.out.println("Please press 1 to display your data");
						System.out.println("Please press 2 if you want to quit");
						choice = input.nextInt();
						switch(choice) {
						case 1:
							EAD.jioutput();
							break;
						case 2:
							System.out.println("Do not come back lol");
							System.exit(0);
						default:
							System.out.println("This is not option. Try again");
							}
							break;
					case 3:
						System.out.println("Do not come back lol");
						System.exit(0);
					default:
						System.out.println("You enter the wrong choice.");
						}
					break;
				case 2:
					System.out.println("Do not come back lol");
					System.exit(0);
				default:
					System.out.println("You enter the wrong choice.");		
				}
			}
		}
	}

