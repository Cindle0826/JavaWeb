package com.web.tag.util;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class MyStock {

    /*
        漲停: price, change 的背景是紅色, 字是黃色 
        跌停: price, change 的背景是綠色, 字是黃色
        加入買價bid、賣價ask、作收、量

        網頁後面+ ?symbols=2330.TW,2317.TW,1101.TW,1102.TW
     */
    private static final String RED = "#FF0000";
    private static final String GREEN = "#005100";
    private static final String BLACK = "#000000";
    private String symbol;
    private String name;
    private Double price;
    private Double change;
    private String color;

    public MyStock() {
    }

    public MyStock(String symbol) {
        setSymbol(symbol);

    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        try {
            Stock stock = YahooFinance.get("INTC");
            this.name = stock.getName();
            this.price = stock.getQuote().getPrice().doubleValue();
            this.change = stock.getQuote().getChangeInPercent().doubleValue();
            this.color = (this.change > 0) ? RED : (this.change < 0) ? GREEN : BLACK;
        } catch (Exception e) {
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getChange() {
        return change;
    }

    public void setChange(Double cjange) {
        this.change = cjange;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
