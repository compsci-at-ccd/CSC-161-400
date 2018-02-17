package edu.ccd;

public abstract class InventoryItem {
    private static long current_inventory_number = 0;

    public String _name;
    public float _value;
    public long inventory_number;

    public InventoryItem() {
        inventory_number = ++current_inventory_number;
    }

    public String getName() {
        return _name;
    }

    public float getValue() {
        return _value;
    }

    public long getInventoryNumber() {
        return inventory_number;
    }
}
