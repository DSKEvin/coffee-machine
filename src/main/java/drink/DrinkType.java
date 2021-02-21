package drink;

public enum DrinkType {
    COFFEE("C",60, true), TEA("T", 40, true), CHOCOLATE("H", 50, true), ORANGE_JUICE("O", 60, false);

    private final String code;

    private final int priceInCents;

    private final boolean canOrderHot;

    DrinkType(String code, int priceInCents, boolean canOrderHot) {
        this.code = code;
        this.priceInCents = priceInCents;
        this.canOrderHot = canOrderHot;
    }

    public String getCode() {
        return code;
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public boolean canOrderHot() {
        return canOrderHot;
    }
}
