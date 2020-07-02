import engine.Engine;
import engine.MyPuzzel;
import gui.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        Engine engine = new Engine(frame);
    }
}
