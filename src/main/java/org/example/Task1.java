package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 implements TaskRunner{
    private int n;
    int[] array;
    private boolean initArray(){
        System.out.println("please enter size of array");
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        if (n == 0) {
            System.out.println("Size of array 0, no average value");
            return false;
        }
        array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }
        return true;
    }
    private double countSumOfArrayValues(){
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
        }
        return sum;
    }
    public void run() {
        if(!initArray()) return;
        System.out.println("average value = " + countSumOfArrayValues() / n);
        System.out.println("array: " + Arrays.toString(array));
    }
}