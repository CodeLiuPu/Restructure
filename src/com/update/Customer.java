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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = mRrentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();

        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

}
