package main.java;

import java.util.ArrayList;
import java.io.*;

public class Serialization {

    public static ArrayList<Film> readFile(String fileName) {

        ArrayList<Film> filmCollection = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            filmCollection = (ArrayList<Film>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return filmCollection;
    }

    public static void writeFilmInFile(ArrayList<Film> films, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(films);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editFilmName(ArrayList<Film> films, String filmToEdit, String editedFilm) {
        for (Film film : films) {
            if (film.getFilmName().equals(filmToEdit)) {
                film.setFilmName(editedFilm);
            }
        }
    }

    public static void editActorName(ArrayList<Film> films, String filmToEdit, String actorToEdit, String editedActor) {
        int filmId;
        for (Film film : films) {
            if (film.getFilmName().equals(filmToEdit)) {
                filmId = film.getActorsNumber(film.getActors(), actorToEdit);
                if (filmId == -1) {
                    System.out.println("Нет такого актера!");
                } else {
                    film.setActor(film.getActors(), filmId, editedActor);
                }
                break;
            }
        }
    }

}
