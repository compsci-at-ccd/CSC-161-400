package edu.ccd;

import edu.ccd.appUI.Login;
import edu.ccd.appUI.NotificationDialog;
import edu.ccd.config.Configuration;
import edu.ccd.model.database.InvalidUserOrNoPermissionException;
import edu.ccd.model.database.InventoryDatabaseMySQL;
import edu.ccd.model.database.InventoryItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<InventoryItem> operationalContext = new ArrayList<>();

        /*try {
            new Configuration().writeConfig("This is what should show up in the dialog.");
            NotificationDialog.the().displayNotification(new Configuration().readConfig());
        } catch (IOException e) {
            System.out.println("Could not find a config file.");
        }*/

        InventoryDatabaseMySQL idb = new InventoryDatabaseMySQL();
        new Login(idb);

        try {
            operationalContext = idb.getAllInventoryOfKind("edu.ccd.model.inventoryitems.Keyboard");
        } catch (InvalidUserOrNoPermissionException e) {
            System.out.println("No user or permissions...");
        }

        for (InventoryItem each : operationalContext) {
            System.out.println(each.getName() + " of kind " + each.getClass().getName());
        }
        System.out.println("End program.");

    }
}