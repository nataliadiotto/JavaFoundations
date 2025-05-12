package designPatterns.tests;

import designPatterns.domain.Country;
import designPatterns.domain.Currency;
import designPatterns.domain.CurrencyFactory;

public class CurrencyFactoryTest01 {

    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }

}
