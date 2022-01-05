package com.company;

import com.company.sources.Pair;

import java.util.LinkedList;
import java.util.List;

/**
 * - Implement Pair generic class
 *      - it should have two attributes named 'left' & 'right'
 *      - create a list of pair objects
 * - Perform the following operations on a list, set and map: CRUD - Create, Read, Update, Delete
 *      - add one element
 *      - get one element
 *      - remove one element
 *      - update one element
 * - A User can have multiple Address(es) - create the 2 classes
 *      - choose a collection to store users&addresses objects so that you could
 *      get a list of addresses by a specific user
 *      - choose a different collection to store all the addresses of all users with
 *      no duplicates
 *      - take a look at the implementation of ArrayList.add method and note how the
 *      data structure gets resized. What happens with the data structure on removing elements
 * - Explore java streams (search for online tutorials)
 *      e.g.: https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */
public class Main {

    public static void main(String[] args) {

        List<Pair<Integer,String>> pairList = new LinkedList<>();

        pairList.add(new Pair<Integer,String>(1,"one"));
        pairList.add(new Pair<Integer,String>(2,"two"));
        pairList.add(new Pair<Integer,String>(3,"three"));
        pairList.add(new Pair<Integer,String>(4,"four"));






    }
}
