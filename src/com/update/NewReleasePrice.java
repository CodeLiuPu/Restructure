package com.update;

/**
 * @author : liupu.
 * date : 2019/06/03
 * desc :
 */
public class NewReleasePrice extends Price{
    @Override
    int getPriceCode() {
        return Movie.NEW_RELEASE;
    }
}