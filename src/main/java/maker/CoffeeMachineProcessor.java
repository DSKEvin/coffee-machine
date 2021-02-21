package maker;

import java.util.Objects;

public class CoffeeMachineProcessor {

    public DrinkMaker drinkMaker;

    public static final String SEPARATOR = ":";

    public void processDrinkOrder(Order order) {
        StringBuilder makerInstruction = new StringBuilder();
        if (Objects.nonNull(order)) {
            makerInstruction.append(order.getDrinkType().getCode())
                    .append(SEPARATOR)
                    .append(order.getSugarNumber() > 0 ? order.getSugarNumber() : "")
                    .append(SEPARATOR)
                    .append(addStickDependingOnSugarNumber(order.getSugarNumber()));
        }

         drinkMaker.makeDrink(makerInstruction.toString());
    }

    private String addStickDependingOnSugarNumber(Integer sugarNumber) {
        return sugarNumber > 0 ? "0" : "";
    }
}
