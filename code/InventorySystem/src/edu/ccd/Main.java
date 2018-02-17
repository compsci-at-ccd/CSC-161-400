package edu.ccd;

public class Main {


    public static void main(String[] args) {
        Notifications notify = new Notifications();
        MobileNotification mnote = new MobileNotification();
        Notifier notifier = notify;
        InventoryItem mystuff[] = { new CPU("Dell XPS Laptop", 1000f),
                                    new Monitor("Dell monitor",300f),
                                    new Keyboard("DasKeyboard", 150f)};
	    System.out.println("Inventory system started.");

	    for(int index = 0; index < mystuff.length; ++index)
	        notifier.displayNotification("Inventory number " + mystuff[index].getInventoryNumber() + " is " + mystuff[index].getName());
    }
}
