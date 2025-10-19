/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.util.Scanner;
public class SpekeManager {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Area gym = new Area("Gym");
            Area accommodation = new Area("Accommodation");
            Area swimming = new Area("Swimming");
            
            Area activeArea = gym; // default
            
            boolean running = true;
            
            while (running) {
                System.out.println("\nMenu:");
                System.out.println("S – Select active area (Gym, Accommodation, Swimming)");
                System.out.println("N – Add occupants");
                System.out.println("X – Remove occupants");
                System.out.println("Y – Switch ON light (1–3)");
                System.out.println("Z – Switch OFF light (1–3)");
                System.out.println("R – Report status");
                System.out.println("Q – Quit");
                
                System.out.print("Enter command: ");
                String command = scanner.nextLine().toUpperCase();
                
                switch (command) {
                    case "S" -> {
                        System.out.print("Select area (1=Gym, 2=Accommodation, 3=Swimming): ");
                        int areaChoice = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        switch (areaChoice) {
                            case 1 -> activeArea = gym;
                            case 2 -> activeArea = accommodation;
                            case 3 -> activeArea = swimming;
                            default -> System.out.println("Invalid area. Try again.");
                        }
                    }
                    
                    case "N" -> {
                        System.out.print("Enter number of occupants to add: ");
                        int add = scanner.nextInt();
                        scanner.nextLine();
                        activeArea.addOccupants(add);
                    }
                    
                    case "X" -> {
                        System.out.print("Enter number of occupants to remove: ");
                        int remove = scanner.nextInt();
                        scanner.nextLine();
                        activeArea.removeOccupants(remove);
                    }
                    
                    case "Y" -> {
                        System.out.print("Enter light number to switch ON (1–3): ");
                        int lightOn = scanner.nextInt();
                        scanner.nextLine();
                        if (!activeArea.switchLightOn(lightOn)) {
                            System.out.println("Invalid light number.");
                        }
                    }
                    
                    case "Z" -> {
                        System.out.print("Enter light number to switch OFF (1–3): ");
                        int lightOff = scanner.nextInt();
                        scanner.nextLine();
                        if (!activeArea.switchLightOff(lightOff)) {
                            System.out.println("Invalid light number.");
                        }
                    }
                    
                    case "R" -> activeArea.reportStatus();
                    
                    case "Q" -> {
                        running = false;
                        System.out.println("Exiting program...");
                    }
                    
                    default -> System.out.println("Invalid command. Try again.");
                }
            }
        }
    }
}

