package main.java;

import java.io.Serializable;

public class Film implements Serializable {

    private String filmName;
    private String[] actors;

    public Film(String filmName, String[] actors) {
        this.filmName = filmName;
        this.actors = actors;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public void setActor(String[] actors, int id, String editedActor) {
        this.actors[id] = editedActor;
    }

    public int getActorsNumber(String[] actors, String actorToEdit) {
        for (int i = 0; i < actors.length; i++) {
            if (actors[i].equals(actorToEdit)) {
                return i;
            }
        }

        return -1;
    }

    public String getActorName(String actorToGet) {
        int id = getActorsNumber(actors,actorToGet);
        return actors[id];
    }
    public String getFilmName() {
        return filmName;
    }

    public String[] getActors() {
        return actors;
    }

}