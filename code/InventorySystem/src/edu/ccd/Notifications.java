package edu.ccd;

public class Notifications implements Notifier {

    public Notifications() {

    }
     public void displayNotification(String notice) {
        System.out.println("Notification: " + notice);
     }

}
