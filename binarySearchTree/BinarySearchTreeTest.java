package binarySearchTree;
import java.io.*;
import java.util.*;
import java.util.Locale;

import binarySearchTree.BinarySearchTree.Node;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree BST=new BinarySearchTree();
		
		//Dosya işlemleri
		File file=new File("inputBST.txt");
		if (file.exists() || file.isFile()) {
			Scanner fileScan=null;
			try {
				fileScan= new Scanner(file);
				while (fileScan.hasNextLine()) {
					String line=fileScan.nextLine();
					String[]value=line.split(", ");
					
					int accountID=Integer.parseInt(value[0]);
					String name=value[1];
					String branch=value[2];
					double balance=Double.parseDouble(value[3]);
					
					BST.insert(accountID, name, branch, balance);
				}
			} catch (Exception e) {
				System.err.println("ERROR! File cannot read"+e.getMessage());
			}finally {
				if (fileScan != null) {
					fileScan.close();
				}
			}
		}else {
			System.out.println("File inputBst.txt not found. Please make sure it exists.");
            return;
		}
		
		//Menu
		Scanner scanner=new Scanner(System.in);
		scanner.useLocale(Locale.US);
		
		System.out.println("Welcome to ADU Bank"+
				 		   "\nPlease select the operation you want to make: ");
		while(true) {
			System.out.println("1)Insert a new account"+
							   "\n2)Search for an account"+
							   "\n3)Deposit money"+
							   "\n4)Withdraw money"+
							   "\n5)Print in order"+
							   "\n6)Exit");
			System.out.print("Your choice: ");
			
			int choice=scanner.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Enter accountID,name,branch,balance:");
					
					int accountID=scanner.nextInt();
					scanner.nextLine();
					String name=scanner.nextLine();
					String branch=scanner.nextLine();
					double balance=scanner.nextDouble();
					
					BST.insert(accountID, name, branch, balance);
					BST.updateFile();
					
					System.out.println("Account added successfully.");
					break;
				case 2:
					System.out.println("Enter accountID you want to search: ");
					 accountID=scanner.nextInt();
					Node node=BST.search(accountID);
					if (node!=null) {
						System.out.println("Account found: "+node.accountID+
										   ", "+node.name+", "+node.branch+
										   " Balance: "+node.balance);
					}else {
						System.err.println("Account not found in the binary search tree.");
					}
					break;
				case 3:
					System.out.println("Enter accountID: ");
					accountID=scanner.nextInt();
					System.out.println("Enter deposit amount: ");
					double deposit=scanner.nextDouble();
					BST.deposit(accountID,deposit);
					break;
				case 4:
					System.out.println("Enter accountID: ");
					accountID=scanner.nextInt();
					System.out.println("Enter withdraw amount: ");
					double withdraw=scanner.nextDouble();
					BST.withdraw(accountID,withdraw);
					break;
				case 5:
					BST.printInOrder();
					break;
				case 6:
					System.out.println("Exiting...");
					scanner.close();
					return;
				default:
					System.err.println("Invalid option! Please Try Again.");
			}
			
		}
		
	}
}
