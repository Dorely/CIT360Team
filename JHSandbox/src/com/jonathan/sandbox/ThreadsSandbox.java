package com.jonathan.sandbox;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Jonathan on 2/8/2016.
 */
public class ThreadsSandbox {

    private String testString = "Initial Value";
    private int testInt = 500000;

    public void runThreadsAlphabet(){
        //happy path
        new Thread(new ThreadsSandbox.Alphabet()).start();
        new Thread(new ThreadsSandbox.Alphabet()).start();
    }

    public void runThreads(){

        //nasty path accessing and changing the same variable
        Thread wordChange1 = new Thread(new changeString("Word 1"));
        Thread wordChange2 = new Thread(new changeString("Word 2"));

        wordChange1.start();
        wordChange2.start();

    }





    public void runThreads2(){
        //nasty path race condition
        Thread increment = new Thread(new Increment());
        increment.start();
        Thread decrement = new Thread(new Decrement());
        decrement.start();

    }

    //happy path make example of executors
    public void executors(){
        Executor anExecutor = Executors.newCachedThreadPool();

        Alphabet alphabet = new Alphabet();
        anExecutor.execute(alphabet);
        Alphabet alphabet2 = new Alphabet();
        anExecutor.execute(alphabet2);
        Alphabet alphabet3 = new Alphabet();
        anExecutor.execute(alphabet3);
        //this works but the program no longer exits afterwards

        //nasty path pass null into executor
        try{
            anExecutor.execute(null);

        }catch (NullPointerException e){
            System.out.println(e.toString());
        }

    }


    public class Increment implements Runnable{

        @Override
        public void run() {
            for(;testInt<=1000000;testInt++){
                //System.out.println(testInt);
                if(testInt%1000 == 0){
                    System.out.println(testInt);
                }
            }
        }
    }

    public class Decrement implements Runnable{

        @Override
        public void run() {
            for(;testInt>=0;testInt--){
                //System.out.println(testInt);
                if(testInt%100 == 0){
                    System.out.println(testInt);
                }
            }
        }
    }

    public static class Alphabet implements Runnable{

        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        @Override
        public void run() {
            for(int x = 0;x<alphabet.length;x++){
                System.out.print(alphabet[x]);
                if(x%10 == 0){
                    System.out.println();
                }
            }

        }
    }

    public class changeString implements Runnable{

        private String newTestString;

        changeString(String newTestString){
            this.newTestString = newTestString;
        }

        @Override
        public void run() {

            for(int x = 0;x<=1000;x++){
                testString = this.newTestString;

                int y = 0;
                y++;
                y++;

                if(testString != this.newTestString){
                    System.out.println(testString + " false "+ x);
                }else{
                    //System.out.println(testString + " true "+ x);
                }
            }

        }
    }



}
