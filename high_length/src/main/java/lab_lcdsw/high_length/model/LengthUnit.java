package lab_lcdsw.high_length.model;


public enum LengthUnit {
    INCH("Дюйм", "дюйм", "дюйма", "дюймов", 0.0254),
    YARD("Ярд", "ярд", "ярда", "ярдов", 0.9144),
    CENTIMETER("Сантиметр", "сантиметр", "сантиметра", "сантиметров", 0.01),
    METER("Метр", "метр", "метра", "метров", 1.0),
    COCKROACH("Американский таракан", "американский таракан",
            "американских таракана", "американских тараканов", 0.04),
    GIRAFFE_NECK("Шея жирафа", "шея жирафа", "шеи жирафа", "шей жирафа", 2.0),
    LONGEST_SNAKE("Самая длинная змея", "самая длинная змея",
            "самых длинных змеи", "самых длинных змей", 10.0),
    HUMAN_TONGUE("Человеческий язык", "человеческий язык",
            "человеческих языка", "человеческих языков", 0.10),
    FOOTBALL_FIELD("Футбольное поле", "футбольное поле",
            "футбольных поля", "футбольных полей", 105.0);

    private final String displayName;
    private final String one;
    private final String few;
    private final String many;
    private final double meters;

    LengthUnit(String displayName, String one, String few, String many, double meters) {
        this.displayName = displayName;
        this.one = one;
        this.few = few;
        this.many = many;
        this.meters = meters;
    }

    public String getDisplayName() {
        return displayName;
    }

    /** Форма единицы по правилам русского множественного числа. */
    public String forQuantity(double value) {
        long n = (long) Math.floor(Math.abs(value));
        long mod100 = n % 100;
        long mod10 = n % 10;
        if (mod10 == 1 && mod100 != 11) {
            return one;
        }
        if (mod10 >= 2 && mod10 <= 4 && !(mod100 >= 12 && mod100 <= 14)) {
            return few;
        }
        return many;
    }

    public double toMeters() {
        return meters;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
