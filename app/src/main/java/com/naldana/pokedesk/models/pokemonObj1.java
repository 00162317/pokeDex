package com.naldana.pokedesk.models;

import java.util.ArrayList;

public class pokemonObj1 {
    private int count;
    private String next;
    private String previous;
    private ArrayList<pokemonObj2> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<pokemonObj2> getResults() {
        return results;
    }

    public void setResults(ArrayList<pokemonObj2> results) {
        this.results = results;
    }
}
