/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.ArrayList;
import java.util.Scanner;
import model.Worker;



/**
 *
 * @author DELL
 */
public class Library {
    
    public static int checkInputLimit(int min, int max) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice < min || choice > max) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.format("Please, enter number in range %d - %d \n",min, max);
                System.out.print("Let's try enter again:        ");
            }
        }
    }

    public static String checkInputString() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty() ) {
                System.out.print("Can not be empty. Let's try enter again:        ");     
            } else {
                return result;
            }
        }
    }

   
    public static int checkInputInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int choice = Integer.parseInt(sc.nextLine().trim());
                return choice;
            } catch (NumberFormatException e) {
                System.out.print("*Invalid value(only type number). Try enter again:      ");
            }
        }
    }
    // id must be exist in this case to make change
    public static boolean checkIdExist(ArrayList<Worker> workerList, String id) {
        for ( Worker w : workerList) {
            if (w.getId().equalsIgnoreCase(id)) { 
                return true;
            }
        }
        return false;
    }
   
    public static boolean checkInputYN() {
        while (true) {
            String choice = checkInputString();
            if (choice.equalsIgnoreCase("Y")) {
                return true;
            } else if (choice.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.print("*Please type only Y or N:   ");
        }
    }

    public static boolean checkWorkerExist(ArrayList<Worker> workerList, String id,
            String name, int age, double salary, String workLocation) {
        for (Worker w : workerList) {
            if (id.equalsIgnoreCase(w.getId()) ) {
                return false; 
            }
        }
        return true;
    }
    
    public static double checkInputSalary() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                double choice = Double.parseDouble(sc.nextLine().trim());
                if (choice < 0) {
                    throw new NumberFormatException();
                }
                return choice;
            } catch(NumberFormatException e) {
                System.out.print("*Invalid value(salary > 0). Try enter again:      ");
            }
        }
    }
    
    
    
}
