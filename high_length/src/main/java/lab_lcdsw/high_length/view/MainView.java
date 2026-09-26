package lab_lcdsw.high_length.view;

import lab_lcdsw.high_length.controller.LengthController;
import lab_lcdsw.high_length.model.LengthModel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class MainView extends JFrame implements LengthModel.ModelListener {

    private final LengthController controller;
    private final LengthModel model;

    private final JLabel lblTitle = new JLabel("Высота и длина", SwingConstants.CENTER);
    private final JLabel lblInput = new JLabel("Данные ещё не введены", SwingConstants.CENTER);
    private final JLabel lblResult = new JLabel("Результат: —", SwingConstants.CENTER);

    public MainView(LengthController controller, LengthModel model) {
        this.controller = controller;
        this.model = model;
        this.model.addListener(this);
        initView();
    }

    private void initView() {
        setTitle("Высота и длина");
        setSize(620, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout(0, 12));
        root.setBackground(UiTheme.BG);
        root.setBorder(BorderFactory.createEmptyBorder(24, 28, 24, 28));
        setContentPane(root);

        lblTitle.setFont(UiTheme.TITLE);
        lblTitle.setForeground(UiTheme.ACCENT_DARK);

        JPanel card = new JPanel(new BorderLayout(0, 18));
        card.setBackground(UiTheme.PANEL);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new java.awt.Color(235, 200, 210), 1, true),
                BorderFactory.createEmptyBorder(28, 24, 28, 24)
        ));

        lblInput.setFont(UiTheme.BODY);
        lblInput.setForeground(UiTheme.MUTED);

        lblResult.setFont(UiTheme.RESULT);
        lblResult.setForeground(UiTheme.ACCENT_DARK);

        JPanel texts = new JPanel(new BorderLayout(0, 14));
        texts.setOpaque(false);
        texts.add(lblInput, BorderLayout.NORTH);
        texts.add(lblResult, BorderLayout.CENTER);
        card.add(texts, BorderLayout.CENTER);

        JButton btnOpenInput = new JButton("Ввести данные");
        btnOpenInput.setPreferredSize(new Dimension(200, 44));
        btnOpenInput.setFont(UiTheme.BUTTON);
        btnOpenInput.setBackground(UiTheme.BUTTON_BG);
        btnOpenInput.setForeground(UiTheme.BUTTON_FG);
        btnOpenInput.setFocusPainted(false);
        btnOpenInput.setBorderPainted(false);
        btnOpenInput.setOpaque(true);
        btnOpenInput.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnOpenInput.addActionListener(e -> controller.openInputDialog(this));

        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelButton.setOpaque(false);
        panelButton.add(btnOpenInput);

        root.add(lblTitle, BorderLayout.NORTH);
        root.add(card, BorderLayout.CENTER);
        root.add(panelButton, BorderLayout.SOUTH);
    }

    @Override
    public void onModelChanged() {
        double input = model.getInputValue();
        double result = model.getResultValue();

        lblInput.setText(String.format(
                "Введено: %s %s  →  %s",
                NumberFormatUtil.format(input),
                model.getFromUnit().forQuantity(input),
                model.getToUnit().getDisplayName()
        ));
        lblResult.setText(String.format(
                "Результат: %s %s",
                NumberFormatUtil.format(result),
                model.getToUnit().forQuantity(result)
        ));
    }
}
