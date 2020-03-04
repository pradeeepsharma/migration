package pk.playground.dynamicprg;

import java.io.*;
import java.util.*;


public class MaxArraySum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int length = arr.length;
        int max =0;
        for(int i=0;i<length;i++ ) {
            int incrementer=2;
            int sum =0;
            List<Integer> arrList =null;
            while(incrementer<length){
                arrList = new ArrayList<>();
                nextNonAdjacentSum(arrList,length,i,incrementer);
                incrementer++;
                for(int index:arrList){
                    //System.out.print(index+" ");
                    sum =sum+arr[index];
                }
                sum = sum+arr[i];
                if(max<sum)max=sum;
            }
            System.out.println("Element :"+arr[i]+" sum: "+sum+" max :"+max);
        }
        return max;


    }
    private static void nextNonAdjacentSum(List<Integer>arrList, int arrayLength, int currentIndex, int incrementer){
        int nextNonAdjacentIndex=currentIndex+incrementer;
        int sum = 0;
       if(nextNonAdjacentIndex<arrayLength){
           arrList.add(nextNonAdjacentIndex);
            nextNonAdjacentSum(arrList, arrayLength, nextNonAdjacentIndex,incrementer);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
            System.out.println("integer array :"+arr[i]);
        }

        int res = maxSubsetSum(arr);
        System.out.println(res);
        /*bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}
