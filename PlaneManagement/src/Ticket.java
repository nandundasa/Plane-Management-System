import java.io.FileWriter;
import java.io.IOException;

// Class to represent a ticket
public class Ticket {
    // Instance variables to store ticket information
    private String row;
    private int seat;
    private double price;
    private Person person;

    // Constructor to initialize ticket attributes
    public Ticket(String row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    // Getter method for retrieving the row
    public String getRow() {
        return row;
    }
    // Setter method for setting the row
    public void setRow(String row) {
        this.row = row;
    }
    // Getter method for retrieving the seat number
    public int getSeat() {
        return seat;
    }
    // Setter method for setting the seat number
    public void setSeat(int seat) {
        this.seat = seat;
    }
    // Getter method for retrieving the price
    public double getPrice() {
        return price;
    }
    // Setter method for setting the price
    public void setPrice(double price) {
        this.price = price;
    }
    // Getter method for retrieving the person associated with the ticket
    public Person getPerson() {
        return person;
    }
    // Setter method for setting the person associated with the ticket
    public void setPerson(Person person) {
        this.person = person;
    }
    // Method to print ticket information
    public void printTicketInfo() {
        System.out.println("Ticket Information:");
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: " + price);
        System.out.println("Person Information:");
        System.out.println("Name: " + person.getName());
        System.out.println("Surname: " + person.getSurname());
        System.out.println("Email: " + person.getEmail());
        save();
    }
    // Method to save ticket information to a file
    public void save() {
        String fileName = row + seat;

        try  {
            FileWriter fileWriter = new FileWriter(fileName+".txt");
            fileWriter.write("Ticket Information:\n");
            fileWriter.write("Row: " + row + "\n");
            fileWriter.write("Seat: " + seat + "\n");
            fileWriter.write("Price: " + price + "\n");
            fileWriter.write("Person Information:\n");
            fileWriter.write("Name: " + person.getName() + "\n");
            fileWriter.write("Surname: " + person.getSurname() + "\n");
            fileWriter.write("Email: " + person.getEmail() + "\n");
            fileWriter.flush();

            fileWriter.close();
            System.out.println("Ticket information saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while saving ticket information: " + e.getMessage());
        }
    }
}
