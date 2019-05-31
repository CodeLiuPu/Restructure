package com.update;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author : liupu
 * date   : 2019/5/31
 * desc   : 顾客
 */
public class Customer {
    private String name;
    private Vector<Rental> mRrentals;

    public Customer(String name) {
        this.name = name;
        mRrentals = new Vector();
    }

    public void addRental(Rental rental) {
        mRrentals.add(rental);
    }

    public String getName() {
        return name;
    }

    /**
     * 生成详单
     */
    public String statement() {
        Enumeration<Rental> rentals = mRrentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    /**
     * 生成 Html 详单
     */
    public String htmlStatement() {
        Enumeration<Rental> rentals = mRrentals.elements();
        String result = "<Html> Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

        }

        // add footer lines
        result += "<Html> Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "<Html> You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> rentals = mRrentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getCharge();

        }
        return result;
    }

    private int getFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> rentals = mRrentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }

        return result;
    }
}
