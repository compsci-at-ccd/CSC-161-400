package edu.ccd.model.security;

import edu.ccd.model.UniqueIdentifiers;

public class Role {
    private long uid = 0;

    private String rolename;

    public Role () {
        uid = UniqueIdentifiers.the().generateUID();
    }

    public Role (String rolename, String targetname, boolean view, boolean add, boolean delete, boolean edit, boolean reload) {
        uid = UniqueIdentifiers.the().generateUID();
        setRolename(rolename);
        setTargetname(targetname);
        setPermissions(view, add, delete, edit, reload);
    }

    public Role (long uid_clone) {
        this.uid = uid_clone;
    }

    public static Role cloneRole (long uid, String rolename, String targetname, boolean view, boolean add, boolean delete, boolean edit, boolean reload) {
        Role clone = new Role(uid);
        clone.uid = uid;
        clone.setRolename(rolename);
        clone.setTargetname(targetname);
        clone.setPermissions(view, add, delete, edit, reload);
        return clone;
    }

    public String getRolename() {
        return this.rolename;
    }

    public long getUid() {
        return uid;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    private boolean view;
    private boolean add;
    private boolean delete;
    private boolean edit;
    private boolean reload;

    public boolean canView() { return view; }
    public boolean canAdd() { return add; }
    public boolean canDelete() { return delete; }
    public boolean canEdit() { return edit; }
    public boolean canReload() { return reload; }

    public void setPermissions(boolean view, boolean add, boolean delete, boolean edit, boolean reload) {
        this.view = view;
        this.add = add;
        this.delete = delete;
        this.edit = edit;
        this.reload = reload;
    }

    private String targetname;

    public void setTargetname(String targetname) {
        this.targetname = targetname;
    }

    public String getTargetname() {
        return targetname;
    }

    //my solution to the printme problem...
    public static void print(Role printthis) {
        if(printthis != null)
            System.out.println(
                        "-----------------------------" +
                        "\nUID     \t : " + printthis.getUid() +
                        "\nRolename\t : " + printthis.getRolename() +
                        "\nTargetname\t : " + printthis.getTargetname() +
                        "\ncanView \t : " + printthis.canView() +
                        "\ncanAdd  \t : " + printthis.canEdit() +
                        "\ncanDelete\t : " + printthis.canDelete() +
                        "\ncanEdit \t : " + printthis.canEdit() +
                        "\ncanReload\t : " + printthis.canReload() +
                        "\n-----------------------------");
    }

    public boolean amI(long uid) {
        return this.uid == uid;
    }
}
/*
INSERT INTO Inventory.Roles (uid, rolename, targetname, `permissions-view`, `permissions-add`, `permissions-delete`, `permissions-edit`, `permissions-reload`) VALUES (1, 'admin', 'InventoryTable', 1, 1, 1, 1, 1);
INSERT INTO Inventory.Roles (uid, rolename, targetname, `permissions-view`, `permissions-add`, `permissions-delete`, `permissions-edit`, `permissions-reload`) VALUES (2, 'super', 'InventoryTable', 1, 1, 0, 1, 1);
INSERT INTO Inventory.Roles (uid, rolename, targetname, `permissions-view`, `permissions-add`, `permissions-delete`, `permissions-edit`, `permissions-reload`) VALUES (3, 'TheDude', 'InventoryTable', 1, 0, 0, 0, 0);
 */