package game;

import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame {

    public MainFrame(){
        super.setTitle("15 Piece Sliding Puzzle Game");
        super.setMinimumSize(new Dimension(350,350));
        super.setAlwaysOnTop(true);
        super.setLocation(100,100);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(new GridLayout(4,4));
        super.setVisible(true);
    }
}
