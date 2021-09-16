
import ru.kassa.Price;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.kassa.PriceTogether;

public class PriceTogetherJUnitTest {

    public PriceTogetherJUnitTest() {
    }

    @Test
    public void test() throws ParseException {
        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        Price price1 = new Price();
        price1.begin = formater.parse(new String("01.01.2013 00:00:00"));
        price1.end = formater.parse(new String("31.01.2013 23:59:59"));
        price1.number = 1;
        price1.depart = 1;
        price1.productCode = "122856";
        price1.value = 11000;

        Price price2 = new Price();
        price2.begin = formater.parse(new String("10.01.2013 00:00:00"));
        price2.end = formater.parse(new String("20.01.2013 23:59:59"));
        price2.number = 2;
        price2.depart = 1;
        price2.productCode = "122856";
        price2.value = 99000;

        Price price3 = new Price();
        price3.begin = formater.parse(new String("01.01.2013 00:00:00"));
        price3.end = formater.parse(new String("31.01.2013 00:00:00"));
        price3.number = 1;
        price3.depart = 2;
        price3.productCode = "6654";
        price3.value = 5000;

        List<Price> prices = new ArrayList<Price>();
        prices.add(price1);
        prices.add(price2);
        prices.add(price3);

        List<Price> newPrices = new ArrayList<Price>();

        Price price4 = new Price();
        price4.begin = formater.parse(new String("20.01.2013 00:00:00"));
        price4.end = formater.parse(new String("20.02.2013 23:59:59"));
        price4.number = 1;
        price4.depart = 1;
        price4.productCode = "122856";
        price4.value = 11000;

        Price price5 = new Price();
        price5.begin = formater.parse(new String("15.01.2013 00:00:00"));
        price5.end = formater.parse(new String("25.01.2013 23:59:59"));
        price5.number = 2;
        price5.depart = 1;
        price5.productCode = "122856";
        price5.value = 92000;

        Price price6 = new Price();
        price6.begin = formater.parse(new String("12.01.2013 00:00:00"));
        price6.end = formater.parse(new String("13.01.2013 00:00:00"));
        price6.number = 1;
        price6.depart = 2;
        price6.productCode = "6654";
        price6.value = 4000;

        newPrices.add(price4);
        newPrices.add(price5);
        newPrices.add(price6);

        List<Price> result = PriceTogether.together(newPrices, prices);

        System.out.println(result);
        assertEquals(result.size(), 6);
    }
}