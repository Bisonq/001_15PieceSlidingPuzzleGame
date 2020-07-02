package game;

import javax.swing.*;
import java.awt.*;

class MyPuzzel extends JButton {

    private int puzzelId;
    private static int id = 1;

    private String up;
    private String down;
    private String left;
    private String right;

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

    public void setPuzzelId(int puzzelId) {
        this.puzzelId = puzzelId;
    }

    public String getUp() {
        return up;
    }

    public String getDown() {
        return down;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public void setRight(String right) {
        this.right = right;
    }
}