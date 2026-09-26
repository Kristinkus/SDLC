package lab_lcdsw.high_length.view;

import lab_lcdsw.high_length.controller.LengthController;
import lab_lcdsw.high_length.model.LengthUnit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class InputDialog extends JDialog {

    private final JTextField txtValue = new JTextField(12);
    private final JComboBox<LengthUnit> cmbFrom = new JComboBox<>(LengthUnit.values());
    private final JComboBox<LengthUnit> cmbTo = new JComboBox<>(LengthUnit.values());

    public InputDialog(JFrame parent, LengthController controller) {
        super(parent, "Ввод данных", true);
        setSize(460, 280);
        setLocationRelativeTo(parent);

        JPanel root = new JPanel(new BorderLayout(0, 12));
        root.setBackground(UiTheme.BG);
        root.setBorder(BorderFactory.createEmptyBorder(18, 20, 16, 20));
        setContentPane(root);

        JPanel form = new JPanel(new GridLayout(3, 2, 12, 14));
        form.setOpaque(false);

        JLabel lblValue = label("Длина:");
        JLabel lblFrom = label("Из единиц:");
        JLabel lblTo = label("В единицы:");

        styleField(txtValue);
        styleCombo(cmbFrom);
        styleCombo(cmbTo);

        form.add(lblValue);
        form.add(txtValue);
        form.add(lblFrom);
        form.add(cmbFrom);
        form.add(lblTo);
        form.add(cmbTo);

        JButton btnSubmit = new JButton("OK");
        btnSubmit.setPreferredSize(new Dimension(120, 40));
        btnSubmit.setFont(UiTheme.BUTTON);
        btnSubmit.setBackground(UiTheme.BUTTON_BG);
        btnSubmit.setForeground(UiTheme.BUTTON_FG);
        btnSubmit.setFocusPainted(false);
        btnSubmit.setBorderPainted(false);
        btnSubmit.setOpaque(true);
        btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        south.setOpaque(false);
        south.add(btnSubmit);

        root.add(form, BorderLayout.CENTER);
        root.add(south, BorderLayout.SOUTH);

        ActionListener submitAction = e -> controller.processInput(
                txtValue.getText(),
                (LengthUnit) cmbFrom.getSelectedItem(),
                (LengthUnit) cmbTo.getSelectedItem()
        );
        btnSubmit.addActionListener(submitAction);
        txtValue.addActionListener(submitAction);

        cmbFrom.setSelectedItem(LengthUnit.METER);
        cmbTo.setSelectedItem(LengthUnit.CENTIMETER);
    }

    private static JLabel label(String text) {
        JLabel label = new JLabel(text);
        label.setFont(UiTheme.BODY);
        label.setForeground(UiTheme.TEXT);
        return label;
    }

    private static void styleField(JTextField field) {
        field.setFont(UiTheme.BODY);
        field.setBackground(UiTheme.PANEL);
        field.setForeground(UiTheme.TEXT);
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new java.awt.Color(230, 190, 200), 1, true),
                BorderFactory.createEmptyBorder(6, 8, 6, 8)
        ));
    }

    private static void styleCombo(JComboBox<LengthUnit> combo) {
        combo.setFont(UiTheme.BODY);
        combo.setBackground(UiTheme.PANEL);
        combo.setForeground(UiTheme.TEXT);
    }

    /** Восстанавливает последние успешно введённые значения. */
    public void setValues(double value, LengthUnit from, LengthUnit to) {
        txtValue.setText(NumberFormatUtil.formatPlain(value));
        if (from != null) {
            cmbFrom.setSelectedItem(from);
        }
        if (to != null) {
            cmbTo.setSelectedItem(to);
        }
    }
}
