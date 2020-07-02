package engine;

import gui.MainFrame;

import java.util.*;

public class Engine{
    private MainFrame frame;
    private MyPuzzel[] puzzleTab;
    private MyPuzzel blankPuzzel;

    public Engine(MainFrame frame){
        this.frame = frame;
        this.puzzleTab = createTableOfPuzzle();
        shufflePuzzle(this.puzzleTab);
        addPuzzleIntoFrame(this.frame, this.puzzleTab);
        this.blankPuzzel = this.puzzleTab[puzzleTab.length-1];
    }

    private MyPuzzel[] createTableOfPuzzle(){
        MyPuzzel[] myPuzzelsTab = new MyPuzzel[16];
        for(int i = 0 ; i < 16 ; i ++)
            myPuzzelsTab[i] = new MyPuzzel();
        return myPuzzelsTab;
    }

    private void addPuzzleIntoFrame(MainFrame mf, MyPuzzel[] tab){
        for(int i = 0 ; i < tab.length - 1 ; i++)
            mf.add(tab[i]);
        MyPuzzel puzzel = tab[tab.length-1];
        puzzel.setText("");
        mf.add(puzzel);
        mf.pack();
    }

    private void shufflePuzzle(MyPuzzel[] tab){
        Random random = new Random();
        for (int i = 0 ; i < tab.length - 1 ; i ++){
            int pom = random.nextInt(tab.length - 1);
            MyPuzzel var = tab[i];
            tab[i] = tab[pom];
            tab[pom] = var;
        }
    }

}
