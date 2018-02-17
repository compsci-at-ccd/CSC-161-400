package edu.ccd;

public abstract class SerializedItem extends InventoryItem {
    public long _serialnumber;

    public void setSerialnumber(long serialnumber){
        _serialnumber = serialnumber;
    }
}
