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
    public double getCharge(int daysRented) {
        double result = 0;
        // determine amounts for each line
        switch (getPriceCode()) {
            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
        }
        return result;
    }
}
