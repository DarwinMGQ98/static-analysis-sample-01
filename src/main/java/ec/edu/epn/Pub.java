package ec.edu.epn;

public class Pub {
    public static final String ONE_BEER = "hansa";
    public static final String ONE_CIDER = "grans";
    public static final String A_PROPER_CIDER = "strongbow";
    public static final String GT = "gt";
    public static final String BACARDI_SPECIAL = "bacardi_special";

    private static final int BEER_PRICE = 74;
    private static final int CIDER_PRICE = 103;
    private static final int PROPER_CIDER_PRICE = 110;
    private static final int MAX_COCKTAIL_AMOUNT = 2;
    private static final int STUDENT_DISCOUNT_DIVISOR = 10;
    private static final int RUM_PRICE = 65;
    private static final int GRENADINE_PRICE = 10;
    private static final int LIME_JUICE_PRICE = 10;
    private static final int GREEN_STUFF_PRICE = 10;
    private static final int TONIC_WATER_PRICE = 20;
    private static final int GIN_PRICE = 85;

    public int computeCost(String drink, boolean student, int amount) {
        if (drink == null) {
            throw new RuntimeException("Drink cannot be null");
        }
        if (amount > MAX_COCKTAIL_AMOUNT && (drink.equals(GT) || drink.equals(BACARDI_SPECIAL))) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        int price;
        if (drink.equals(ONE_BEER)) {
            price = BEER_PRICE;
        } else if (drink.equals(ONE_CIDER)) {
            price = CIDER_PRICE;
        } else if (drink.equals(A_PROPER_CIDER)) {
            price = PROPER_CIDER_PRICE;
        } else if (drink.equals(GT)) {
            price = GIN_PRICE + TONIC_WATER_PRICE + GREEN_STUFF_PRICE;
        } else if (drink.equals(BACARDI_SPECIAL)) {
            price = GIN_PRICE / 2 + RUM_PRICE + GRENADINE_PRICE + LIME_JUICE_PRICE;
        } else {
            throw new RuntimeException("No such drink exists");
        }
        if (student && (drink.equals(ONE_CIDER) || drink.equals(ONE_BEER) || drink.equals(A_PROPER_CIDER))) {
            price = price - price / STUDENT_DISCOUNT_DIVISOR;
        }
        return price * amount;
    }
}
