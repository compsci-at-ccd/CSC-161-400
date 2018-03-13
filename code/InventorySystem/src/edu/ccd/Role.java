package edu.ccd;

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

    public String getRolename() {
        return this.rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    private boolean view;
    private boolean add;
    private boolean delete;
    private boolean edit;
    private boolean reload;

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

    public void printme() {
        System.out.println("UID: " + uid + " Rolename: " + rolename + " target:" + targetname);
    }

    public boolean amI(long uid) {
        return this.uid == uid;
    }
}
