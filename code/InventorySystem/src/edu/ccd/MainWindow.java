package edu.ccd;

import edu.ccd.appUI.Login;
import edu.ccd.appUI.NotificationDialog;
import edu.ccd.config.Configuration;
import edu.ccd.model.database.InvalidUserOrNoPermissionException;
import edu.ccd.model.database.InventoryDatabaseMySQL;
import edu.ccd.model.database.InventoryItem;
import edu.ccd.model.security.SecurityContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainWindow extends JFrame implements ActionListener {
    private JPanel mainpanel;
    private JTextField username;
    private JComboBox kinds;
    private JTextArea tempResponse;
    private InventoryDatabaseMySQL idb = new InventoryDatabaseMySQL();

    private SecurityContext applicationSecurityContext = new SecurityContext();

    public static MainWindow the = null;

    public void setApplicationSecurityContext(String name, String token) {
        applicationSecurityContext.setSecurityContext(name,token);
        username.setText(name);
    }

    private MainWindow() {
        initComponents();
    }

    public static MainWindow the() {
        if (the == null) {
            the = new MainWindow();
        }
        return the;
    }

    public InventoryDatabaseMySQL getIdb() {
        return idb;
    }

    private void initComponents() {
        setTitle("Inventory System");
        setSize(500,500);
        mainpanel = new JPanel();
        mainpanel.setSize(500,500);
        mainpanel.setLayout(null);
        add(mainpanel);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        mainpanel.add(userLabel);

        username = new JTextField(20);
        username.setEnabled(false);
        username.setBounds(100, 10, 160, 25);
        mainpanel.add(username);

        JLabel dropdownLabel = new JLabel("Kinds");
        dropdownLabel.setBounds(10,40,80,25);
        mainpanel.add(dropdownLabel);

        kinds = new JComboBox<String>();
        kinds.setBounds(100,40,320,25);
        kinds.addActionListener(this);
        mainpanel.add(kinds);

        tempResponse = new JTextArea();
        tempResponse.setBounds(10,80,470,380);
        mainpanel.add(tempResponse);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void loadKinds() {
        try {
            for (String akind : idb.getInventoryKinds())
                kinds.addItem(akind);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MainWindow();
        new Login(MainWindow.the().getIdb());
        MainWindow.the().loadKinds();

        ArrayList<InventoryItem> operationalContext = new ArrayList<>();

        /*try {
            new Configuration().writeConfig("This is what should show up in the dialog.");
            NotificationDialog.the().displayNotification(new Configuration().readConfig());
        } catch (IOException e) {
            System.out.println("Could not find a config file.");
        }*/

        try {
            operationalContext = MainWindow.the().getIdb().getAllInventoryOfKind("edu.ccd.model.inventoryitems.Keyboard");
        } catch (InvalidUserOrNoPermissionException e) {
            System.out.println("No user or permissions...");
        }

        for (InventoryItem each : operationalContext) {
            System.out.println(each.getName() + " of kind " + each.getClass().getName());
        }
        System.out.println("End program.");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() instanceof JComboBox ) {
            try {
                String fillText = "";
                for (InventoryItem row : MainWindow.the().getIdb().getAllInventoryOfKind(((JComboBox) e.getSource()).getSelectedItem().toString())) {
                    fillText += row.getName() + "\n";
                }
                tempResponse.setText(fillText);
            } catch (Exception catchall) {
                catchall.printStackTrace();
            }
        }
    }
}

