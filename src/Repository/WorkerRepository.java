/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.WorkerDao;
import java.util.ArrayList;
import model.History;
import model.Worker;

/**
 *
 * @author DELL
 */
public class WorkerRepository implements InterfaceWorkerRepository{

    @Override
    public void addWorker(ArrayList<Worker> workerList) {
        WorkerDao.Instance().createWorker(workerList);
    }

    @Override
    public void changeSalary(ArrayList<Worker> workerList, ArrayList<History> historyList, int status) {
       WorkerDao.Instance().changeSalaryWorker(workerList, historyList, status);
    }

    @Override
    public void display(ArrayList<History> historyList) {
        WorkerDao.Instance().printListHistory(historyList);
    }

   

    
    
}
