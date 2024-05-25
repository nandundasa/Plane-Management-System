// Class to represent a person
public class Person {
    // Instance variables to store name, surname, and email
    private  String name;
    private String surname;
    private String email;

    // Constructor with parameters to initialize name, surname, and email
    public Person(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // Getter method for retrieving the name
    public String getName(){
        return  name;
    }
    // Setter method for setting the name
    public void setName(String name){
        this.name=name;
    }
    // Getter method for retrieving the surname
    public String getSurname(){
        return surname;
    }
    // Setter method for setting the surname
    public void setSurname(String surname) {
        this.surname = surname;
    }
    // Getter method for retrieving the email
    public String getEmail(){
        return email;
    }
    // Setter method for setting the email
    public void setEmail(String email) {
        this.email = email;
    }
}
