package org.example;
import java.util.*;

public class Task2 implements TaskRunner{
    private int n;
    List<Double> array;
    private boolean initArray(){
        System.out.println("please enter size of array");
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        if (n == 0) {
            System.out.println("Size of array 0");
            return false;
        }
        array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array.add(random.nextDouble());
        }
        return true;
    }
    private void sort(){
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(array.get(j) > array.get(j+1)){
                    Double tmp = array.get(j);
                    array.set(j, array.get(j+1));
                    array.set(j+1, tmp);
                }
            }
        }
    }
    public void run() {
        if(!initArray())return;

        System.out.println("current array: " + array);
        sort();
        System.out.println("sorted array: " + array);
    }
}