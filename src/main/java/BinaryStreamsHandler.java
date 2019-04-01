package main.java;

import java.io.*;
import java.util.regex.*;

public class BinaryStreamsHandler {

    private String nameOfInputFile;
    private String nameOfOutputFile;

    public BinaryStreamsHandler(String nameOfInputFile, String nameOfOutputFile) {
        this.nameOfInputFile = nameOfInputFile;
        this.nameOfOutputFile = nameOfOutputFile;
    }

    public void keywordWriter() {
        try {
            BufferedInputStream inFile = new BufferedInputStream(new FileInputStream(nameOfInputFile));
            BufferedOutputStream outFile = new BufferedOutputStream(new FileOutputStream(nameOfOutputFile));
            int size = inFile.available();
            byte[] buffer = new byte[size];
            inFile.read(buffer);
            String stringFromInput = new String(buffer);
            inFile.close();

            Matcher match = keywordPattern().matcher(stringFromInput);
            int count = 0;
            String stringFromOutput = "";

            while (match.find()) {
                count++;
                stringFromOutput = stringFromInput.substring(match.start(), match.end());
                outFile.write(String.format("%d: %s\n", count, stringFromOutput).getBytes());
                //outFile.write(System.getProperty("line.separator").getBytes());

            }
            stringFromOutput = "Количество ключевых слов: " + count;
            outFile.write(stringFromOutput.getBytes());

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