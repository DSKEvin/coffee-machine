package drink;

public enum DrinkType {
    COFFEE("C",60), TEA("T", 40), CHOCOLATE("H", 50);

    private final String code;

    private final int priceInCents;

    DrinkType(String code, int priceInCents) {
        this.code = code;
        this.priceInCents = priceInCents;
    }

    public String getCode() {
        return code;
    }

    public int getPriceInCents() {
        return priceInCents;
    }
}
