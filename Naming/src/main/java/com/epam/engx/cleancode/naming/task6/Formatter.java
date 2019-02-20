package com.epam.engx.cleancode.naming.task6;

public class Formatter {

    private static final String PLUS = "+";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = "_";

    public static void main(String[] args) {
        System.out.println(outputKeyAndValueInCell("enable", "true"));
        System.out.println(outputKeyAndValueInCell("name", "Bob"));
    }

    private static String outputKeyAndValueInCell(String key, String value) {
        String content = key + UNDERSCORE + value;
        String minuses = buildCellTopAndBottom(content.length());
        return PLUS +  minuses + PLUS + "\n"
                + PIPE + content + PIPE + "\n" +
                PLUS + minuses + PLUS + "\n";
    }

    private static String buildCellTopAndBottom(int times) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++)
            result.append(Formatter.MINUS);
        return result.toString();
    }
}
