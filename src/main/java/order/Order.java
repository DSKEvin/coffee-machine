package order;

import drink.DrinkType;

public class Order {

    private DrinkType drinkType;

    private int sugarNumber = 0;

    public Order(DrinkType drinkType, int sugarNumber) {
        this.drinkType = drinkType;
        this.sugarNumber = sugarNumber;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public int getSugarNumber() {
        return sugarNumber;
    }
}
