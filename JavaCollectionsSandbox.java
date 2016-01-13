//Jonathan Harmon
package com.jonathan.sandbox;

import java.util.*;

/**
 * Created by Jonathan on 1/11/2016.
 */
public class JavaCollectionsSandbox {

    public JavaCollectionsSandbox(){

    }

    //this method will be called to run the sandbox code for Maps
    public void mapSandbox(int number){
        System.out.println("mapSandbox Called");

        //Basic Map: Map<KeyType, ValueType>
        //Important Methods: clear, containsKey, containsValue, equals, get, keySet, put, remove, size
        //Since Map is an interface you need to instantiate a concrete implementation of the interface in order to use it.

        //Hashmap

        System.out.println("Happy path HashMap");
        //happy path
        Map<String,Integer> keyValuePairs = new HashMap<String,Integer>();
        keyValuePairs.put("Three",3);
        keyValuePairs.put("Four",4);
        keyValuePairs.put("Two",2);
        System.out.println("Index Three = "+ keyValuePairs.get("Three"));

        for(String key: keyValuePairs.keySet()){
            System.out.println(key.toString());
        }

        if(keyValuePairs.containsValue(2)){
            System.out.println("Contains "+keyValuePairs.get("Two"));
        }

        System.out.println("Nasty path HashMap");

        //nasty path removing nonexistent elements
        //keyValuePairs = new HashMap();
        keyValuePairs.clear();
        keyValuePairs.remove("Five");
        System.out.println("Index Five = "+ keyValuePairs.get("Five"));

        // nasty path setting itself as an index in itself
        HashMap<HashMap, String> newMap = new HashMap<HashMap, String>();
        newMap.put(newMap,"First");
        System.out.println(newMap.toString());
        try{
            System.out.println(newMap.get(newMap));//causes java.lang.StackOverflowError
        }catch(StackOverflowError e){
            System.out.println("Woops that didn't work "+e.toString());
        }

        //nasty path using nulls
        System.out.println("Nasty path HashMap Nulls");
        Map thirdMap = new HashMap();
        thirdMap.put(null,null);
        thirdMap.put(null,"Word");
        thirdMap.put(null,"Word2");
        thirdMap.put("Three",null);
        try {
            System.out.println(thirdMap.get(0).toString());// throws NullPointerException
        }catch(NullPointerException e){
            System.out.println(e.toString());
        }
        try {
            System.out.println(thirdMap.get(null).toString());//notice that this works as a valid index
        }catch(NullPointerException e){
            System.out.println(e.toString());
        }
        try {
            System.out.println(thirdMap.get("Three").toString());//throws NullPointerException
        }catch(NullPointerException e){
            System.out.println(e.toString());
        }

        //nasty path getting things that aren't there
        System.out.println(thirdMap.get("Five")); // returns null

        //nasty path putall two unlike HashMaps
        keyValuePairs.putAll(thirdMap);//no error
        for(String key: keyValuePairs.keySet()){
            try{
                System.out.println(key.toString());
            }catch(NullPointerException e){
                System.out.println(e.toString());
            }
        }


        //TreeMap is sorted according to the natural ordering of its keys

        System.out.println("Happy path TreeMap");
        //happy path
        TreeMap<String,Integer> treeValuePairs = new TreeMap<String,Integer>();
        treeValuePairs.put("Three",3);
        treeValuePairs.put("Four",4);
        treeValuePairs.put("Two",2);
        System.out.println("Index Three = "+ treeValuePairs.get("Three"));

        for(String key: treeValuePairs.keySet()){
            System.out.println(key.toString());
        }

        //nasty path mixed types
        System.out.println("TreeMap Nasties");
        Map treeMapTwo = new TreeMap();
        treeMapTwo.put("One",1);
        try{
            treeMapTwo.put(1,"One");
        }catch (ClassCastException e){
            System.out.println(e.toString());
        }

        treeMapTwo = new TreeMap();
        //nasty path nulls
        System.out.println("Nasty Treemap null paths");
        try{
            treeMapTwo.put(null,"null");
        }catch (NullPointerException e){
            System.out.println(e.toString());
        }

        //nasty path putting in unsorted
        treeMapTwo = new TreeMap();
        treeMapTwo.put(2,"Two");
        treeMapTwo.put(3,"Three");
        treeMapTwo.put(10,"Ten");
        treeMapTwo.put(5,"Five");
        treeMapTwo.put(9,null);

        for(Object key: treeMapTwo.keySet()){
            try{
                System.out.println(key.toString());
            }catch(NullPointerException e){
                System.out.println(e.toString());
            }
        }
    }

    //this method will be called to run the sadnbox code for Lists
    public void listSandbox(int number){
        System.out.println("listSandbox Called");
        //four types of lists
        List listA = new ArrayList();
        List<String> listAb = new ArrayList<String>();//you can concretely define what type of object if you want
        List listB = new LinkedList();
        List listD = new Stack();


        //happpy path ArrayList
        listA.add("element 0");
        listA.add("element 1");
        listA.add("element 2");
        String element0 = listA.get(0).toString();//because we didn't define it to be a string type it is interpreted as an Object
        System.out.println("listA get 0 "+element0);

            //iterator example
        Iterator iterator = listA.iterator();
        while(iterator.hasNext()) {
            String element = (String) iterator.next();
            System.out.println("iterator pass - "+element);
        }
            //foreach loop example
        for(Object object : listA) {
            String element = (String) object;
            System.out.println("foreach loop iteration - "+element);
        }

        //nasty path removing elements that don't exist
        for(int i=0;i<5;i++){
            try{
                listA.remove(0);//removing index 0 5 times when there are only 3 objects
                //results in java.lang.IndexOutOfBoundsException
            }catch(IndexOutOfBoundsException e){
                System.out.println("Woops we broke something "+e.toString());
            }
            System.out.println("Loop "+ i);
        }

        //nasty path adding indexes past length of list
        listA.clear();
        try{
            listA.add(5,"Word"); //java.lang.IndexOutOfBoundsException
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.toString());
        }

        //nasty path adding things out of order
        listA.add("Zero");
        listA.add(0,"New Zero");
        listA.add(1,"One");
        listA.add("Two");

        for(Object object : listA) {
            String element = (String) object;
            System.out.println("foreach loop iteration - "+element);
        }

        //nasty path nulls and mixed types
        listA.clear();
        listA.add(null); //no error
        //listA.add(null,1); //doesnt compile
        listA.add("stringliteral");
        listA.add(5);

        System.out.println(listA.get(0));


        //happy path LinkedList();

        List linkedL1 = new LinkedList();
        List linkedL2 = new LinkedList();

        linkedL1.add("One");
        linkedL1.add("Two");
        linkedL1.add("Three");
        linkedL1.add("Four");
        linkedL1.add("Five");

        System.out.println(linkedL1.toString());

        linkedL2.add("Six");
        linkedL2.add("Seven");
        linkedL2.add("Eight");
        linkedL2.add("Nine");
        linkedL2.add("Ten");

        System.out.println(linkedL2.toString());

        linkedL1.addAll(linkedL2);

        System.out.println(linkedL1.toString());

        //nastypath removing things
        linkedL1.remove(5);
        System.out.println(linkedL1.toString());
        try{
            linkedL1.remove(10);//out of bounds exception
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.toString());
        }

        linkedL1.remove(null);//no error, also does not appear to do anything

        try{
            linkedL1.remove(-1);
        }catch (IndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
            System.out.println(linkedL1.toString());

        //nasty path negative indices
        try{
            linkedL1.add(-1,"Negative");
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.toString());
        }

        //nasty path null index
        //linkedL1.add(null,"Null index");//doesnt compile, index needs to be of type int

    }

    //this method will be called to run the sandbox code for Sets
    public void setSandbox(int number){
        System.out.println("setSandbox Called");

        //types of sets
        Set setA = new HashSet();
        Set setB = new LinkedHashSet();
        Set setC = new TreeSet();

        //happy path HashSet
        setA.add("element 2");
        setA.add("element 0");
        setA.add("element 1");

        //access via Iterator
        Iterator iterator = setA.iterator();
        while(iterator.hasNext()){
            String element = (String) iterator.next();
        }

        //access via for loop
        for(Object object : setA) {
            String element = (String) object;
            System.out.println(element);
        }

        //nasty path HashSet having duplicate elements
        System.out.println(setA.toString());
        setA.add("element 1"); //no error
        setA.add("element 0"); //no error
        System.out.println(setA.toString());

        //nasty path adding null to hashset
        setA.add(null);
        System.out.println(setA.toString());

        if(setA.contains(null)){//no error
            System.out.println(setA.toString());
        }

        //nasty path checking empty if contains null element
        setA.clear();
        setA.add(null);

        if(setA.isEmpty()){
            System.out.println(setA.toString());
        }else{
            System.out.println(setA.toString());//this displays
        }

        //nasty path removing elements not there
        setA.clear();
        setA.remove("yolo");
        setA.remove(null);


        //happy path LinkedHashSet
        //only difference I can see between this and the last is these are not sorted automatically
        setB.add(4);
        setB.add(3);
        setB.add(20);
        setB.add(8);

        for(Object object : setB) {
            String element = object.toString();
            System.out.println(element);
        }

        //nasty path adding hashset to linkedhashset
        setA.add(2);
        setA.add(0);
        setA.add(1);

        setB.addAll(setA);
        System.out.println(setB.toString());
        setA.addAll(setB);
        System.out.println(setA.toString());


        //happy path TreeSet
        System.out.println("TreeSet happy");
        setC.addAll(setB);
        System.out.println(setC.toString());

        if(setC.containsAll(setB)){
            System.out.println("True");
        }

        //nasty path with null
        try{
            setC.add(null);//NullPointerException
        }catch (NullPointerException e){
            System.out.println(setC.toString());
        }
    }

    //this method will be called to run the sandbox code for Trees
    public void treeSandbox(int number){
        System.out.println("treeSandbox Called");
        
    }
}
