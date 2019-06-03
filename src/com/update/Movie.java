package com.update;

/**
 * @author : liupu
 * date   : 2019/5/31
 * desc   :
 */
public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price priceCode;

    public Movie(String title, int code) {
        this.title = title;
        setPriceCode(code);
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode.getPriceCode();
    }

    public void setPriceCode(int code) {
        switch (code) {
            case REGULAR:
                priceCode = new RegularPrice();
                break;
            case NEW_RELEASE:
                priceCode = new NewReleasePrice();
                break;
            case CHILDRENS:
                priceCode = new ChildrensPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    /**
     * 金额计算
     */
    public double getCharge(int daysRented) {
        return priceCode.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        // add bonus for a two day new release rental
        if ((getPriceCode() == NEW_RELEASE)
                && daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }
}
