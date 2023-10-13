/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Repository.InterfaceWorkerRepository;
import Repository.WorkerRepository;
import java.util.ArrayList;
import model.History;
import model.Worker;
import view.Menu;

/**
 *
 * @author DELL
 */
public class WorkerManager extends Menu<String> {
    static String[] mc = {"Add a worker", 
                            "Increase salary for worker",
                            "Decrease for worker",
                            "Show adjusted worker information","exit"};
    protected InterfaceWorkerRepository repo;
    protected ArrayList<Worker> workerList ;
    protected ArrayList<History> historyList;
    
    public WorkerManager() {
        super("\n\tMANAGE WORKER", mc);
        repo = new WorkerRepository();
        workerList = new ArrayList<>();
        historyList = new ArrayList<>();
        //demonstration
//        workerList.add(new Worker("W1","thomas",30,1000,"E"));
//        historyList.add(new History("UP","23/06/2015","W1","thomas",30,1000,"E"));
        
    }
    
    @Override
    public void execute(int n) {
        switch(n) {
            case 1-> repo.addWorker(workerList);
            case 2-> repo.changeSalary(workerList, historyList,1);
            case 3-> repo.changeSalary(workerList, historyList,2);
            case 4-> repo.display(historyList);
            case 5-> System.exit(0);      
        }
    }
    
    
}
