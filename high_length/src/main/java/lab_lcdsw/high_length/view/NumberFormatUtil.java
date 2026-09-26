package lab_lcdsw.high_length.view;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Форматирование чисел:
 * обычно 2 знака после запятой;
 * для |x| &lt; 1 — до 5 знаков после запятой.
 */
public final class NumberFormatUtil {

    private NumberFormatUtil() {
    }

    public static String format(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            return String.valueOf(value);
        }

        double abs = Math.abs(value);
        int maxFraction = (abs > 0.0 && abs < 1.0) ? 5 : 2;
        int minFraction = (abs > 0.0 && abs < 1.0) ? 0 : 2;

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("ru", "RU"));
        symbols.setGroupingSeparator('\u00A0');
        symbols.setDecimalSeparator(',');

        DecimalFormat df = new DecimalFormat();
        df.setDecimalFormatSymbols(symbols);
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        df.setMinimumFractionDigits(minFraction);
        df.setMaximumFractionDigits(maxFraction);
        df.setMinimumIntegerDigits(1);

        String formatted = df.format(value);
        if (abs > 0.0 && abs < 1.0) {
            formatted = stripTrailingZeros(formatted);
        }
        return formatted;
    }

    /** Компактный вид для поля ввода (точка, без пробелов). */
    public static String formatPlain(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            return String.valueOf(value);
        }
        double abs = Math.abs(value);
        if (abs > 0.0 && abs < 1.0) {
            return stripPlainZeros(String.format(Locale.US, "%.5f", value));
        }
        if (value == Math.rint(value) && abs < 1e12) {
            return String.valueOf((long) value);
        }
        return String.format(Locale.US, "%.2f", value);
    }

    private static String stripTrailingZeros(String formatted) {
        if (!formatted.contains(",")) {
            return formatted;
        }
        String trimmed = formatted.replaceAll("0+$", "");
        if (trimmed.endsWith(",")) {
            trimmed = trimmed.substring(0, trimmed.length() - 1);
        }
        return trimmed.isEmpty() ? "0" : trimmed;
    }

    private static String stripPlainZeros(String formatted) {
        String trimmed = formatted.replaceAll("0+$", "");
        if (trimmed.endsWith(".")) {
            trimmed = trimmed.substring(0, trimmed.length() - 1);
        }
        return trimmed.isEmpty() ? "0" : trimmed;
    }
}
