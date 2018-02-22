package edu.ccd;

public abstract class SerializedItem extends InventoryItem {
    private long _serialnumber = 1701;

    public void setSerialnumber(long serialnumber) {
        _serialnumber = serialnumber;
    }

    public long getSerialnumber(){
        return _serialnumber;
    }
}
