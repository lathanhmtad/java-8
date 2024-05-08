package org.example.compare;

// A Java program to demonstrate Comparator interface

import java.io.*;
import java.util.*;

// A class 'Movie' that implements Comparable
class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;

    public Movie(String name, double rating, int year) {
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(Movie m) {
        if(this.getRating() > m.getRating())
            return 1;
        if(this.getRating() < m.getRating())
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}

// Class to compare Movies by ratings
class RatingCompare implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        if(o1.getRating() > o2.getRating())
            return 1;
        if(o1.getRating() < o2.getRating())
            return -1;
        return 0;
    }
}


// Class to compare Movies by name


// Driver class
class Main {
    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Star Wars 2", 8.7, 1977));
        list.add(
                new Movie("Return of the Jedi", 8.4, 1983));
        list.add(
                new Movie("Empire Strikes Back", 8.8, 1980));
        list.forEach(System.out::println);
        // Uses Comparable to sort by year
//        Collections.sort(list);
//        list.forEach(System.out::println);

        // Uses Comparator to sort by ratings
//        System.out.println("Sorted by rating");
//        RatingCompare ratingCompare = new RatingCompare();
//        list.sort(ratingCompare);
//        list.forEach(System.out::println);

        // Uses Comparator expression lambda to sort by ratings
        System.out.println("Sorted by rating using expression lambda");
//        list.sort((m1, m2) -> {
//            if(m1.getRating() > m2.getRating())
//                return 1;
//            if(m1.getRating() < m2.getRating())
//                return -1;
//            m1.compareTo(m2);
//            return 0;
//        });
        list.sort(Movie::compareTo);
        list.forEach(System.out::println);


    }
}
