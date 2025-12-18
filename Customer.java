import java.util.ArrayList;

public class Customer {

    // static variables and instance variables

    static final String Company = "CVS";
    static ArrayList<Customer> CUSTOMERS = new ArrayList<>();
    static Counter COUNTER;

    String name; // name of customer
    String geography; // geography or location of customer
    int ID; // customer ID

    // constructor for the customer

    public Customer(String name, String geography) {
        this.name = name;
        this.geography = geography;

        // gets the unique ID from the counter class
        this.ID = Customer.COUNTER.getCount();

        // increments the counter
        Customer.COUNTER.increment();

        Customer.CUSTOMERS.add(this);
    }

    // methods

    // prints all customers in the given list out.
    public static void printAllCustomers() {

        System.out.println("All Customers: ");

        for (Customer customer : Customer.CUSTOMERS) {

            System.out.println(customer);

        }
        System.out.println("\n");
    }

    // comparing two customers' attributes (name and geography)
    public boolean equals(Object obj) {
        // Casting the object to the customer
        Customer other = (Customer) obj;

        if (this.name.equals(other.name) && this.geography.equals(other.geography)) {
            return true;
        }
        return false;
    }

    // returns name, company, and geography of customer
    public String toString() {
        return this.ID + ": " + this.name + ", Company: " + Customer.Company + ", Location: " + this.geography;
    }

    // Searches for given customer throughout the list. Returns -1 if not found.
    public static int findCustomer(Customer customer) {
        int index = -1;

        for (int i = 0; i < Customer.CUSTOMERS.size(); i++) {
            if (Customer.CUSTOMERS.get(i).equals(customer)) {
                index = i;
                break;
            }
        }

        return index;
    }

    // removing a customer from the customer list
    public static void removeCustomer(Customer customer) {

        int removeIndex = Customer.findCustomer(customer);

        // checking for valid index
        if (removeIndex >= 0) {
            Customer.CUSTOMERS.remove(removeIndex);
        }
    }

    public static void main(String[] args) {

        // initializing the counter for generating unique IDs
        Customer.COUNTER = new Counter(1);

        // create customer
        Customer c1 = new Customer("Mark", "Los Angeles");

        // printing customers
        Customer.printAllCustomers();

        Customer c2 = new Customer("Louise", "New York City");

        Customer.printAllCustomers();

        Customer c3 = new Customer("Jeffrey", "Australia");

        Customer.printAllCustomers();

        Customer.removeCustomer(c1);

        Customer.printAllCustomers();

    }
}
