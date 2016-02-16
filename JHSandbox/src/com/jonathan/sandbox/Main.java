package com.jonathan.sandbox;

import java.util.HashMap;

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


        // Threads sandbox example

//        ThreadsSandbox threads = new ThreadsSandbox();
//
////        threads.runThreadsAlphabet();
////        threads.runThreads();
//        threads.executors();
        //threads.runThreads2();

        //QCJSON sandbox
//        QCJsonSandbox jsonSandbox = new QCJsonSandbox();
//
//        jsonSandbox.stringifySandbox();
//        jsonSandbox.parseSandbox();
//        jsonSandbox.fileInOutSandbox();
//        jsonSandbox.nastyPaths();

        AppController controller = new AppController();
        HashMap<String,Object> numberData = new HashMap<String,Object>();
        numberData.put("first",10);
        numberData.put("second",20);

        controller.handleRequest("subtract",numberData);
        controller.handleRequest("add",numberData);





    }
}
