package edu.ccd;

import java.util.ArrayList;

public class Workstation {
    private ArrayList<InventoryItem> workstationComponents = new ArrayList<InventoryItem>();

    public Workstation(CPU aCPU, Monitor aMonitor, Keyboard aKeyboard, Mouse aMouse) {
        workstationComponents.add(aCPU);
        workstationComponents.add(aMonitor);
        workstationComponents.add(aKeyboard);
        workstationComponents.add(aMouse);
    }

    public void addCPU (CPU anotherCPU) throws TooManyCPUsException {
        for(int index = 0; index < workstationComponents.size(); ++index) {
            if( workstationComponents.get(index) instanceof  CPU)
                throw new TooManyCPUsException();
        }
        workstationComponents.add(anotherCPU);
    }
}
