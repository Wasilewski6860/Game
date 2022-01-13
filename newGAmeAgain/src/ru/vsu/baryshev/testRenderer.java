package ru.vsu.baryshev;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

class Renderer extends DefaultTableCellRenderer {
//    public Component getTableCellRendererComponent(JTable table,
//                                                   Object value,
//                                                   boolean isSelected,
//                                                   boolean hasFocus,
//                                                   int row,
//                                                   int column) {
//        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//        Cell c1 = (Cell) value;
//
//        cell.setBackground(Color.RED);
//        return cell;
//    }
static class MyTableCellRenderer extends JLabel implements TableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int rowIndex, int vColIndex) {
        Cell cell = (Cell) value;
        switch (cell.toState()) {
            case WALL: setBackground(Color.RED);

        }

        return this;
    }
}
}
