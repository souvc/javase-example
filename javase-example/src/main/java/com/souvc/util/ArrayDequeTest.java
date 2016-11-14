package com.souvc.util;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * 提供了可调整大小的阵列，并实现了Deque接口
 *
 以下是关于阵列双端队列的要点：
 数组双端队列没有容量限制，使他们增长为必要支持使用。
 它们不是线程安全的;如果没有外部同步。
 不支持多线程并发访问。
 null元素被禁止使用在数组deques。
 它们要比堆栈Stack和LinkedList快。
 */
public class ArrayDequeTest {


    /**
     * 将指定元素E的deque队列的末尾
     */
    @Test
    public  void add(){
        //
        // create an empty array deque with an initial capacity
        //
        Deque<Integer> deque = new ArrayDeque<Integer>(5);

        // use add() method to add elements in the deque
        deque.add(20);
        deque.add(30);
        deque.add(20);
        deque.add(30);
        deque.add(15);
        deque.add(22);
        deque.add(11);

        // let us print all the elements available in deque
        for (Integer number : deque) {
            System.out.println("Number = " + number);
        }
    }


    /**
     * 将指定的元素E的deque队列的前面。
     */
    @Test
    public  void addFirst(){
        // create an empty array deque with an initial capacity
        Deque<Integer> deque = new ArrayDeque<Integer>(5);

        // use add() method to add elements in the deque
        deque.add(25);
        deque.add(30);
        deque.add(35);

        // use addFirst() method to add element at the front of the deque
        deque.addFirst(10);
        deque.addFirst(15);
        deque.addFirst(20);//now, element 20 will be at the front

        // these elments will be added in continuation with deque.add(35)
        deque.add(45);
        deque.add(40);

        // let us print all the elements available in deque
        for (Integer number : deque) {
            System.out.println("Number = " + number);
        }
    }


    /**
     * 将指定的元素E加到deque队列的末尾。
     */
    @Test
    public  void  addLast(){
        // create an empty array deque with an initial capacity
        Deque<Integer> deque = new ArrayDeque<Integer>(8);

        // use add() method to add elements in the deque
        deque.add(20);
        deque.add(30);
        deque.add(20);
        deque.add(18);
        deque.add(22);
        deque.add(24);

        // the values will be printed in the same order
        deque.addLast(10);
        deque.addLast(12);

        // let us print all the elements available in deque
        for (Integer number : deque) {
            System.out.println("Number = " + number);
        }
    }


    /**
     * 移除此deque队列的所有元素。
     */
    @Test
    public  void  clear(){

        // create an empty array deque with an initial capacity
        Deque<Integer> deque = new ArrayDeque<Integer>(8);

        // use add() method to add elements in the deque
        deque.add(20);
        deque.add(30);
        deque.add(10);

        // let us print all the elements available in deque
        for (Integer number : deque) {
            System.out.println("Number = " + number);
        }

        // finding size of this deque
        int retval = deque.size();
        System.out.println("Deque consists of "+ retval +" elements");

        System.out.println("Performing clear operation !!");
        deque.clear();
        retval = deque.size();
        System.out.println("Now, deque consists of "+ retval +" elements");
    }


    /**
     * 返回此deque队列的副本
     */
    @Test
    public   void  clone1(){

        // create an empty array deque with an initial capacity
        ArrayDeque<Integer> deque1 = new ArrayDeque<Integer>(8);

        // use add() method to add elements in the deque
        deque1.add(15);
        deque1.add(30);
        deque1.add(20);
        deque1.add(18);

        // clone the first deque,
        Deque<Integer> deque2 = deque1.clone();

        // let us print all the elements available in deque2
        // now deque2 should have similar elements to deque1.
        for (Integer number : deque2) {
            System.out.println("Number = " + number);
        }

    }


    /**
     * deque队列包含指定的元素
     */
    @Test
    public   void  contains(){

        // create an empty array deque with an initial capacity
        Deque<Integer> deque = new ArrayDeque<Integer>(8);

        // use add() method to add elements in the deque
        deque.add(20);
        deque.add(30);
        deque.add(10);
        deque.add(18);

        // let us print all the elements available in deque
        for (Integer number : deque) {
            System.out.println("Number = " + number);
        }

        // deque contains element 10
        boolean retval = deque.contains(10);

        if (retval == true) {
            System.out.println("element 10 is contained in the deque");
        }
        else {
            System.out.println("element 10 is not contained in the deque");
        }

        // deque does not contain element 25
        boolean retval2 = deque.contains(25);

        if (retval2 == true) {
            System.out.println("element 25 is contained in the deque");
        }
        else {
            System.out.println("element 25 is not contained in the deque");
        }

    }


    /**
     * 一个迭代器在此deque 队列以逆向顺序的元素
     */
    @Test
    public  void   descendingIterator(){
        // create an empty array deque with an initial capacity
        Deque<Integer> deque = new ArrayDeque<Integer>(8);

        // use add() method to add elements in the deque
        deque.add(15);
        deque.add(22);
        deque.add(25);
        deque.add(20);

        //iterator() is used to print all the elements
        //next() returns the next element on each iteration
        System.out.println("printing elements using iterator:");

        for(Iterator itr = deque.iterator(); itr.hasNext();)  {
            System.out.println(itr.next());
        }

        //descendingIterator() is used to print the elements in reverse order
        //next() returns the next element on each iteration
        System.out.println("printing elements in reverse order:");

        for(Iterator descItr = deque.descendingIterator();descItr.hasNext();) {
            System.out.println(descItr.next());
        }
    }


    /**
     * 检索，但是不移除此deque队列表示的队列的头部。
     */
    @Test
    public  void  element(){

        // create an empty array deque with an initial capacity
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(8);

        // use add() method to add elements in the deque
        deque.add(25);
        deque.add(30);
        deque.add(20);
        deque.add(18);

        // let us print all the elements available in deque
        for (Integer number : deque) {
            System.out.println("Number = " + number);
        }

        // it will retrive element at first(head) position
        int retval = deque.element();
        System.out.println("Retrieved Element is = " + retval);

    }



}
