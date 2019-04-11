package main.java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class BinaryStreamsHandler {


    public static String dataReader(String nameOfInputFile) {
        String stringFromInput = "";
        try (BufferedInputStream inFile = new BufferedInputStream(new FileInputStream(nameOfInputFile))) {
            int size = inFile.available();
            byte[] buffer = new byte[size];
            inFile.read(buffer);
            stringFromInput = new String(buffer);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringFromInput;
    }


    public static List<String> dataAnalizer(String stringFromInput) {
        List<String> outputData = new ArrayList<>();
        Matcher match = keywordPattern().matcher(stringFromInput);
        int i = 0;
        while (match.find()) {
            outputData.add(i, stringFromInput.substring(match.start(), match.end()));
            i++;
        }
        return outputData;
    }

    public static void dataWriter(String nameOfOutputFile, List<String> analizedData) {
        try (BufferedOutputStream outFile = new BufferedOutputStream(new FileOutputStream(nameOfOutputFile))) {
            for (int i = 0; i < analizedData.size(); i++) {
                outFile.write(String.format("%d: %s\n", i, analizedData.get(i)).getBytes());
            }
            String stringFromOutput = "Количество ключевых слов: " + analizedData.size();
            outFile.write(stringFromOutput.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public static void keywordWriter (String nameOfInputFile, String nameOfOutputFile){
                dataWriter(nameOfOutputFile,dataAnalizer(dataReader(nameOfInputFile)));
        }

    private static Pattern keywordPattern() {
        return Pattern.compile("abstract|continue|for|new|switch|" +
                "assert|default|goto|package|synchronized|" +
                "boolean|do|if|private|this|" +
                "break|double|implements|protected|throw|" +
                "byte|else|import|public|throws|" +
                "case|enum|instanceof|return|transient|" +
                "catch|extends|int|short|try|" +
                "char|final|interface|static|void|" +
                "class|finally|long|strictfp|volatile|" +
                "const|float|native|super|while");
    }
}