package com.company.sources;

public class Pair <X,Y> {
    public X left;
    public Y right;


    public Pair(X left, Y right) {
        this.left = left;
        this.right = right;
    }

    public Pair() {
        this(null,null);
    }

}
