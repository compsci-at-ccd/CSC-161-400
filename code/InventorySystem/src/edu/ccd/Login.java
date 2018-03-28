package edu.ccd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login{
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;
    private JButton cancelButton;
    private JFrame mainwindow;

    public Login() {
        mainwindow = new JFrame("Login");
        mainwindow.setSize(300, 150);
        mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        mainwindow.add(panel);

        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        panel.add(userLabel);

        JTextField username = new JTextField(20);
        username.setBounds(100, 10, 160, 25);
        panel.add(username);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        panel.add(passwordLabel);

        JPasswordField password = new JPasswordField(20);
        password.setBounds(100, 40, 160, 25);
        panel.add(password);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 100, 25);
        panel.add(loginButton);
        panel.getRootPane().setDefaultButton(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 80, 100, 25);
        panel.add(cancelButton);


        mainwindow.setLocationRelativeTo(null);
        mainwindow.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Login user: " + username.getText() + " with password: " + String.valueOf(password.getPassword()));
                mainwindow.dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancel");
                System.exit(0);
            }
        });
    }
}
