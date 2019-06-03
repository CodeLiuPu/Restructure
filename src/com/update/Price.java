package com.update;

/**
 * @author : liupu.
 * date : 2019/06/03
 * desc :
 */
public abstract class Price {
    abstract int getPriceCode();

    /**
     * 金额计算
     */
    abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        // add bonus for a two day new release rental
        return 1;
    }
}
