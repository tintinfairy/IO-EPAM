package main.java;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BinaryStreamsHandler.keywordWriter("input.txt", "correct_output.txt");
        TextStreamHandler.keywordWriter("input.txt", "output2.txt");

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