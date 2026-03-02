package org.example.interview;



public class StringCount {
    static void main() {
        String inputString = "adasasfsfdsgdgdhgdhd";
        String outputstring = "";
        Integer maxlength = 0;
        for(String s : inputString.split("")) {
            if(!outputstring.isEmpty() && outputstring.contains(s)) {
                outputstring =  outputstring.substring( outputstring.lastIndexOf(s)+1);
            }
            outputstring +=s;
            if(outputstring.length()>maxlength){
                maxlength = outputstring.length();
            }

        }
        System.out.println(maxlength);
    }
}
