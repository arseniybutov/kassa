package ru.kassa;

import java.util.ArrayList;
import java.util.List;

public class PriceTogether {

    public static List<Price> together(List<Price> newPrices, List<Price> prices) {
        List<Price> newList = new ArrayList<Price>();
        newList.addAll(prices);

        boolean noPeresechenie = true;
        boolean noPrice = true;
        boolean peresechenieSamePrice = false;
        boolean toAddNewPrice = true;

        for (Price newPrice : newPrices) {
            noPeresechenie = true;
            noPrice = true;
            peresechenieSamePrice = false;
            toAddNewPrice = true;

            for (Price oldPrice : prices) {
                if (newPrice.productCode.equals(oldPrice.productCode)) {
                    noPrice = false;

                    if ((newPrice.begin.after(oldPrice.end) || newPrice.end.before(oldPrice.begin))) {
                        noPeresechenie = true;
                    } else {
                        noPeresechenie = false;
                    }

                    if (!noPeresechenie) {
                        if (newPrice.number == oldPrice.number && newPrice.depart == oldPrice.depart) {

                            if (oldPrice.value == newPrice.value) {
                                peresechenieSamePrice = true;

                                oldPrice.end = newPrice.end;
                                toAddNewPrice = false;
                            } else {

                                if (newPrice.begin.after(oldPrice.begin) && newPrice.begin.before(oldPrice.end)
                                        && newPrice.end.after(oldPrice.begin) && newPrice.end.before(oldPrice.end)) {
                                    Price clonedPrice = (Price) oldPrice.clone();
                                    clonedPrice.begin = newPrice.end;
                                    oldPrice.end = newPrice.begin;

                                    newList.add(clonedPrice);
                                } else if (newPrice.begin.after(oldPrice.begin) && newPrice.begin.before(oldPrice.end)
                                        && newPrice.end.after(oldPrice.end)) {
                                    oldPrice.end = newPrice.begin;
                                }

                                toAddNewPrice = true;
                            }
                        }
                    }
                }
            }

            if (noPrice || noPeresechenie || (!noPeresechenie && !peresechenieSamePrice)) {
                if (toAddNewPrice) {
                    newList.add(newPrice);
                }
            }
        }

        return newList;
    }

}