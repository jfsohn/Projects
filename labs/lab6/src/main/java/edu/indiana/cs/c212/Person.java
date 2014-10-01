package edu.indiana.cs.c212;

public abstract class Person implements Comparable<Person> {
	
	//FIXME
	/**
	 *
	 * A person is a class that has a String firstName, and a String lastName
	 */
	private String firstName;
	private String lastName;

    Person(){

    }

    /**
     * A constructor that takes Strings firstName and lastName
     * and initializes their respective fields.
     * @param firstName The Person's first name
     * @param lastName The Person's last name
     */
    public Person(String firstName, String lastName){
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    /**
     * Write a constructor that takes one string of the form
     * "FirstName LastName" and initializes this class' fields appropriately.
     * This is to say that all strings passed in will be non-null and be of the form
     * in which the first name is followed by the lastname and they are separated by one
     * or more whitespace character(s)
     * @param name The name of the Person
     */
    public Person(String name){
      //FIXME
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName(){
        return firstName + lastName;
    }

    public void setName(String name){
        //FIXME
    }


    @Override
    public int compareTo(Person other) {
        return 0;
    }
}
