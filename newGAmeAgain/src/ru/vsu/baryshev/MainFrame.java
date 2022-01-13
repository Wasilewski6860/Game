package ru.vsu.baryshev;

import ru.vsu.baryshev.util.JTableUtils;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    private JPanel panelMain;
    private JTable table1;
    private JButton a1Button;
    private JButton a5Button;
    private JButton a3Button;
    private JButton a2Button;
    private JButton a4Button;
    private JButton UPButton;
    private JButton LEFTButton;
    private JButton RIGHTButton;
    private JButton DOWNButton;
    public int selRow=0;
    public int selCol=0;
    Cell[][] array = new Cell[1][1];

    public MainFrame(){
        this.setTitle("Table");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Рабочий массив
                    array = InputArgs.StringArrayToCellArray(InputArgs.fileToStringArray("levels/level01.txt"));
                    BoardTableModel model = new BoardTableModel(array);
                    table1 = new JTable(model);
                    table1.setFocusable(false);
                    table1.setRowSelectionAllowed(false);
                    // show grid
                    table1.setShowGrid(true);
                    table1.setGridColor(Color.BLACK);
                    table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    for (int i = 0; i < table1.getColumnCount(); i++) {
                        table1.setDefaultRenderer(table1.getColumnClass(0),new Renderer.MyTableCellRenderer());
                        table1.getColumnModel().getColumn(i).setResizable(false);
                    }
                    table1.repaint();


                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        UPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selRow = table1.rowAtPoint(e.getPoint());
                selCol = table1.columnAtPoint(e.getPoint());

            }
        });

    }
    private static class BoardTableModel extends AbstractTableModel {
        Object[][] dataEntries;

        public BoardTableModel(Object[][] dataEntries) {
            this.dataEntries = dataEntries;
        }

        public int getRowCount() {
            return dataEntries.length;
        }

        public int getColumnCount() {
            return dataEntries[0].length;
        }

        public Object getValueAt(int row, int column) {
            return dataEntries[row][column];
        }

        public String getColumnName(int column) {
            return null;
        }

        public boolean isCellEditable(int row, int column) {
            return false;
        }

    }

}
