package binarySearchTree;
import java.io.*;
public class BinarySearchTree {
	//Node yapısını oluşturulur.
	static class Node{
		int accountID;
		String name;
		String branch;
		double balance;
		Node left,right;
			
		//constructor
		public Node(int accountID,String name,String branch,double balance) {
			this.accountID=accountID;
			this.name=name;
			this.branch=branch;
			this.balance=balance;
			this.left=this.right=null;
			}
	}
		
	private Node root;
			
			//insert için method
	public void insert(int accountID,String name,String branch,double balance) {
		root=insertRecursive(root,accountID,name,branch,balance);
				
	}
	private Node insertRecursive(Node root,int accountID,String name,String branch,double balance) {
		if (root==null) {
			root= new Node(accountID, name, branch, balance);
			return root;
		}
		if (accountID<root.accountID) {
			root.left=insertRecursive(root.left, accountID, name, branch, balance);				
		}
		else if (accountID>root.accountID) {
			root.right=insertRecursive(root.right, accountID, name, branch, balance);
		}
		return root;
	}
			
			//search için işlemler
	public Node search(int accountID) {
		return searchRecursive(root,accountID);
	}
	private Node searchRecursive(Node root,int accountID) {
		if (root==null || root.accountID==accountID) {
			return root;
		}
		if (accountID<root.accountID) {
			return searchRecursive(root.left, accountID);
		}
		else if (accountID>root.accountID) {
			return searchRecursive(root.right, accountID);
		}
		return root;
	}
			
			//sıralama işlemleri
	public void printInOrder() {
		printInOrderRecursive(root);
	}
	private void printInOrderRecursive(Node root) {
		if (root!=null) {
			printInOrderRecursive(root.left);
			System.out.println(root.accountID+", "+root.name+", "+root.branch+", "+"Balance: "+root.balance);
			printInOrderRecursive(root.right);
		}
	}
		
	//deposit işlemleri
	public void deposit(int accountID,double amount) {
			//önce işlemi gerçekleştireceğimiz hesabı bulduk.
		Node node=search(accountID);
						
		if (node!=null) {
			node.balance+=amount;
			System.out.println("Updated Account :"+node.accountID+", "+node.name+", Balance: "+node.balance+"\n");
			updateFile();
		}else {
			System.err.println("Account not found in the bank system!");
		}
	}
					
	//withdraw işlemleri
	public void withdraw(int accountID,double amount) {
		//önce işlemi gerçekleştireceğimiz hesabı bulduk.
		Node node=search(accountID);
						
		if (node!=null) {
		//negatif bir sonuç çıkmaması için kontroller
			if (node.balance>=amount) {
				node.balance-=amount;
				System.out.println("Updated Account :"+node.accountID+", "+node.name+", Balance: "+node.balance+"\n");
				updateFile();
			}else {
				System.err.println("Insufficient balance!");
			}
			}else {
				System.err.println("Account not found in the bank system!");
			} 
	}			
					
	void updateFile() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("inputBST.txt"))) {
		        // Dosyaya tüm hesapları tekrar yaz
		        writeAllAccounts(writer);
		    } catch (IOException e) {
		        System.err.println("Error updating file: " + e.getMessage());
		    }
		}
		private void writeAllAccounts(BufferedWriter writer) throws IOException {
		    // Tüm hesapları dosyaya yaz
		    printInOrder(writer);
		}
		private void printInOrder(BufferedWriter writer) throws IOException {
		    printInOrderRecursive(root, writer);
		}
	
		private void printInOrderRecursive(Node root, BufferedWriter writer) throws IOException {
			if (root != null) {
			        printInOrderRecursive(root.left, writer);
			        writer.write(root.accountID + ", " + root.name + ", " + root.branch + ", " + root.balance + "\n");
			        printInOrderRecursive(root.right, writer);
			}
		}
}

