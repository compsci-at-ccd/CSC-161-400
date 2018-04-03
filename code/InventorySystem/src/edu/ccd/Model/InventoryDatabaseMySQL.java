package edu.ccd.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryDatabaseMySQL implements InventoryDatabaseInterface{

    private Connection conn = null;

    private Connection getConnection () {
        if(conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                return DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Inventory?useSSL=false", "root", "&APx.RApkf9f$2kHk56bljS3{"
                );
            } catch (Exception any) {
                any.printStackTrace();
            }
        }
        return conn;
    }

    public int getRoleSize() {
        try {
            ResultSet results = getConnection().createStatement().executeQuery(
                    "SELECT COUNT(*) FROM Roles;"
            );
            while (results.next())
                return results.getInt(1);
        } catch (Exception any) {
            any.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean AddRole(Role addrole) {
        try {
            getConnection().createStatement().executeUpdate(
                    "INSERT INTO Roles (uid, rolename, targetname, `permissions-view`, `permissions-add`, `permissions-delete`, `permissions-edit`, `permissions-reload`)" +
                    " VALUES (" + addrole.getUid() +
                    ", '" + addrole.getRolename() +
                    "', '" + addrole.getTargetname() +
                    "', " + (addrole.canView()?"1":"0") +
                    ", " + (addrole.canAdd()?"1":"0") +
                    ", " + (addrole.canDelete()?"1":"0") +
                    ", " + (addrole.canEdit()?"1":"0") +
                    ", " + (addrole.canReload()?"1":"0") + ");"
            );
        } catch (SQLException any) {
            any.printStackTrace();
        }

        return true;
    }

    @Override
    public Role ViewRole(int uid) {
        Role returnme = null;
        try {
            ResultSet results = getConnection().createStatement().executeQuery(
                    "SELECT * FROM Roles WHERE uid=" + uid + ";"
            );
            while (results.next()) {
                returnme = Role.cloneRole(
                        results.getInt(1),
                        results.getString(2),
                        results.getString(3),
                        results.getBoolean(4),
                        results.getBoolean(5),
                        results.getBoolean(6),
                        results.getBoolean(7),
                        results.getBoolean(8)
                );
            }
        } catch (Exception any) {
            any.printStackTrace();
        }
        return returnme;
    }

    @Override
    public boolean DeleteRole(int uid) {
        try {
            getConnection().createStatement().executeUpdate(
                    "DELETE FROM Roles WHERE uid=" + uid + ";"
            );
        } catch (SQLException any) {
            any.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean EditRole(int replaceme, Role replacewith) {
        return DeleteRole(replaceme) && AddRole(replacewith);
    }

    @Override
    public Role ReloadRole(int uid) {
        return ViewRole(uid);
    }

    @Override
    public boolean AddInventoryItem(InventoryItem inv_item) {
        if (ViewInventoryItem(inv_item.getInventoryNumber())!=null) {
            return false;
        }
        try {
            getConnection().createStatement().executeUpdate(
                    "INSERT INTO Inventory (inventory_number, kind, name, value, serial_number)" +
                            " VALUES (" + inv_item.getInventoryNumber() +
                            ", '" + inv_item.getClass().getName() +
                            "', '" + inv_item.getName() +
                            "', " + inv_item.getValue() +
                            (inv_item instanceof SerializedItem?", '" +((SerializedItem)inv_item).getSerialnumber()+"');":", '0');"));
        } catch (SQLException any) {
            any.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean DeleteInventoryItem(int uid) {
        try {
            getConnection().createStatement().executeUpdate(
                    "DELETE FROM Inventory WHERE inventory_number=" + uid + ";"
            );
        } catch (SQLException any) {
            any.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean EditInventoryItem(int replaceme, InventoryItem replacewith) {
        return DeleteInventoryItem(replaceme) && AddInventoryItem(replacewith);
    }

    @Override
    public InventoryItem ViewInventoryItem(int uid) {
        //Todo: Finish this routine and main, such that we can get an inventory that you have populated from a SQL statement
        //Todo: Oh yeah, be sure to give me that SQL Insert statement too.
        Object returnme = null;
        try {
            ResultSet results = getConnection().createStatement().executeQuery(
                    "SELECT * FROM Inventory WHERE inventory_number=" + uid + ";"
            );
            while (results.next()) {
                try {
                    returnme = Class.forName(results.getString(2)).newInstance();
                }catch(Exception e) {
                    System.out.println("Uh oh.");
                }
                ((InventoryItem)returnme).set_name(results.getString(3));
                if (returnme instanceof SerializedItem)
                    ((SerializedItem)returnme).setSerialnumber(results.getString(5));
            }
        } catch (Exception any) {
            any.printStackTrace();
        }
        return ((InventoryItem)returnme);
    }

    @Override
    public InventoryItem ReloadInventoryItem(int uid) {
        return ReloadInventoryItem(uid);
    }
}
