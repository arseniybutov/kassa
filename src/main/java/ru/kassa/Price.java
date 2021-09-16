package ru.kassa;

import java.util.Date;

public class Price implements Cloneable {

    public long id;
    public String productCode;
    public int number;
    public int depart;
    public Date begin;
    public Date end;
    public long value;

    @Override
    public String toString() {
        return "Price{" + "id=" + id + ", productCode=" + productCode + ", number=" + number + ", depart=" + depart + ", begin=" + begin + ", end=" + end + ", value=" + value + '}';
    }

    public Object clone() {
        Price price = new Price();
        price.id = this.id;
        price.productCode = this.productCode;
        price.number = this.number;
        price.depart = this.depart;
        price.begin = this.begin;
        price.end = this.end;
        price.value = this.value;

        return price;
    }
}
