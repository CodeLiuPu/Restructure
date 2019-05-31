package com.update;

/**
 * @author : liupu
 * date   : 2019/5/31
 * desc   : 租赁
 */
public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge(){
        return getMovie().getCharge(daysRented);
    }
    public int getFrequentRenterPoints() {
        // add bonus for a two day new release rental
        return getMovie().getFrequentRenterPoints(daysRented);
    }

}
