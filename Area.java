/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Area {
    private final String name;
    private int occupants;
    private final boolean[] lights = new boolean[3]; // lights 1–3

    public Area(String name) {
        this.name = name;
        this.occupants = 0;
        for (int i = 0; i < lights.length; i++) {
            lights[i] = false; // all lights OFF
        }
    }

    public void addOccupants(int n) {
        occupants += n;
    }

    public void removeOccupants(int n) {
        occupants = Math.max(0, occupants - n);
    }

    public boolean switchLightOn(int lightNum) {
        if (lightNum >= 1 && lightNum <= 3) {
            lights[lightNum - 1] = true;
            return true;
        }
        return false;
    }

    public boolean switchLightOff(int lightNum) {
        if (lightNum >= 1 && lightNum <= 3) {
            lights[lightNum - 1] = false;
            return true;
        }
        return false;
    }

    public void reportStatus() {
        System.out.println("Area: " + name);
        System.out.println("Occupants: " + occupants);
        for (int i = 0; i < lights.length; i++) {
            System.out.println("Light " + (i + 1) + ": " + (lights[i] ? "ON" : "OFF"));
        }
    }

    public String getName() {
        return name;
    }
 }
