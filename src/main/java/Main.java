package main.java;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BinaryStreamsHandler bHandler = new BinaryStreamsHandler("input.txt", "correct_output.txt");
        bHandler.keywordWriter();
        TextStreamHandler tHandler = new TextStreamHandler("input.txt", "output2.txt");
        tHandler.keywordWriter();

        /*ArrayList<Film> films = new ArrayList<>();
        Serialization ser = new Serialization();
        String[] actors = {"Viggo Mortensen", "Mahershala Ali"};
        String[] actors1 = {"Penelope Cruz", "Javier Bardem"};
        Film film = new Film("Green Book", actors);
        Film film1 = new Film("Everybody Knows", actors1);
        films.add(film);
        films.add(film1);
        ser.writeFilmInFile(films, "serialization.txt");
        ser.readFile("serialization.txt");
        ser.editActorName(films, "Green Book", "Viggo Mortensen", "Linda Cardellini");
        ser.writeFilmInFile(films, "serialization.txt");
        ser.readFile("serialization.txt");*/
    }

}