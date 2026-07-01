package ec.edu.epn;

public class Pub {
    public static final String ONE_BEER = Drink.BEER.getCode();
    public static final String ONE_CIDER = Drink.CIDER.getCode();
    public static final String A_PROPER_CIDER = Drink.PROPER_CIDER.getCode();
    public static final String GT = Drink.GIN_AND_TONIC.getCode();
    public static final String BACARDI_SPECIAL = Drink.BACARDI_SPECIAL.getCode();

    private static final int MAX_COCKTAILS_PER_ORDER = 2;
    private static final int STUDENT_DISCOUNT_DIVISOR = 10;

    public int computeCost(String drinkCode, boolean student, int amount) {
        Drink drink = Drink.fromCode(drinkCode);
        validateAmount(drink, amount);
        int unitPrice = calculateUnitPrice(drink, student);
        return unitPrice * amount;
    }

    private void validateAmount(Drink drink, int amount) {
        if (drink.isCocktail() && amount > MAX_COCKTAILS_PER_ORDER) {
            throw new RuntimeException("Too many drinks, max " + MAX_COCKTAILS_PER_ORDER + ".");
        }
    }

    private int calculateUnitPrice(Drink drink, boolean student) {
        int price = drink.getPrice();
        if (student && drink.isStudentDiscountEligible()) {
            price = applyStudentDiscount(price);
        }
        return price;
    }

    private int applyStudentDiscount(int price) {
        return price - price / STUDENT_DISCOUNT_DIVISOR;
    }
}
