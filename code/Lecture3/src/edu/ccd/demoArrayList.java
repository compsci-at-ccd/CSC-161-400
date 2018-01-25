package edu.ccd;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * <h1>Demonstation of ArrayList</h1>
 * This class will be used to demonstrate ArrayList
 **
 * @author  Charles LaHeist
 * @version 1.0
 * @since   2018-01-24
 */
public class demoArrayList {

    public ArrayList<Person> Personnel = new ArrayList<>();

    public demoArrayList() {

        //add a few items (as anonymous objects)
        Personnel.add(new Person("Mark"));
        Personnel.add(new Person("Dave"));
        Personnel.add(new Person("Susan"));
        Personnel.add(new Person("Bill"));
        Personnel.add(new Person("Jane"));

        //set an item (change through 'set'
        Personnel.set(4,new Person("Jerome"));
        //get an item and output
        System.out.println( "What is the size? =>" + Personnel.size() );
        System.out.println( "Who's first? =>" + Personnel.get(4).whoami() );

        //iterate with for(<type> name: <ArrayList>)
        System.out.print("The people in the array are: ");
        for ( Person them: Personnel){
            System.out.print(them.whoami() + ", ");
        }
        System.out.println();

        //iterate with Iterator<type> name=arraylist.iterator();
        //Iterator<Person> mypeeps = Personnel.listIterator(0);
        //System.out.println("My iterator points to: " +((Person)mypeeps).whoami());

        //example of a management nicety: contains, equals, addAll
    }
}
