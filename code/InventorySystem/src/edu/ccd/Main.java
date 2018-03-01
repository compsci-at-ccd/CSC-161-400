package edu.ccd;

import java.util.ArrayList;

public class Main {

    public static void depositMoney(String routingnumber, float deposit_amount) {
        //Preconditions:
        assert deposit_amount > 0.0f : "Cannot deposit a debit";
        assert deposit_amount != 0.0f : "Non operation";
        assert !routingnumber.isEmpty() : "No routing number provided";

        float balance = deposit_amount;
        System.out.println("I am depositing at the bank: $" + deposit_amount);

        //Postconditions:
        assert balance > 0.0f : "No operating funds. Close the shop.  Everyone file for unemployment!";

    }

    public static void main(String[] args) {

        depositMoney("Operationsfunds", 3000f);

        float total_of_inventory_value = 0.0f;

        Notifications notify = new Notifications();
        MobileNotification mnote = new MobileNotification();
        Notifier notifier = notify;
        ArrayList<InventoryItem> mystuff = new ArrayList<InventoryItem>();
        try {
            if( InventoryItem.canCreate("myCPU") )
                mystuff.add(new CPU("myCPU", 3000f));
            if( InventoryItem.canCreate("") )
                mystuff.add(new Monitor("", 300f));
            if( InventoryItem.canCreate("DasKeyboard") )
                mystuff.add(new Keyboard("DasKeyboard", 150f));
        } catch (ComponentHasNoNameException e) {
            System.out.println(e);
        }
	    System.out.println("Inventory system started.");

	    InventoryItem.displayReportHeader();

	    for(int index = 0; index < mystuff.size(); ++index) {
	        mystuff.get(index).displayDetail();
	        total_of_inventory_value+=mystuff.get(index).getValue();
            notifier.displayNotification("Inventory number " + mystuff.get(index).getInventoryNumber() + " is " + mystuff.get(index).getName());
        }
        System.out.println("My inventory value is $" + total_of_inventory_value);
        InventoryItem.displayTotalItemsInInventory();

        CPU concreteItem = concreteItem = new CPU("Something", 300f);

        
        InventoryItem abstractItem = ((InventoryItem)concreteItem);

        System.out.println("This is concreteItem as a String " + concreteItem.toString());
        System.out.println("This is abstractItem as a String " + abstractItem.toString());

        concreteItem.iAmACPU();
        //but I cannnot say testme.iAmACPU, because I am a InventoryItem...but am I?

        for(int jndex = 0; jndex < mystuff.size(); ++jndex) {
            if (mystuff.get(jndex) instanceof InventoryItem)
                System.out.print(((InventoryItem) mystuff.get(jndex)).getName() + ", serial number: ");
            else
                System.out.print("Item not an inventory item.");

            if (mystuff.get(jndex) instanceof SerializedItem)
                System.out.println(((SerializedItem) mystuff.get(jndex)).getSerialnumber());
            else
                System.out.println("Item not serialized.");
        }

        if (abstractItem instanceof CPU)
            System.out.println("Yes!");
        else
            System.out.println("No!");

        //-- Workstation class testing space
        Workstation myWorkstation = new Workstation(new CPU("Lab Computer", 1500f), new Monitor("Dell ElCheapo", 1f), new Keyboard("DasKeyboard", 120f), new Mouse());

        try {
            if (InventoryItem.canCreate("Just bought this at Micro Center"))
                myWorkstation.addInventoryItem(new CPU("Just bought this at Micro Center", 3900f));
        }
        catch (DuplicateItemException e) {
            System.out.println(e.getMessage());
        }
        catch (ComponentHasNoNameException ce) {
            System.out.println(ce.getMessage());
        }

        Workstation newWorkstation = new Workstation();

        try {
            newWorkstation.addInventoryItem(new Monitor("Monitor1", 100f));
        }
        catch (DuplicateItemException e) {
            System.out.println(e.getMessage());
        }

        try {
            newWorkstation.addInventoryItem(new Monitor("Monitor2", 100f));
        }
        catch (DuplicateItemException e) {
            System.out.println(e.getMessage());
        }
        try {
            newWorkstation.addInventoryItem(new Monitor("Monitor3", 100f));
        }
        catch (DuplicateItemException e) {
            System.out.println(e.getMessage());
        }
    }
}
