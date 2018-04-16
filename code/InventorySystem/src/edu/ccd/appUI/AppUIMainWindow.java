package edu.ccd.appUI;

import edu.ccd.model.database.InvalidUserOrNoPermissionException;

import java.util.ArrayList;

public interface AppUIMainWindow {
    public ArrayList<String> getInventoryKinds() throws InvalidUserOrNoPermissionException;
}
