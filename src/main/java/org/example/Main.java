package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<TaskRunner> tasks = List.of(new Task1(), new Task2(),new Task1(), new Task3(), new Task4(), new Task5());

        for(int i=0;i<tasks.size();i++){
            System.out.println("\n\nTask"+(i+1)+" \n");
            tasks.get(i).run();
        }
    }
}