package order;

import drink.DrinkType;

public class Order {

    private final DrinkType drinkType;

    private int sugarNumber = 0;

    private boolean hotDrink;

    public Order(DrinkType drinkType, int sugarNumber, boolean hotDrink) {
        this.drinkType = drinkType;
        this.sugarNumber = sugarNumber;
        this.hotDrink = hotDrink;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public int getSugarNumber() {
        return sugarNumber;
    }

    public boolean isHotDrink() {
        return hotDrink;
    }
}
