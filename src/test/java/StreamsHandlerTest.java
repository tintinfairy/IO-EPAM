package test.java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import main.java.TextStreamHandler;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import main.java.BinaryStreamsHandler;
import java.io.File;

public class StreamsHandlerTest {

    final String[] RIGHT_KEYWORDS = {"class", "for", "int", "private", "public", "return", "this", "void"};
    final int TOTAL_KEYWORDS_NUM = 38;

    @Before
    public void createTmp() {
        new File("tmp").mkdir();
    }

    @After
    public void removeTmp() throws IOException {
        Files.walk(Paths.get("tmp")).map(Path::toFile).forEach(File::delete);
        Files.delete(Paths.get("tmp"));
    }

    @Test
    public void testingBinaryHandlerAmountOfKeyWords() {
        BinaryStreamsHandler.keywordWriter("input.txt", "tmp/output.txt");
        checkFiles();
    }

    @Test
    public void testingTextHandlerAmountOfKeyWords() {
        TextStreamHandler.keywordWriter("input.txt", "tmp/output.txt");
        checkFiles();
    }

    private void checkFiles() {
        try(BufferedReader output = new BufferedReader(new FileReader("tmp/output.txt"))) {
            boolean[] rightKeywordsMask = new boolean[RIGHT_KEYWORDS.length];
            String line;
            while ((line = output.readLine()) != null) {
                String[] split = line.split(": ");
                if (split[0].equals("Количество ключевых слов")) {
                    if (Integer.parseInt(split[1]) != TOTAL_KEYWORDS_NUM) {
                        Assert.fail("Неверное число ключевых слов");
                    }
                } else {
                    String keyword = split[1];
                    int idx = Arrays.binarySearch(RIGHT_KEYWORDS, keyword);
                    if (idx >= 0) {
                        rightKeywordsMask[idx] = true;
                    } else {
                        Assert.fail("Найдено неверное ключевое слово: " + keyword);
                    }
                }
            }
            boolean allKeywordsExists = true;
            for (int i = 0; i < RIGHT_KEYWORDS.length; i++) {
                allKeywordsExists &= rightKeywordsMask[i];
            }
            Assert.assertTrue("Все ключевые слова должны присуствовать", allKeywordsExists);
        } catch (IOException e) {
            Assert.fail("IOException");
        }
    }
}