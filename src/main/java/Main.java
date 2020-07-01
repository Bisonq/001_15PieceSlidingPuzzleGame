import engine.MyPuzzel;
import gui.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();

        for (int i = 0 ; i < 16 ; i ++)
            frame.getContentPane().add(new MyPuzzel());

        frame.pack();
    }
}
