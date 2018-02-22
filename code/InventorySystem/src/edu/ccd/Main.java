package edu.ccd;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        float total_of_inventory_value = 0.0f;

        Notifications notify = new Notifications();
        MobileNotification mnote = new MobileNotification();
        Notifier notifier = notify;
        InventoryItem mystuff[] = { new CPU("Dell XPS Laptop", 1000f),
                                    new Monitor("Dell monitor",300f),
                                    new Keyboard("DasKeyboard", 150f)};
	    System.out.println("Inventory system started.");

	    InventoryItem.displayReportHeader();

	    for(int index = 0; index < mystuff.length; ++index) {
	        mystuff[index].displayDetail();
	        total_of_inventory_value+=mystuff[index].getValue();
            notifier.displayNotification("Inventory number " + mystuff[index].getInventoryNumber() + " is " + mystuff[index].getName());
        }
        System.out.println("My inventory value is $" + total_of_inventory_value);
        InventoryItem.displayTotalItemsInInventory();


        CPU concreteItem = new CPU("Something",300f);
        
        InventoryItem abstractItem = ((InventoryItem)concreteItem);

        System.out.println("This is concreteItem as a String " + concreteItem.toString());
        System.out.println("This is abstractItem as a String " + abstractItem.toString());

        concreteItem.iAmACPU();
        //but I cannnot say testme.iAmACPU, because I am a InventoryItem...but am I?

        for(int jndex = 0; jndex < mystuff.length; ++jndex) {
            if (mystuff[jndex] instanceof InventoryItem)
                System.out.print(((InventoryItem) mystuff[jndex]).getName() + ", serial number: ");
            else
                System.out.print("Item not an inventory item.");

            if (mystuff[jndex] instanceof SerializedItem)
                System.out.println(((SerializedItem) mystuff[jndex]).getSerialnumber());
            else
                System.out.println("Item not serialized.");
        }

        if (abstractItem instanceof Keyboard)
            System.out.println("Yes!");
        else
            System.out.println("No!");

        //-- Workstation class testing space
        Workstation myWorkstation = new Workstation(new CPU("Lab Computer", 1500f), new Monitor("Dell ElCheapo", 1f), new Keyboard("DasKeyboard", 120f), new Mouse() );

        try {
            myWorkstation.addCPU(new CPU("Just bought this at Micro Center", 3900f));
        }
        catch (TooManyCPUsException e) {
            System.out.println(e.getMessage());
        }

    }
}
