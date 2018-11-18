import java.util.*;

class Solution {
    int solution(int[] A) {
        int n = A.length;
        int[] L = new int[n + 1];
        L[0] = -1;
        for (int i = 0; i < n; i++) {
            L[i + 1] = A[i];
        }
        int count = 0;
        int pos = (n + 1) / 2;
        for(int j=0;j<n;j++) {
            int candidate = A[j];
            for (int i = 1; i <= n; i++) {
                if (L[i] == candidate)
                    count = count + 1;
            }
            if (count > pos)
                return candidate;
        }
        return (-1);
    }

   /* public int solution(IntList L) {
        boolean listContinus = true;
        int count =0;
        IntList nextNode = L.next;
        while(listContinus){
            count++;
            if(nextNode==null)
                listContinus = false;
            nextNode= nextNode.next;
        }
        return count;
    }*/
}

/*
class IntList{
    public int value;
    public IntList next;

}*/
