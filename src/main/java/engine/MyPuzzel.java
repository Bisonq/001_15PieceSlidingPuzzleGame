package engine;

import javax.swing.*;
import java.awt.*;

public class MyPuzzel extends JButton {

    private int puzzelId;
    private static int id = 1;

    public MyPuzzel() {
        super();
        setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        setPreferredSize(new Dimension(90, 90));
        setBackground(new Color(141, 67, 153));
        setBorder(BorderFactory.createBevelBorder(1, new Color(139, 59, 90), new Color(139, 59, 90)));
        setFocusPainted(false);
        this.puzzelId = id++;
        setText(puzzelId + "");
    }

    public int getPuzzelId() {
        return puzzelId;
    }
}