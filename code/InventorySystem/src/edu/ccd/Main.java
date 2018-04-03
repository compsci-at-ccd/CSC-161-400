package edu.ccd;

import edu.ccd.AppUI.Login;
import edu.ccd.Model.*;

public class Main {

    public static void main(String[] args) {

        new Login();

        /*InventoryDatabaseMySQL idb = new InventoryDatabaseMySQL();

        CPU myCPU = new CPU("myCPU", 3000f);
        myCPU.setSerialnumber("000DESTRUCT0");
        idb.AddInventoryItem( myCPU );

        //String classfromdatabase = "edu.ccd.Model.CPU";
        //InventoryItem myItem;

        //if (classfromdatabase == "edu.ccd.Model.CPU" )
        //    myItem = new edu.ccd.Model.CPU();

        /*Object something = null;
        try {
            something = Class.forName(classfromdatabase).newInstance();
        }catch(Exception e) {
            System.out.println("Uh oh.");
        }

        System.out.println("Is this a " + something.getClass().getName());

        idb.AddRole(new Role("admin", "InventoryTable", true, true, true, true, true));
        idb.AddRole(new Role("super", "InventoryTable", true, true, true, true, true));
        idb.AddRole(new Role("TheDude", "InventoryTable", true, true, true, true, true));

        if(idb.getRoleSize() > 2) {
            Role.print(idb.ViewRole(3));
            //idb.DeleteRole(3);
            Role.print(idb.ViewRole(3));
        }

        InventoryItem something = idb.ViewInventoryItem(1);
        System.out.println("Name is " + something.getName());
        if (something instanceof SerializedItem)
            {System.out.println("Serial Number is " + ((SerializedItem) something).getSerialnumber());}*/

        System.out.println("End program.");
    }
}
