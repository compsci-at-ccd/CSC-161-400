package edu.ccd;

public class MobileNotification implements Notifier {
    @Override
    public void displayNotification(String note) {
        System.out.println("Mobile: " + note);
    }
}
