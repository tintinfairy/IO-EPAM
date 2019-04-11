package main.java;

import java.io.Serializable;
import java.util.List;

public class Film implements Serializable {

    private String filmName;
    private List<String> actors;


    public Film(String filmName, List<String> actors) {
        this.filmName = filmName;
        this.actors = actors;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public void setActor(List<String> actors, int id, String editedActor) {
        actors.add(id,editedActor);
    }

    public int getActorsNumber(List<String> actors, String actorToEdit) {
        return actors.indexOf(actorToEdit);
    }

    public String getActorName(String actorToGet) {
        int id = getActorsNumber(actors,actorToGet);
        return actors.get(id);
    }
    public String getFilmName() {
        return filmName;
    }

    public List<String> getActors() {
        List<String> copyOfActors = actors;
        return copyOfActors;
    }

}