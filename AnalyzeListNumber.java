/*
Copyright 2026 Edi (Hadi Gholipour _ AxGooD)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0
*/

import java.util.Scanner;

public class AnalyzeListNumber {


    private byte countNumb = 0;
    private double[] numberList;
    private double maxNumb = Double.NEGATIVE_INFINITY;
    private double minNumb = Double.POSITIVE_INFINITY;
    private double average = 0;
    private double sum = 0;
    private int count = 0;
    private Scanner input;

    public AnalyzeListNumber() {
        this.input = new Scanner(System.in);
    }

    public void markam(){
        System.out.println("\u001b[31m"+"\n === Developed by Hadi Gholipour ===\n"+"\u001b[0m");
    }
    public byte CountNumb() {
        this.markam();
        System.out.print("Enter Count Number (N:Integer: Max 127): ");
        int tempCount = input.nextInt();
        if (tempCount < 0) {
            System.err.println("Count cannot be negative. Defaulting to 1.");
            return (byte) 1;
        }
        return (byte) tempCount;
    }

    public void enterNumbers() {
        this.countNumb = CountNumb();
        int N = this.countNumb;

        if (N <= 0) {
            System.out.println("No numbers to process.");
            return;
        }

        this.numberList = new double[N];
        this.sum = 0;
        this.count = N;

        for (int i = 0; i < N; i++) {
            System.out.printf("Enter Number %d of %d: ", i + 1, N);
            double num = input.nextDouble();
            numberList[i] = num;
            sum += num;
        }
    }

    public double MaxNumber() {
        if (numberList == null || numberList.length == 0) return Double.NaN; // Not a Number if empty/null

        maxNumb = numberList[0];
        for (int i = 1; i < numberList.length; i++) {
            if (numberList[i] > maxNumb) {
                maxNumb = numberList[i];
            }
        }
        return maxNumb;
    }

    public double MinNumber() {
        if (numberList == null || numberList.length == 0) return Double.NaN;

        minNumb = numberList[0];
        for (int i = 1; i < numberList.length; i++) {
            if (numberList[i] < minNumb) {
                minNumb = numberList[i];
            }
        }
        return minNumb;
    }

    public double Average() {
        if (count == 0) return 0.0;
        average = sum / count;
        return average;
    }

    public int HighAverageCount() {
        if (numberList == null) return 0;
        int hCount = 0;
        for (double num : numberList) { // use (for-each) for raedability
            if (num > average) {
                hCount++;
            }
        }
        return hCount;
    }

    public int LowAverageCount() {
        if (numberList == null) return 0;
        int lCount = 0;
        for (int i = 0; i < numberList.length; i++) { // use for loop standard modele
            double num = numberList[i];
            if (num < average) {
                lCount++;
            }
        }
        return lCount;
    }


    public static void main(String[] args){
        AnalyzeListNumber an = new AnalyzeListNumber();

        an.enterNumbers();

        if (an.numberList != null && an.numberList.length > 0) {
            double max = an.MaxNumber();
            double min = an.MinNumber();
            double avg = an.Average();
            int highCount = an.HighAverageCount();
            int lowCount = an.LowAverageCount();

            System.out.printf("\n================ ANALYSIS RESULTS ================\nMaximum: %.2f \nMinmum: %.2f\nAverage: %.2f\nCount Number Upper Than Average: %d\nCount Number Lower Than Average: %d\n",
                    max, min, avg, highCount, lowCount);
        } else {
            System.out.println("\nNo data was entered for process analysis.");
        }

        an.input.close();
    }
}
