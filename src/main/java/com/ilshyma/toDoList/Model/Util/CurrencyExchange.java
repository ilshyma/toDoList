package com.ilshyma.toDoList.Model.Util;

/**
 * Created by user on 10.02.2016.
 */
public class CurrencyExchange {

    private static final String EXCHANGEURL = "https://api.privatbank.ua/p24api/pubinfo?exchange&json&coursid=11";
    private String ccy;
    private String base_ccy;
    private double buy;
    private double sale;

    public static String getExchangeUrl() {
        return EXCHANGEURL;
    }

    public String getBase_ccy() {
        return base_ccy;
    }

    public void setBase_ccy(String base_ccy) {
        this.base_ccy = base_ccy;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }


}
