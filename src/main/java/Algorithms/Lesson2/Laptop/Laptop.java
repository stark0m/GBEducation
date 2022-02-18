package Algorithms.Lesson2.Laptop;

import java.util.Random;

public class Laptop {
    private int price;
    private int ramInstalled;
    private String brandName;

    private static final int PRICE_STEP=50;
    private static final int MIN_PRICE=500;
    private static final int MAX_PRICE=2000;

    private static final int RAM_STEP=4;
    private static final int MIN_RAM=4;
    private static final int MAX_RAM=24;

    private static int priceRange = (MAX_PRICE-MIN_PRICE)/PRICE_STEP;
    private static int ramRange = (MAX_RAM-MIN_RAM)/RAM_STEP;
    private static Random rnd = new Random();
    private static String[] BRAND_NAME= {"Lenuvo","Asos","MacNote","Eser","Xamiou"};

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRamInstalled() {
        return ramInstalled;
    }

    public void setRamInstalled(int ramInstalled) {
        this.ramInstalled = ramInstalled;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Laptop() {
        this.setPrice(500);
        this.setBrandName("NoName");
        this.setRamInstalled(24);
    }

    public void genLaptop(){
        this.setPrice(rnd.nextInt(priceRange+1)*PRICE_STEP+MIN_PRICE);
        this.setRamInstalled(rnd.nextInt(ramRange+1)*RAM_STEP+MIN_RAM);
        this.setBrandName(BRAND_NAME[rnd.nextInt(BRAND_NAME.length)]);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "price=" + price +
                ", ramInstalled=" + ramInstalled +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
