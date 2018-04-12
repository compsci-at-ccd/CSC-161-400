package edu.ccd.model.inventoryitems;

import edu.ccd.model.SerializedItem;

public class CPU extends SerializedItem {

    public CPU() {};

    public CPU(String name, float value) {
        if(value < 1) {
            _value = 1;
        } else {

            _value = value;
        }
        _name = name;
    }

    public boolean iAmACPU() {
        return true;
    }
}
