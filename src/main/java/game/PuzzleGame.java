package game;

public class PuzzleGame {

    private static int count = 0;

    public static void startGame(boolean logMoves){
        if(count == 0){
            MainFrame frame = new MainFrame();
            Engine engine = new Engine(frame);
            engine.setLogGameMove(logMoves);
            count++;
        }else {
            System.out.println("The game is working!");
        }
    }
}
