package edu.ccd.Model;

import java.util.ArrayList;

public class InventoryDatabase implements InventoryDatabaseInterface{
    private ArrayList<Role> roles = new ArrayList();
    private ArrayList<InventoryItem> inventory = new ArrayList<>();

    public int getSize() {
        return roles.size();
    }

    @Override
    public boolean AddRole(Role addrole) {
        return roles.add(addrole);
    }

    @Override
    public Role ViewRole(int uid) {
        for( Role lookin : roles) {
            if( lookin.amI(uid) )
                return lookin;
        }
        return null;
    }

    @Override
    public boolean DeleteRole(int uid) {
        return roles.remove(ViewRole(uid));
    }

    @Override
    public boolean EditRole(int replaceme, Role replacewith) {
        return DeleteRole(replaceme) && AddRole(replacewith);
    }

    @Override
    public Role ReloadRole(int uid) {
        return null;
    }

    @Override
    public InventoryItem ViewInventoryItem(int uid) {
        return null;
    }

    @Override
    public InventoryItem ReloadInventoryItem(int uid) {
        return ViewInventoryItem(uid);
    }

    @Override
    public boolean AddInventoryItem(InventoryItem inv_item) {
        return inventory.add(inv_item);
    }

    @Override
    public boolean DeleteInventoryItem(int uid) {
        /*TODO: DeleteInventoryItem(int uid): I need to code this
        */
        return false;
    }

    @Override
    public boolean EditInventoryItem(int replaceme, InventoryItem replacewith) {
        return false;
    }
}
