package pk.playground.basics.thread;

import pk.playground.model.Custom;

import java.util.HashMap;
import java.util.Map;

public class HasshingTester {

    public static void main(String[] args) {

        Map<Custom,String> customeObjectMap = new HashMap<>();
        customeObjectMap.put(new Custom("1234", "abc"), "1");
        customeObjectMap.put(new Custom("1235", "abc"), "1");
        customeObjectMap.put(new Custom("1236", "abc"), "1");
        customeObjectMap.put(new Custom("1234", "abc"), "1");
       // System.out.println(HasshingTester.getNumber());
        System.out.println(customeObjectMap.size());

    }



    public static int getNumber(){

        try{
            return 10;
        }catch(Exception e){
            System.out.println("inside catch");
        }finally {
            return new Integer(1);
        }

    }


}
