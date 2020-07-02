package engine;

import gui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Engine implements ActionListener {
    private MainFrame frame;
    private MyPuzzel[] puzzleTab;
    private MyPuzzel[][] puzzleTab2D;

    public Engine(MainFrame frame){
        this.frame = frame;
        this.puzzleTab = createTableOfPuzzle();
        shufflePuzzle(this.puzzleTab);
        addPuzzleIntoFrame(this.frame, this.puzzleTab);
        addActionsInPuzzle(this.puzzleTab);
        this.puzzleTab2D = transformSinglePuzzleTabInto2DPuzzleTab(this.puzzleTab);
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

    private void addActionsInPuzzle(MyPuzzel[] tab){
        for(int i = 0 ; i < tab.length ; i++)
            tab[i].addActionListener(this);
    }

    private MyPuzzel[][] transformSinglePuzzleTabInto2DPuzzleTab(MyPuzzel[] tab){
        MyPuzzel [][] pomTab = new MyPuzzel[4][4];
        int var = 0 ;
        for(int i = 0 ; i < 4 ; i ++)
            for(int j = 0 ; j < 4 ; j++)
                pomTab[i][j] = tab[var++];
        return pomTab;
    }

    private Point findPressedIndexPuzzleInTab2D(MyPuzzel[][] tab, MyPuzzel puzzel){
        for(int i = 0 ; i < tab.length ; i ++)
            for(int j = 0 ; j < tab[i].length ; j++)
                if(tab[i][j] == puzzel)
                    return new Point(i,j);
        return null;
    }

    private void setPuzzelNeighborsInTable(MyPuzzel puzzel, int x, int y) {
        if(x + 1 <= this.puzzleTab2D.length-1)
            puzzel.setDown(this.puzzleTab2D[x + 1][y].getText());
        if(x -1 >= 0)
            puzzel.setUp(this.puzzleTab2D[x-1][y].getText());
        if(y + 1 <= this.puzzleTab2D[0].length-1)
            puzzel.setRight(this.puzzleTab2D[x][y+1].getText());
        if(y -1 >= 0)
            puzzel.setLeft(this.puzzleTab2D[x][y-1].getText());
    }

    private void logPuzzelLocationInTable(MyPuzzel puzzel) {
        System.out.println("ID: " + puzzel.getPuzzelId());
        System.out.println("Up: " + puzzel.getUp());
        System.out.println("Down: " + puzzel.getDown());
        System.out.println("Left: " + puzzel.getLeft());
        System.out.println("Right: " + puzzel.getRight());
        System.out.println();
    }

    private MyPuzzel findPuzzelIn2DTabByText(String text, MyPuzzel[][] tab){
        for(int i = 0 ; i < tab.length ; i++)
            for(int j = 0 ; j < tab[i].length ; j++)
                if(tab[i][j].getText().equals(text))
                    return tab[i][j];
        return null;
    }

    private void swapPuzzle(MyPuzzel puzzel, int pomId, String pomText) {
        MyPuzzel downPuzzel = findPuzzelIn2DTabByText("", this.puzzleTab2D);
        puzzel.setText("");
        puzzel.setPuzzelId(downPuzzel.getPuzzelId());
        downPuzzel.setPuzzelId(pomId);
        downPuzzel.setText(pomText);
    }

    private boolean checkTheResult(MyPuzzel[] tab){
        for(int i = 0 ; i < tab.length-1 ; i++)
            if(tab[i].getPuzzelId() > tab[i+1].getPuzzelId())
                return false;
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyPuzzel puzzel = (MyPuzzel) e.getSource();

        Point pom = findPressedIndexPuzzleInTab2D(this.puzzleTab2D, puzzel);
        int x = (int) pom.getX();
        int y = (int) pom .getY();

        setPuzzelNeighborsInTable(puzzel, x, y);

        logPuzzelLocationInTable(puzzel);

        int pomId = puzzel.getPuzzelId();
        String pomText = puzzel.getText();

        if(puzzel.getDown() != null && puzzel.getDown().equals("")){
            swapPuzzle(puzzel, pomId, pomText);
        }else if(puzzel.getUp() != null && puzzel.getUp().equals("")){
            swapPuzzle(puzzel, pomId, pomText);
        }else if(puzzel.getLeft() != null && puzzel.getLeft().equals("")){
            swapPuzzle(puzzel, pomId, pomText);
        }else if(puzzel.getRight() != null && puzzel.getRight().equals("")){
            swapPuzzle(puzzel, pomId, pomText);
        }
        if(checkTheResult(this.puzzleTab)) {
            JOptionPane.showMessageDialog(frame, "Win!\nGood Job :)");
        }
    }
}
