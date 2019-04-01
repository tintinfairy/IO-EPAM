package main.java;

import java.io.*;
import java.util.regex.*;

public class TextStreamHandler {

    private String nameOfInputFile;
    private String nameOfOutputFile;

    public TextStreamHandler(String nameOfInputFile, String nameOfOutputFile) {
        this.nameOfInputFile = nameOfInputFile;
        this.nameOfOutputFile = nameOfOutputFile;
    }

    public void keywordWriter() {
        try {
            BufferedReader inFile = new BufferedReader(new FileReader(nameOfInputFile));
            BufferedWriter outFile = new BufferedWriter(new FileWriter(nameOfOutputFile));
            StringBuffer stringFromInput = new StringBuffer();
            String reader;
            while ((reader = inFile.readLine()) != null) {
                stringFromInput.append(reader);
            }
            inFile.close();

            Matcher match = keywordPattern().matcher(stringFromInput);
            int count = 0;
            String stringFromOutput = "";

            while (match.find()) {
                count++;
                stringFromOutput = stringFromInput.substring(match.start(), match.end());
                outFile.write(String.format("%d: %s\n", count, stringFromOutput));
                //outFile.write(System.getProperty("line.separator"));

            }
            stringFromOutput = "Количество ключевых слов: " + count;
            outFile.write(stringFromOutput);


            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Pattern keywordPattern() {
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