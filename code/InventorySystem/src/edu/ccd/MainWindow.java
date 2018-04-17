package edu.ccd;

import edu.ccd.appUI.Login;
import edu.ccd.appUI.NotificationDialog;
import edu.ccd.config.Configuration;
import edu.ccd.model.database.InvalidUserOrNoPermissionException;
import edu.ccd.model.database.InventoryDatabaseMySQL;
import edu.ccd.model.database.InventoryItem;
import edu.ccd.model.inventoryitems.CPU;
import edu.ccd.model.inventoryitems.Mouse;
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
    private InventoryDatabaseMySQL idb = new InventoryDatabaseMySQL();

    //new components
    private JTextField uid;
    private JTextField name;
    private JTextField value;
    private JButton editButton;
    private JComboBox<String> which;

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
        int _leftside = 10;
        int _rightside = 100;
        int _top = 10;
        int _labelwidth = 80;
        int _height = 25;

        setTitle("Inventory System");
        setSize(500,500);
        mainpanel = new JPanel();
        mainpanel.setSize(500,500);
        mainpanel.setLayout(null);
        add(mainpanel);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(_leftside, _top, _labelwidth, _height);
        mainpanel.add(userLabel);

        username = new JTextField(20);
        username.setEnabled(false);
        username.setBounds(_rightside, _top, _labelwidth*2, _height);
        mainpanel.add(username);

        JLabel dropdownLabel = new JLabel("Kinds");
        dropdownLabel.setBounds(_leftside,_top+=30,_labelwidth,_height);
        mainpanel.add(dropdownLabel);

        kinds = new JComboBox<String>();
        kinds.setBounds(_rightside,_top,_labelwidth*4,_height);
        kinds.addActionListener(this);
        mainpanel.add(kinds);

        JLabel whichLabel = new JLabel("Which");
        whichLabel.setBounds(_leftside,_top+=30,_labelwidth,_height);
        mainpanel.add(whichLabel);

        which = new JComboBox<String>();
        which.setBounds(_rightside,_top,_labelwidth*4,_height);
        which.addActionListener(this);
        mainpanel.add(which);

        JLabel uidLabel = new JLabel("UID");
        uidLabel.setBounds(_leftside, _top+=30, _labelwidth, _height);
        mainpanel.add(uidLabel);

        uid = new JTextField();
        uid.setEnabled(false);
        uid.setBounds(_rightside, _top, _labelwidth*2, _height);
        mainpanel.add(uid);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(_leftside, _top+=30, _labelwidth, _height);
        mainpanel.add(nameLabel);

        name = new JTextField(20);
        name.setBounds(_rightside, _top, _labelwidth*2, _height);
        mainpanel.add(name);

        JLabel valueLabel = new JLabel("Value");
        valueLabel.setBounds(_leftside, _top+=30, _labelwidth, _height);
        mainpanel.add(valueLabel);

        value = new JTextField(20);
        value.setBounds(_rightside, _top, _labelwidth*2, _height);
        mainpanel.add(value);

        editButton = new JButton("Edit");
        //todo: permissions!
        editButton.setBounds(_rightside, _top+=30, _labelwidth, _height);
        editButton.addActionListener(this);
        mainpanel.add(editButton);

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
        if( e.getSource() instanceof JButton ) {
            try {
                MainWindow.the().getIdb().EditInventoryItem(new Integer(uid.getText()).intValue(), new CPU(name.getText(), new Float(value.getText()).floatValue()));
            }catch (Exception me) {
                me.printStackTrace();
            }
        }
        if( e.getSource() instanceof JComboBox ) {
            if( ((JComboBox) e.getSource()).equals(kinds) ) {
                try {
                    //String fillText = "";
                    which.removeAllItems();
                    for (InventoryItem row : MainWindow.the().getIdb().getAllInventoryOfKind(((JComboBox) e.getSource()).getSelectedItem().toString())) {
                        System.out.println("Item is " + ((JComboBox) e.getSource()).getSelectedItem().toString());
                        which.addItem(row.getName());
                        //fillText += row.getName() + "\n";
                    }
                    //tempResponse.setText(fillText);
                } catch (Exception catchall) {
                    catchall.printStackTrace();
                }
            }
            else {
                try {
                    for (InventoryItem row : MainWindow.the().getIdb().getInventoryItemByName(((JComboBox) e.getSource()).getSelectedItem().toString())) {
                        uid.setText(String.valueOf(row.getInventoryNumber()));
                        name.setText(row.getName());
                        value.setText(String.valueOf(row.getValue()));
                    }
                }catch (Exception catchAll2) {
                    catchAll2.printStackTrace();
                }
            }

        }
    }
}

