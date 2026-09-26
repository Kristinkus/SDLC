package lab_lcdsw.high_length.view;

import java.awt.Color;
import java.awt.Font;

/** Палитра мягкого розового интерфейса. */
public final class UiTheme {

    public static final Color BG = new Color(255, 236, 241);
    public static final Color PANEL = new Color(255, 245, 248);
    public static final Color ACCENT = new Color(196, 112, 140);
    public static final Color ACCENT_DARK = new Color(158, 78, 108);
    public static final Color TEXT = new Color(72, 48, 58);
    public static final Color MUTED = new Color(120, 90, 100);
    public static final Color BUTTON_BG = new Color(232, 150, 175);
    public static final Color BUTTON_FG = new Color(255, 255, 255);

    public static final Font TITLE = new Font("Segoe UI", Font.BOLD, 22);
    public static final Font BODY = new Font("Segoe UI", Font.PLAIN, 15);
    public static final Font RESULT = new Font("Segoe UI", Font.BOLD, 20);
    public static final Font BUTTON = new Font("Segoe UI", Font.BOLD, 14);

    private UiTheme() {
    }
}
