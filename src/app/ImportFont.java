package app;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImportFont {
    public static void loadAndRegisterAllFontWeights() {
        String[] fontWeights = {"Black", "Bold", "ExtraBold", "ExtraLight", "Light", "Medium", "Regular", "SemiBold", "Thin"};
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        for (String fontWeight : fontWeights) {
            try {
                Font font = Font.createFont(Font.TRUETYPE_FONT, new File("src/app/FontInter/Inter-" + fontWeight + ".ttf")).deriveFont(12f);
                ge.registerFont(font);
            } catch (FontFormatException | IOException e) {
                System.out.println("Error importing font: " + e.getMessage());
            }
        }
    }

    // Utility method to get a font with the specific weight and size.
    public static Font getFont(String weight, float size) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for (Font font : ge.getAllFonts()) {
            if (font.getName().contains("Inter") && font.getName().contains(weight)) {
                return font.deriveFont(size);
            }
        }
        return null;
    }
}
