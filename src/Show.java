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

    public boolean addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            return false;
        }
        listOfActors.add(actor);
        return true;
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
        //println списка актеров в методе printActors класса Theatre
        return new ArrayList<>(listOfActors);
    }

    public String getTitle() {
        return title;
    }

    public Director getDirector() {
        //println режисера в методе printDirector класса Theatre
        return this.director;
    }

    public boolean checkExist( Actor newActor ) {
        List<Actor> actors = getListOfActors( );
        for (Actor actor : actors) {
            if (actor.getSurname().equals(newActor.surname)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUnique( String surname ) {
        int count = 0;
        for (Actor actor : listOfActors) {
            if (surname.equals(actor.getSurname())) {
                count++;
            }
        }
        return (count == 1 || count == 0);
    }
}
