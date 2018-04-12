package edu.ccd.model.inventoryitems;

import edu.ccd.model.database.InventoryItem;

public class Monitor extends InventoryItem {

    public Monitor() {};

    public Monitor(String name, float value) {
        _name = name;
        _value = value;
    }
}
