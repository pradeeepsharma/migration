package pk.playground.basics.thread.sync;

import java.util.Arrays;
import java.util.List;

public class EvenOddPrinter {
    public static void main(String[] args) {
        List<Integer> sharedNumberList = Arrays.asList(1,3,5,7,2,6,8,9,111,2345);
        int currentIndex = 0;

        Thread t1 = new Thread(/*() -> {

            System.out.println("The number is");
        }*/){

            public void run(){


            }
        };
        Thread t2 = new Thread(() -> {

            System.out.println("The number is");
        });

    }

}

class SharedObject {
    private List<Integer> sharedList;
    SharedObject(List<Integer> sharedList){
        this.sharedList = sharedList;
    }

    synchronized void countAndPrint(){


    }
}


/*

class Customer{
    int amount=10000;

    synchronized void withdraw(int amount){
        System.out.println("going to withdraw...");

        if(this.amount<amount){
            System.out.println("Less balance; waiting for deposit...");
            try{wait();}catch(Exception e){}
        }
        this.amount-=amount;
        System.out.println("withdraw completed...");
    }

    synchronized void deposit(int amount){
        System.out.println("going to deposit...");
        this.amount+=amount;
        System.out.println("deposit completed... ");
        notify();
    }
}

class Test{
    public static void main(String args[]){
        final Customer c=new Customer();
        new Thread(){
            public void run(){c.withdraw(15000);}
        }.start();
        new Thread(){
            public void run(){c.deposit(10000);}
        }.start();

    }}*/
