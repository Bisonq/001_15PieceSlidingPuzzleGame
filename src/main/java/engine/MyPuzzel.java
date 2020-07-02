package engine;

import javax.swing.*;
import java.awt.*;

public class MyPuzzel extends JButton {

    private int puzzelId;
    private static int id = 1;

    private MyPuzzel up;
    private MyPuzzel down;
    private MyPuzzel left;
    private MyPuzzel right;

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

    public MyPuzzel getUp() {
        return up;
    }

    public MyPuzzel getDown() {
        return down;
    }

    public MyPuzzel getLeft() {
        return left;
    }

    public MyPuzzel getRight() {
        return right;
    }

    public void setUp(MyPuzzel up) {
        this.up = up;
    }

    public void setDown(MyPuzzel down) {
        this.down = down;
    }

    public void setLeft(MyPuzzel left) {
        this.left = left;
    }

    public void setRight(MyPuzzel right) {
        this.right = right;
    }
}