package edu.ccd.Model;

public class CPU extends SerializedItem {

    protected CPU() {}

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
