package com.esh1n;

public class ZigzagConversionSimple {
    public static void main(String[] args) {
        String test0 = convert("AB", 3);
        String test1 = convert("paypalishiring", 3);
        String test2 = convert("londonisthecapitalofthegreat", 4);
        String test4 = convert("A", 3);
        int i = 0;
    }

    public static String convert(String s, int numRows) {
        if (s.isEmpty()) {
            return "";
        } else if (numRows == 1) {
            return s;
        } else {
            int finalRowsCount = Math.min(s.length(), numRows);
            StringBuilder[] txtRows = new StringBuilder[finalRowsCount];
            for (int i = 0; i < finalRowsCount; i++) {
                txtRows[i] = new StringBuilder();
            }
            int rowIndex = 0;
            boolean isDown = true;
            int destination = finalRowsCount - 1;
            for (int index = 0; index < s.length(); index++) {
                txtRows[rowIndex].append(s.charAt(index));
                boolean changeDirection = rowIndex == destination;
                if (changeDirection) {
                    isDown = !isDown;
                    destination = isDown ? finalRowsCount - 1 : 0;
                }
                rowIndex += isDown ? 1 : -1;


            }
            return sumRows(txtRows);
        }
    }

    public static String sumRows(StringBuilder[] txtRows) {
        if (txtRows.length == 1) {
            return txtRows[0].toString();
        }
        StringBuilder finalRow = new StringBuilder();
        for (StringBuilder txtRow : txtRows) {
            finalRow.append(txtRow.toString());
        }
        return finalRow.toString();
    }
}
