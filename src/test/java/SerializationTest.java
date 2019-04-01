package test.java;

import java.util.ArrayList;

import main.java.Film;
import org.junit.Before;
import org.junit.Test;
import main.java.Serialization;

import static org.junit.Assert.*;

public class SerializationTest {
    private ArrayList<Film> films = new ArrayList<>();
    Serialization ser = new Serialization();

    @Before
    public void makeArrayList() {
        String[] actors = {"Viggo Mortensen", "Mahershala Ali"};
        String[] actors1 = {"Penelope Cruz", "Javier Bardem"};
        Film film = new Film("Green Book", actors);
        Film film1 = new Film("Everybody Knows", actors1);
        films.add(film);
        films.add(film1);
    }


    @Test
    public void filmsAmountChecker() {
        ArrayList<Film> list = ser.readFile("serialization.txt");
        assertEquals(2, list.size());
    }

    @Test
    public void editActor() {
        ArrayList<Film> list = ser.readFile("serialization.txt");
        ser.editActorName(films,"Green Book", "Viggo Mortensen", "Linda Cardellini");
        ser.writeFilmInFile(list, "serialization.txt");
        assertEquals("Linda Cardellini", ser.readFile("serialization.txt").get(0).getActorName("Linda Cardellini"));
    }
    @Test
    public void editFilm() {
        ArrayList<Film> list = ser.readFile("serialization.txt");
        ser.editFilmName(list, "Everybody Knows", "Nobody knows");
        ser.writeFilmInFile(list, "serialization.txt");
        assertEquals("Nobody knows", ser.readFile("serialization.txt").get(1).getFilmName());
    }
}