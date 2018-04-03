package edu.ccd.Model;

public interface InventoryDatabaseInterface {
    Role ViewRole(int uid);
    boolean AddRole(Role addrole);
    boolean DeleteRole(int uid);
    boolean EditRole(int replaceme, Role replacewith);
    Role ReloadRole(int uid);

    InventoryItem ViewInventoryItem(int uid);
    boolean AddInventoryItem(InventoryItem inv_item);
    boolean DeleteInventoryItem(int uid);
    boolean EditInventoryItem(int replaceme, InventoryItem replacewith);
    InventoryItem ReloadInventoryItem(int uid);
}
