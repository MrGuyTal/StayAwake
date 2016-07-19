package stayawake;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

public class StayAwake {
    
    final static int intervalInSeconds = 60;
    static int delta = 1;
    
    public static void main(String[] args) {
        System.out.println("Moving mouse every " + intervalInSeconds + " seconds...");
        
        int counter = 0;
        while (true) {
            try {
                moveMouse();
                counter++;
                System.out.print("\rMouse moved " + counter + " times");
                Thread.sleep(intervalInSeconds * 1000);
            }
            catch (Exception e) {}
        }
    }
    
    private static void moveMouse() throws Exception {
        Point point = MouseInfo.getPointerInfo().getLocation();
        int x = (int) point.getX();
        int y = (int) point.getY();
        new Robot().mouseMove(x + delta, y + delta);
        if (delta == 1) {
            delta = -1;
        }
        else {
            delta = 1;
        }
    }
}
