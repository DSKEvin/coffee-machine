package maker;

import drink.DrinkType;
import order.Order;

public class CoffeeMakerService {

    private CoffeeMachineProcessor coffeeMachineProcessor;

    private int moneyInserted = 0;

    public CoffeeMakerService(CoffeeMachineProcessor coffeeMachineProcessor) {
        this.coffeeMachineProcessor = coffeeMachineProcessor;
    }

    public void command(Order order) {
        if (this.moneyInserted >= order.getDrinkType().getPriceInCents()) {
            coffeeMachineProcessor.processDrinkOrder(order);
        } else {
            coffeeMachineProcessor.display("Missing money : " + calculateMissingMoney(order.getDrinkType().getPriceInCents()));
        }
    }

    public void receiveMoney(int cents) {
        this.moneyInserted += cents;
    }

    public int calculateMissingMoney(int price) {
        return price - this.moneyInserted;
    }
}
