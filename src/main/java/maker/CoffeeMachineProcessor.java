package maker;

import order.Order;

import java.util.Objects;

public class CoffeeMachineProcessor implements Display {

    public DrinkMaker drinkMaker;

    public static final String SEPARATOR = ":";
    public static final String MESSAGE_PREFIX = "M:";

    public void processDrinkOrder(Order order) {
        StringBuilder makerInstruction = new StringBuilder();
        if (Objects.nonNull(order)) {
            makerInstruction.append(order.getDrinkType().getCode())
                    .append(order.isHotDrink() && order.getDrinkType().canOrderHot() ? "h" : "")
                    .append(SEPARATOR)
                    .append(order.getSugarNumber() > 0 ? order.getSugarNumber() : "")
                    .append(SEPARATOR)
                    .append(addStickDependingOnSugarNumber(order.getSugarNumber()));
        }

         drinkMaker.send(makerInstruction.toString());
    }



    private String addStickDependingOnSugarNumber(Integer sugarNumber) {
        return sugarNumber > 0 ? "0" : "";
    }

    @Override
    public void display(String message) {
        drinkMaker.send(MESSAGE_PREFIX + message);
    }
}
