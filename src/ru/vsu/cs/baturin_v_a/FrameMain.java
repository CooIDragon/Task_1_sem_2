package ru.vsu.cs.baturin_v_a;

import ru.vsu.cs.baturin_v_a.util.JTableUtils;
import ru.vsu.cs.baturin_v_a.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FrameMain extends JFrame {
    private JTable maze;
    private JPanel panelMain;
    private JButton buttonRun;
    private JTextField TextField;
    private JButton buttonLayout;

    private JFileChooser fileChooserOpen;

    public FrameMain() {
        this.setTitle("Task_1");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(700, 100, 300, 300);
        this.setResizable(true);
        this.pack();

        JTableUtils.initJTableForArray(maze, 30, true, true, true, true);

        maze.setRowHeight(30);

        fileChooserOpen = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);

        buttonRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    FindingWayInMaze findingWayInMaze = new FindingWayInMaze();
                    String[][] matrix = JTableUtils.readStringMatrixFromJTable(maze);

                    int[][] arr0 = findingWayInMaze.createEmptyIntArr(matrix);

                    int final1 = findingWayInMaze.findCoordinates(matrix, 0, "М");
                    int final2 = findingWayInMaze.findCoordinates(matrix, 1, "М");

                    int start1 = findingWayInMaze.findCoordinates(matrix, 0, "Т");
                    int start2 = findingWayInMaze.findCoordinates(matrix, 1, "Т");

                    arr0[start1][start2] = 1;

                    int k = 0;

                    while ((arr0[final1][final2] == 0) && (k < 100)) {
                        k++;
                        findingWayInMaze.makeStep(matrix, arr0, k);
                    }

                    findingWayInMaze.paintTheWay(final1, final2, arr0, matrix);

                    matrix[start1][start2] = "Т";

                    JTableUtils.writeArrayToJTable(maze, matrix);

                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonLayout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    FindingWayInMaze findingWayInMaze = new FindingWayInMaze();
                    String[][] matrix = JTableUtils.readStringMatrixFromJTable(maze);

                    findingWayInMaze.layout(matrix);
                    JTableUtils.writeArrayToJTable(maze, matrix);

                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }

}
