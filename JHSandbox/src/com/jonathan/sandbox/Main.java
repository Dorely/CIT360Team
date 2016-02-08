package com.jonathan.sandbox;

/**
 * Created by Jonathan on 1/11/2016.
 */
public class Main {
    public static void main(String[] args){

//        JavaCollectionsSandbox sandbox = new JavaCollectionsSandbox();
//        sandbox.mapSandbox();
//        sandbox.listSandbox();
//        sandbox.setSandbox();

//        ControllerSandbox controller = new ControllerSandbox();
//        controller.runTimeControl();
//        controller.runTimeControl();
//        controller.runTimeControl();
//        controller.runTimeControl();


        // happy path running 3 threads at the same time to view them working concurrently
        new Thread(new ThreadsSandbox.Alphabet()).start();
        new Thread(new ThreadsSandbox.Alphabet()).start();
        new Thread(new ThreadsSandbox.Alphabet()).start();

        ThreadsSandbox threads = new ThreadsSandbox();

        threads.runThreadsAlphabet();
        threads.runThreads();
        //threads.runThreads2();





    }
}
