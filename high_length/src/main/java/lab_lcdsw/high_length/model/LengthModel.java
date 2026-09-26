package lab_lcdsw.high_length.model;

import java.util.ArrayList;
import java.util.List;

public class LengthModel {

    public interface ModelListener {
        void onModelChanged();
    }

    private double inputValue;
    private LengthUnit fromUnit = LengthUnit.METER;
    private LengthUnit toUnit = LengthUnit.CENTIMETER;
    private double resultValue;
    private boolean hasResult;

    private final List<ModelListener> listeners = new ArrayList<>();

    public void addListener(ModelListener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (ModelListener listener : listeners) {
            listener.onModelChanged();
        }
    }


    public void setData(double value, LengthUnit from, LengthUnit to) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Длина должна быть конечным числом!");
        }
        if (value < 0) {
            throw new IllegalArgumentException("Длина не может быть отрицательной!");
        }
        if (from == null || to == null) {
            throw new IllegalArgumentException("Необходимо выбрать единицы измерения!");
        }

        this.inputValue = value;
        this.fromUnit = from;
        this.toUnit = to;
        this.resultValue = convert(value, from, to);
        this.hasResult = true;
        notifyListeners();
    }

    private double convert(double value, LengthUnit from, LengthUnit to) {
        double meters = value * from.toMeters();
        return meters / to.toMeters();
    }

    public double getInputValue() {
        return inputValue;
    }

    public LengthUnit getFromUnit() {
        return fromUnit;
    }

    public LengthUnit getToUnit() {
        return toUnit;
    }

    public double getResultValue() {
        return resultValue;
    }

    public boolean hasResult() {
        return hasResult;
    }
}
