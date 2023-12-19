import java.util.*;

/* Name: Chris Laird
* Class: PROG24178 1231_18326, Winter 2023
* Assignment: Assignment #2 – Avengers
* Date: February 20, 2023
* Program: PROG24178_Assignment3_Laird.java
* Creating 3 different methods that will check
* an ArrayList of Avenger objects, the methods
* check the list, return the best Avenger, return a list of
* the most costly Avengers, and removes Avengers that are null 
* in the list or whose force isn't strong enough and returns
* how many Avengers were removed
*/

/**
 * Requirements:
 * 1. Replace FirstName LastName in file and class names with your own names.
 * 2. Finish all TODOs. Test your code using provided main().
 * 3. Do NOT modify ANY provided code.
 */

//A provided class representing Avenger
class Avenger {
    private long id;
    private String name;
    private double force;
    private double salary;
    public Avenger() { }
    public Avenger(long id, String name, double force, double salary) {
        this.id = id; this.name = name; this.force = force; this.salary = salary; }
    public long getId() {
        return id;
    }
    public void setId(long id) { this.id = id; }
    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }
    public double getForce() {
        return force;
    }
    public void setForce(double force) { this.force = force; }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) { this.salary = salary; }
    @Override
    public String toString() { return "\nAvenger{" + "id=" + id + ", name=" + name + ", force=" + force + ", salary=" + salary + "}"; }
}

public class PROG24178_Assignment3_Laird {

    public static void main(String[] args) {
        System.out.println("\n**. Testing methods using null...");
        System.out.println("== Best avenger is: " + AvengerOperator.getBestAvenger(null));
        System.out.println("== Costy avengers are: " + AvengerOperator.getCostyAvengers(null, 6000));
        System.out.println("== Removed " + AvengerOperator.removeWeakAvengers(null, 50.0));

        ArrayList<Avenger> avengers = new ArrayList<>();
        avengers.addAll(Arrays.asList(
                new Avenger(24171, "Captain America", 92.1, 8765.43),
                new Avenger(24172, "Black Widow", 81.2, 5678.90),
                new Avenger(24173, "Iron Man", 94.3, 7890.12),
                new Avenger(24174, "Spiderman", 90.4, 4567.89),
                new Avenger(24175, "Dr. Strange", 89.5, 6543.21),
                new Avenger(24176, "Hulk", 93.5, 5432.10),
                new Avenger(24177, "Thor", 92.5, 6789.01), null, null
        ));
        System.out.println("\n**. Testing methods using avengers...");
        System.out.println("== Best avenger is: " + AvengerOperator.getBestAvenger(avengers));
        System.out.println("== Costy avengers are: " + AvengerOperator.getCostyAvengers(avengers, 7000));
        System.out.println("== Removed (min force = 92.0): " + AvengerOperator.removeWeakAvengers(avengers, 92.0)
                + ", current avengers are: " + avengers);
        System.out.println("== Removed (min force = 99.0): " + AvengerOperator.removeWeakAvengers(avengers, 99.0)
                + ", current avengers are: " + avengers);

        System.out.println("\n**. Testing methods using empty list...");
        avengers.clear();
        System.out.println("== Best avenger is: " + AvengerOperator.getBestAvenger(avengers));
        System.out.println("== Costy avengers are: " + AvengerOperator.getCostyAvengers(avengers, 6000));
        System.out.println("== Removed " + AvengerOperator.removeWeakAvengers(avengers, 50.0)
                + ", current avengers are: " + avengers);
    }
}

//A utility class containing 3 static methods for operating avenger list
class AvengerOperator {

    /* == Do NOT modify any code above this line == */

    /**
     * TODO #1: write a public method named getBestAvenger that,
     * given an array list of avengers as the argument, returns an
     * avenger whose force divided by salary is the highest, or returns
     * null if there is nothing to return
     */
     
     /*
      * Creating a public static method named getBestAvenger that will 
      * take an array list as its parameter and return an Avenger Object
      */
     public static Avenger getBestAvenger(ArrayList<Avenger> avengers){

        if(avengers == null || avengers.isEmpty())//check if the list is null or empty
            return null;//if it is, will return null

        Avenger bestAvenger = new Avenger();//creating a new avenger object

        /*
         * This enhanced for loop is checking to see if the objects in the 
         * list arent null, the force isn't 0 and the salary of that avenger 
         * isn't 0, if it passes then the bestAvenger will be temporarily set
         */
        for(Avenger a : avengers){

            if(a != null && a.getForce() != 0 && a.getSalary() != 0)
                bestAvenger = a;

        }

        /*
         * In this enhanced for loop is again making sure the object in the list isnt
         * null, and devides the avengers force by their salary, and if its greater than
         * the temporary bestAvenger, a new best avenger will be set 
         */
        for(Avenger a : avengers){

            if(a != null && 
            a.getForce() / a.getSalary() > bestAvenger.getForce() / bestAvenger.getSalary())
                bestAvenger = a;     

        }
        
        return bestAvenger;//returning the bestAvenger object

     }

	 

    /**
     * TODO #2: write a public method named getCostyAvengers that,
     * given an array list of avengers as the argument, returns a new array list of
     * avengers whose salary is more than the given minimum salary, or returns
     * an empty array list (Note: not null) if there is nothing to return
     */

     /*
      * Creating a public statice method named getCostyAvengers that takes
      * a list of Avengers and a double value for minSalary and returns 
      * a list of Avenger objects
      */
     public static List<Avenger> getCostyAvengers(ArrayList<Avenger> avengers, double minSalary){

        /*
         * Creating an empty list
         * for costyAvengers
         */
        List<Avenger> costyAvengers = new ArrayList<>();

        if(avengers == null || avengers.isEmpty())//check if list is null or empty
            return costyAvengers;//if so return costyAvengers

        /*
         * In this enhanced for loop its checking to see if
         * the object in the list is null and the avengers
         * salary is greater than the minimum salary inputted
         * if it passes this validation the avenger will get added 
         * to the list of costy avengers 
         */
        for(Avenger a : avengers){

            if(a != null && a.getSalary() > minSalary){
                costyAvengers.add(a);
            }

        }

        
        return costyAvengers;//returns the list of costy Avengers

    }
	 

    /**
     * TODO #3: write a public method named removeWeakAvengers that,
     * given an array list of avengers and the minimum required force as two arguments,
     * removes null avengers or those whose force is less than the minimum force,
     * and returns the number of avengers being removed
     */

     /*
      * Creating a public static method named removeWeakAvengers that takes a 
      * list of Avengers and a double value for minimum required force as parameters
      * and returns an int value of how many Avengers were removed
      */
     public static int removeWeakAvengers(ArrayList<Avenger> avengers, double minReqForce){

        if(avengers == null || avengers.isEmpty())//check if the list is null or empty
            return 0;//if it is, returns 0
        
        int removed = 0;//creating an int variable for the amount removed

        /*
         * Creating a regular for loop that creates a new
         * Avenger object and sets it to the avenger at the
         * index in the list, it then checks if that Avenger
         * is either null or their force is less than the minimum 
         * required force, if it is the avenger will be removed 
         * from the list, the index will also decrement because
         * the list size has gone down one, and the removed count 
         * will increase 1
         */
        for(int i = 0; i < avengers.size(); i++){

            Avenger a = avengers.get(i);

            if (a == null || a.getForce() < minReqForce){

                avengers.remove(a);

                i--;

                removed++;

            }

        }

        return removed;// returns the amount of Avengers removed

     }
	 

} // End of AvengerOperator class
