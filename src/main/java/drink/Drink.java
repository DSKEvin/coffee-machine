package drink;

public class Drink {

    private Integer sugarNumber;

    private boolean hasStick;

    public Drink(Integer sugarNumber, boolean hasStick) {
        this.sugarNumber = sugarNumber;
        this.hasStick = hasStick;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drink drink = (Drink) o;

        if (hasStick != drink.hasStick) return false;
        return sugarNumber != null ? sugarNumber.equals(drink.sugarNumber) : drink.sugarNumber == null;
    }

    @Override
    public int hashCode() {
        int result = sugarNumber != null ? sugarNumber.hashCode() : 0;
        result = 31 * result + (hasStick ? 1 : 0);
        return result;
    }
}
