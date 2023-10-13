/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import common.Library;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import model.History;
import model.Worker;

/**
 *
 * @author DELL
 */
public class WorkerDao {
    private static WorkerDao instance = null;
    public static WorkerDao Instance() {
        if(instance == null) {
            synchronized (WorkerDao.class) {
                if (instance == null) {
                    instance = new WorkerDao();
                }
            }
        }
        return instance;
    }
    
    public ArrayList<Worker> createWorker(ArrayList<Worker> workerList) {
        System.out.print("Enter id:   ");
        String id = Library.checkInputString();
        System.out.print("Enter name:   ");
        String name = Library.checkInputString();
        System.out.print("Enter age:      ");
        int age = Library.checkInputLimit(18, 50);
        System.out.print("Enter salary:  ");
        double salary = Library.checkInputSalary();
        System.out.print("Enter work location:    ");
        String workLocation = Library.checkInputString();
        if (!Library.checkWorkerExist(workerList, id, name, age, salary, workLocation)) {
            System.out.println("*Duplicate information.");
        } else {
            workerList.add(new Worker(id, name, age, salary, workLocation));
            System.out.println("*Add new worker successfully");
        }
        return workerList;
    }
    
    public void changeSalaryWorker(ArrayList<Worker> workerList, ArrayList<History> historyList, int status) {
            if(workerList.isEmpty()) {
                System.out.println("List empty!");
                return;
            }
            System.out.print("Enter id worker:    ");
            String id = Library.checkInputString();
            Worker worker = getWorkerByCode(workerList, id);
            if (worker == null) {
                System.out.println("*ID worker not found");
            } else {
                double salaryCurrent = worker.getSalary();
                double salaryUpdate;
                if (status == 1) {
                    System.out.print("Enter amount of money to raise:   ");
                    while (true) {
                        salaryUpdate = Library.checkInputSalary();
                      
                        if(salaryUpdate <= salaryCurrent) {
                            System.out.print("Must be greater than current salary. Enter again:   "); 
                        } else {
                            break;
                        }
                    }
                    historyList.add(new History("UP", getCurrentDate(), worker.getId(), worker.getName(),
                            worker.getAge(), salaryUpdate, worker.getWorkLocation() ));
                    
                } else {
                    System.out.print("Enter amount of money to cut:   ");
                    while (true) {
                        salaryUpdate = Library.checkInputSalary();
                        if(salaryUpdate>= salaryCurrent) {
                            System.out.print("Must be smaller than current salary. Enter again:   "); 
                        } else {
                            break;
                        }
                    }
                    historyList.add(new History("DOWN", getCurrentDate(), worker.getId(),
                    worker.getName(), worker.getAge(), salaryUpdate, worker.getWorkLocation()));
                }
                   
                worker.setSalary(salaryUpdate);
                System.out.println("*Make change successfully");
            }  
    } 

    public Worker getWorkerByCode(ArrayList<Worker> workerList, String id) {
        for (Worker w : workerList) {
            if (id.equalsIgnoreCase(w.getId())) {
                return w;
            }
        }
        return null;
    }
    
    
    public String getCurrentDate() {
        DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        return dateF.format(c.getTime());
    }
     

    public void printListHistory(ArrayList<History> historyList) {
        if(historyList.isEmpty()) {
            System.out.println("History List is empty");
            return;
        }
        System.out.format("%-10s%-15s%-10s%-15s%-15s%-25s\n","Code","Name","Age","Salary","Status","Date");
       
        Collections.sort(historyList);
        for (History h : historyList) {
            System.out.format("%-10s%-15s%-10s%-15s%-15s%-25s\n",h.getId(),
                h.getName(), h.getAge(), h.getSalary(),
                h.getStatus(), h.getDate()); 

        } 
        
    }
    

    
    
}




