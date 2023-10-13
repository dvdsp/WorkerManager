/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import java.util.ArrayList;
import model.History;
import model.Worker;

/**
 *
 * @author DELL
 */
public interface InterfaceWorkerRepository {
    void addWorker(ArrayList<Worker> workerList);
    void changeSalary(ArrayList<Worker> workerList, ArrayList<History> historyList, int status);  
    void display(ArrayList<History> historyList);
}
