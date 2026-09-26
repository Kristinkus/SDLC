package lab_lcdsw.high_length;

import lab_lcdsw.high_length.controller.LengthController;
import lab_lcdsw.high_length.model.LengthModel;
import lab_lcdsw.high_length.view.MainView;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }

            LengthModel model = new LengthModel();
            LengthController controller = new LengthController(model);
            MainView view = new MainView(controller, model);
            view.setVisible(true);
        });
    }
}
