package com.esh1n.problems;

public class ZigzafConversion {
    public static void main(String[] args) {
        String test0 = convert("A", 3);
        String test1 = convert("paypalishiring", 3);
        String test2 = convert("londonisthecapitalofthegreat", 4);
        int i = 0;
    }

    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        } else {
            int offsetBetweenColumns = numRows - 2;
            int offset = offsetBetweenColumns + 1;
            double divideResult = (double) s.length() / (numRows + offsetBetweenColumns);
            int repeat = (int) Math.ceil(divideResult);
            int columns = (offset + 1) * repeat;
            Character[][] zigzagRepetition = new Character[numRows][columns];
            int indexInStr = 0;
            for (int clmIdx = 0; clmIdx < columns && indexInStr < s.length(); clmIdx++) {
                if (clmIdx == 0 || (clmIdx % offset == 0)) {
                    for (int idx = 0; idx < numRows && indexInStr < s.length(); idx++) {
                        zigzagRepetition[idx][clmIdx] = s.charAt(indexInStr++);
                    }
                } else {
                    int rowIdx = (offset - (clmIdx % offset));
                    zigzagRepetition[rowIdx][clmIdx] = s.charAt(indexInStr++);
                }
            }
            indexInStr = 0;
            StringBuilder newStr = new StringBuilder();
            for (int i = 0; i < numRows && indexInStr < s.length(); i++) {
                for (int j = 0; j < columns && indexInStr < s.length(); j++) {
                    Character elem = zigzagRepetition[i][j];
                    if (elem != null) {
                        newStr.append(elem);
                        indexInStr++;
                    }
                }
            }
            return newStr.toString();

        }
    }


}
