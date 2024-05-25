// Import necessary packages
import java.util.Arrays;
import java.util.Scanner;

// Class to manage plane seating
public class PlaneManagement {
    // Array to represent seat availability for each row
    static int[] A = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] B = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] C = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] D = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    // Array to store Ticket objects
    static Ticket[] tickets = new Ticket[52];
    static int ticketCount = 0;

    public static void main(String[] args) {
        // Scanner for user input
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to the Plane Management application");
        boolean exitMenu = false;
        while (!exitMenu) {
            // Display menu options
            System.out.println("***************************************");
            System.out.println("*           Menu Options              *");
            System.out.println("***************************************");
            System.out.println("1) Buy a seat");
            System.out.println("2) Cancel a seat");
            System.out.println("3) Find first available seat");
            System.out.println("4) Show seating plan");
            System.out.println("5) Print tickets information and total sales");
            System.out.println("6) Search ticket");
            System.out.println("0) Quit");
            System.out.println("***************************************");
            System.out.println("Please select an option:");
            // Read user's option
            String userOption = userInput.nextLine();
            // Switch statement to handle user options
            switch (userOption) {
                case "1" -> buy_seat(userInput);
                case "2" -> cancel_seat();
                case "3" -> find_first_available();
                case "4" -> show_seating_plan();
                case "5" -> print_tickets_info();
                case "6" -> search_ticket();
                case "0" -> {
                    exitMenu = true;
                    System.out.println("Thank you!!! See you again...");
                }
                default -> System.out.println("Invalid option selected");
            }
        }
    }

    // Method to buy a seat
    public static void buy_seat(Scanner userInput) {
        try {
            Scanner buySeatUserInput = new Scanner(System.in);
            System.out.println("Please enter the row(A-D):");
            String rowLetter = buySeatUserInput.nextLine().toUpperCase();

            if (!(rowLetter.equals("A") || rowLetter.equals("B") || rowLetter.equals("C") || rowLetter.equals("D"))) {
                System.out.println("Invalid row letter.");
                return;
            }
            System.out.println("Please enter the seat number:");
            int seatNumber = Integer.parseInt(buySeatUserInput.nextLine()) - 1;

            double price;
            // Determine price based on seat number
            if (seatNumber >= 0 && seatNumber <= 4) {
                price = 200.0;
            } else if (seatNumber >= 5 && seatNumber <= 8) {
                price = 150.0;
            } else if (seatNumber >= 9 && seatNumber <= 13) {
                price = 180.0;
            } else {
                System.out.println("Invalid seat number.");
                return;
            }
            // Gather person information
            System.out.println("Enter person information:");
            System.out.print("Name: ");
            String name = userInput.nextLine();
            System.out.print("Surname: ");
            String surname = userInput.nextLine();
            System.out.print("Email: ");
            String email = userInput.nextLine();

            // Create Person object
            Person person = new Person(name, surname, email);
            person.setName(name);
            person.setSurname(surname);
            person.setEmail(email);

            // Create Ticket object
            Ticket ticket = new Ticket(rowLetter, seatNumber + 1, price, person);
            tickets[ticketCount++] = ticket;
            ticket.printTicketInfo();

            // Mark seat as occupied in the corresponding row
            switch (rowLetter) {
                case "A":
                    A[seatNumber] = 1;
                    System.out.println(Arrays.toString(A));
                    System.out.println(Arrays.toString(B));
                    System.out.println(Arrays.toString(C));
                    System.out.println(Arrays.toString(D));
                    break;
                case "B":
                    B[seatNumber] = 1;
                    System.out.println(Arrays.toString(A));
                    System.out.println(Arrays.toString(B));
                    System.out.println(Arrays.toString(C));
                    System.out.println(Arrays.toString(D));
                    break;
                case "C":
                    C[seatNumber] = 1;
                    System.out.println(Arrays.toString(A));
                    System.out.println(Arrays.toString(B));
                    System.out.println(Arrays.toString(C));
                    System.out.println(Arrays.toString(D));
                    break;
                case "D":
                    D[seatNumber] = 1;
                    System.out.println(Arrays.toString(A));
                    System.out.println(Arrays.toString(B));
                    System.out.println(Arrays.toString(C));
                    System.out.println(Arrays.toString(D));
                    break;
                default:
                    System.out.println("Invalid row letter.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter valid number.");
        }
    }

    // Method to cancel a seat
    public static void cancel_seat() {
        try {
            Scanner cancelSeatUserInput = new Scanner(System.in);
            System.out.println("Please enter the row(A, B, C, D):");
            String rowLetter = cancelSeatUserInput.nextLine().toUpperCase();
            System.out.println("Please enter the seat number:");
            int seatNumber = Integer.parseInt(cancelSeatUserInput.nextLine()) - 1;

            for (int i = 0; i < ticketCount; i++) {
                if (tickets[i] != null && tickets[i].getRow().equals(rowLetter) && tickets[i].getSeat() == seatNumber + 1) {
                    tickets[i] = null;

                    switch (rowLetter) {
                        case "A":
                            if (A[seatNumber] == 0) {
                                System.out.println("Seat is available.");
                            } else {
                                A[seatNumber] = 0;
                                System.out.println("Seat cancelled successfully.");
                            }
                            break;
                        case "B":
                            if (B[seatNumber] == 0) {
                                System.out.println("Seat is available.");
                            } else {
                                B[seatNumber] = 0;
                                System.out.println("Seat canceled successfully.");
                            }
                            break;
                        case "C":
                            if (C[seatNumber] == 0) {
                                System.out.println("Seat is available.");
                            } else {
                                C[seatNumber] = 0;
                                System.out.println("Seat canceled successfully.");
                            }
                            break;
                        case "D":
                            if (D[seatNumber] == 0) {
                                System.out.println("Seat is available.");
                            } else {
                                D[seatNumber] = 0;
                                System.out.println("Seat canceled successfully.");
                            }
                            break;
                        default:
                            System.out.println("Invalid row letter.");
                    }
                    return;
                }
            }
            System.out.println("No ticket found for the specified seat.");
        } catch (NumberFormatException e) {
            System.out.println("Enter valid seat number");
        }
    }

    // Method to find the first available seat
    public static void find_first_available() {
        int availableSeat;

        // Check row A for available seats
        for (int i = 0; i < 13; i++) {
            if (A[i] == 0) {
                availableSeat = i;
                System.out.println("First available seat: Row A, Seat " + (availableSeat + 1));
                return;
            }
        }
        // Check row B for available seats
        for (int i = 0; i < 11; i++) {
            if (B[i] == 0) {
                availableSeat = i;
                System.out.println("First available seat: Row B, Seat " + (availableSeat + 1));
                return;
            }
        }
        // Check row C for available seats
        for (int i = 0; i < 11; i++) {
            if (C[i] == 0) {
                availableSeat = i;
                System.out.println("First available seat: Row C, Seat " + (availableSeat + 1));
                return;
            }
        }
        // Check row D for available seats
        for (int i = 0; i < 13; i++) {
            if (D[i] == 0) {
                availableSeat = i;
                System.out.println("First available seat: Row D, Seat " + (availableSeat + 1));
                return;
            }
        }
        System.out.println("No available seats.");

    }

    // Method to display the seating plan
    public static void show_seating_plan() {
        System.out.println("Seating Plan:");
        // Display row A
        System.out.print("A: ");
        for (int seat : A) {
            System.out.print(seat == 0 ? "O " : "X ");
        }
        System.out.println();
        // Display row B
        System.out.print("B: ");
        for (int seat : B) {
            System.out.print(seat == 0 ? "O " : "X ");
        }
        System.out.println();
        // Display row C
        System.out.print("C: ");
        for (int seat : C) {
            System.out.print(seat == 0 ? "O " : "X ");
        }
        System.out.println();
        // Display row D
        System.out.print("D: ");
        for (int seat : D) {
            System.out.print(seat == 0 ? "O " : "X ");
        }
        System.out.println();
    }

    // Method to print tickets information and total sales
    public static void print_tickets_info() {
        double totalSales = 0.0;

        System.out.println("Tickets Information:");
        // Loop through tickets to print ticket information and calculate total sales
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                ticket.printTicketInfo();
                totalSales += ticket.getPrice();
            }
        }
        // Display total sales
        System.out.println("Total Sales: £" + totalSales);
    }

    // Method to search for a ticket
    public static void search_ticket() {
        try {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Please enter the row(A, B, C, D):");
            String rowLetter = userInput.nextLine().toUpperCase();
            System.out.println("Please enter the seat number:");
            int seatNumber = Integer.parseInt(userInput.nextLine()) - 1;

            boolean found = false;
            // Loop through tickets to find the specified ticket
            for (Ticket ticket : tickets) {
                if (ticket != null && ticket.getRow().equals(rowLetter) && ticket.getSeat() == seatNumber + 1) {
                    ticket.printTicketInfo();
                    found = true;
                    System.out.println("This seat is already booked!");
                    break;
                }
            }
            // If ticket is not found, indicate that the seat is available
            if (!found) {
                System.out.println("This seat is available.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter valid seat number");
        }
    }
}