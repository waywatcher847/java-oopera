import java.util.*;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected List<Actor> listOfActors;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = new ArrayList<>();
    }

    public void addActor(Actor actor) {
        listOfActors.add(actor);
    }

    public boolean replaceActorBySurname(String surname, Actor newActor) {
        for (int i = 0; i < listOfActors.size(); i++) {
            if (listOfActors.get(i).getSurname().equals(surname)) {
                listOfActors.set(i, newActor);
                return true;
            }
        }
        return false;
    }

    public List<Actor> getListOfActors() {
        return new ArrayList<>(listOfActors);
    }

    public String getLibrettoText() {
        return null;
    }

    public String getTitle() {
        return title;
    }

    public boolean hasActor( Actor newActor ) {
        List<Actor> actors = getListOfActors( );
        for (Actor actor : actors) {
            if (actor.getSurname().equals(newActor.surname)) {
                return true;
            }
        }
        return false;
    }
}
