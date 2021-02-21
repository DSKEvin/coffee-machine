public enum DrinkType {
    COFFEE("C"), TEA("T"), CHOCOLATE("H");

    private final String code;

    DrinkType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
