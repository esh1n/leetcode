package com.esh1n.problems;

import java.io.*;

public class MaxSublistInBunaryArray {
    public static void main(String[] args) throws Exception {
        int result = 0;
        int max = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = parseToInt(reader.readLine(),0);
        while (count >0) {

            String value = reader.readLine();
            if(value.equals("1")){
                result+=1;
            }else{
                if(result>max){
                    max = result;
                }
                result = 0;
            }
            count--;
        }
        reader.close();
        int finalResult = Math.max(result, max);
        System.out.println(finalResult);
    }
    public static int parseToInt(String stringToParse, int defaultValue) {
        try {
            return Integer.parseInt(stringToParse);
        } catch(NumberFormatException ex) {
            return defaultValue; //Use default value if parsing failed
        }
    }
}
