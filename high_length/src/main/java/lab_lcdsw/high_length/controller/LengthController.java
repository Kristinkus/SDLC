package lab_lcdsw.high_length.controller;

import lab_lcdsw.high_length.model.LengthModel;
import lab_lcdsw.high_length.model.LengthUnit;
import lab_lcdsw.high_length.view.InputDialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class LengthController {

    private final LengthModel model;
    private InputDialog inputDialog;

    public LengthController(LengthModel model) {
        this.model = model;
    }

    public void openInputDialog(JFrame parent) {
        if (inputDialog == null || !inputDialog.isDisplayable()) {
            inputDialog = new InputDialog(parent, this);
        }
        // Восстановление последних введённых данных из модели
        if (model.hasResult()) {
            inputDialog.setValues(model.getInputValue(), model.getFromUnit(), model.getToUnit());
        }
        inputDialog.setVisible(true);
    }

    public void processInput(String valueStr, LengthUnit fromUnit, LengthUnit toUnit) {
        try {
            String trimmed = valueStr == null ? "" : valueStr.trim().replace(',', '.');
            if (trimmed.isEmpty()) {
                throw new IllegalArgumentException("Введите значение длины!");
            }
            double value = Double.parseDouble(trimmed);
            model.setData(value, fromUnit, toUnit);
            if (inputDialog != null) {
                inputDialog.dispose();
            }
        } catch (NumberFormatException e) {
            showError("Ошибка: введите корректное числовое значение длины!");
        } catch (IllegalArgumentException e) {
            showError("Ошибка: " + e.getMessage());
        }
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
    }
}
