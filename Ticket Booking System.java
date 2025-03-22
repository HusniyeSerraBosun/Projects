package lab2;

import java.util.Scanner;

public class Lab2 {

	public static void main(String[] args) {
        
        boolean[] seats = new boolean[10]; 
        Scanner userInput = new Scanner(System.in);  
        
        while (true) {
        	
        	boolean isFull = isPlaneFull(seats);
            if (isFull) {
                System.out.println("The plane is now full.");
            }
            
            System.out.println("Please type 1 for buying 'First Class' ticket");
            System.out.println("Please type 2 for buying 'Economy Class' ticket");
            System.out.println("Please type 3 for seat validation");
            System.out.print("Choice: ");
            
            int choice = userInput.nextInt();

            if (isFull && (choice == 1 || choice == 2)) {
                continue;
            }

            switch (choice) {
                case 1: {  // First class'tan koltuk almak için
                    if (!takeSeat(seats, 0, 4, "First Class")) {
                        System.out.println("There are no seats in first class. Do you prefer Economy Class?");
                        System.out.print("1.Yes  2.No  Choice: ");
                        int choice2 = userInput.nextInt();

                        if (choice2 == 1) {
                            if (!takeSeat(seats, 5, 9, "Economy Class")) {
                                System.out.println("There are no seats in Economy Class.");
                            }
                        } else {
                            System.out.println("Next flight leaves in 3 hours.");
                        }
                    }
                    break;
                }
                case 2: {  // Economy Class'tan koltuk almak için
                    if (!takeSeat(seats, 5, 9, "Economy Class")) {
                        System.out.println("There are no seats in economy class. Do you prefer First Class?");
                        System.out.print("1.Yes  2.No  Choice: ");
                        int choice2 = userInput.nextInt();

                        if (choice2 == 1) {
                            if (!takeSeat(seats, 0, 4, "First Class")) {
                                System.out.println("There are no seats in First Class");
                            }
                        } else {
                            System.out.println("Next flight leaves in 3 hours.");
                        }
                    }
                    break;
                }
                case 3: {  // Koltuk ID sine göre koltuğun durumunu kontrol etmek için
                    System.out.print("Enter seat ID which will be validated:  ");
                    int seatNumber = userInput.nextInt();
                    
                    if (seatNumber >= 1 && seatNumber <= 5) {
                        seatValidation(seats, seatNumber - 1, "First Class");
                    } else if (seatNumber >= 6 && seatNumber <= 10) {
                        seatValidation(seats, seatNumber - 1, "Economy Class"); 
                    } else {
                        System.out.println("There is no seat with this ID");
                    }
                    break;
                }
                
                default: {
                    System.out.println("Invalid choice, please try again.");
                    break;
                } 
                
            } 
        }
        
    }

    // Koltuk satın almak için metod
    public static boolean takeSeat(boolean[] seats, int start, int end, String className) {
        for (int i = start; i <= end; i++) {
            if (!seats[i]) { 
                seats[i] = true;
                System.out.println(className + " seat number " + (i + 1) + " Ticket is bought.");
                return true;
            }
        }
        return false; 
    }

    // Koltuk numarasına göre koltuğun durumunu kontrol eden metod
    public static void seatValidation(boolean[] seats, int seatNumber, String className) {
        if (seats[seatNumber]) {
            System.out.println(className + " seat " + (seatNumber + 1) + " Ticket is sold.");
        } else {
            System.out.println(className + " seat " + (seatNumber + 1) + " is available.");
        }
    }

    // Uçağın dolu olup olmadığını kontrol eden metod
    public static boolean isPlaneFull(boolean[] seats) {
        for (int s = 0; s < seats.length; s++) {
            if (!seats[s]) {
                return false;  // koltuk var,uçak dolmamış
            }
        }
        return true;  //  uçak dolmuş

	}

}
