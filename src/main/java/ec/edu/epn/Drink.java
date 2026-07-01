package ec.edu.epn;

import java.util.Arrays;

public enum Drink {
    BEER("hansa", 74, true, false),
    CIDER("grans", 103, true, false),
    PROPER_CIDER("strongbow", 110, true, false),
    GIN_AND_TONIC("gt", Drink.GIN_PRICE + Drink.TONIC_WATER_PRICE + Drink.GARNISH_PRICE, false, true),
    BACARDI_SPECIAL("bacardi_special", Drink.HALF_GIN_PRICE + Drink.RUM_PRICE + Drink.GRENADINE_PRICE + Drink.LIME_JUICE_PRICE, false, true);

    private static final int GIN_PRICE = 85;
    private static final int HALF_GIN_PRICE = GIN_PRICE / 2;
    private static final int TONIC_WATER_PRICE = 20;
    private static final int GARNISH_PRICE = 10;
    private static final int RUM_PRICE = 65;
    private static final int GRENADINE_PRICE = 10;
    private static final int LIME_JUICE_PRICE = 10;

    private final String code;
    private final int price;
    private final boolean studentDiscountEligible;
    private final boolean cocktail;

    Drink(String code, int price, boolean studentDiscountEligible, boolean cocktail) {
        this.code = code;
        this.price = price;
        this.studentDiscountEligible = studentDiscountEligible;
        this.cocktail = cocktail;
    }

    public static Drink fromCode(String code) {
        if (code == null) {
            throw new RuntimeException("Drink cannot be null");
        }
        return Arrays.stream(values())
                .filter(drink -> drink.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such drink exists"));
    }

    public String getCode() {
        return code;
    }

    public int getPrice() {
        return price;
    }

    public boolean isStudentDiscountEligible() {
        return studentDiscountEligible;
    }

    public boolean isCocktail() {
        return cocktail;
    }
}
