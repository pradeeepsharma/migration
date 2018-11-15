package pk.playground.statistics;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.joining;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // read an integer from input stream.
        System.out.println("Enter "+n+" numbers after enter");

        List<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputNumbers.add(scanner.nextInt());
        }
        printMeanOfNumbers(inputNumbers);
        printMeadianOfNumbers(inputNumbers);
    }

    private static void printMeanOfNumbers(List<Integer> inputNumbers) {
        float numberOfElements  = inputNumbers.size();
        Integer totalOfInputElements = getTotalOfInputElements(inputNumbers);
        BigDecimal mean = new BigDecimal(totalOfInputElements.intValue()/ numberOfElements);
        //System.out.println("Mean :"+mean);
        Format twoDecimalFormat = new DecimalFormat("#.0");
        System.out.println("Formated Number :"+twoDecimalFormat.format(mean));
    }

    private static Integer getTotalOfInputElements(List<Integer> inputNumbers) {
        return inputNumbers.stream().reduce(Integer.valueOf("0"), (int1,int2)->int1+int2);
    }

    private static void printMeadianOfNumbers(List<Integer> inputNumbers) {
        Object[] objects = inputNumbers.toArray().;
        Arrays.copyOfobjects);
    }

}


