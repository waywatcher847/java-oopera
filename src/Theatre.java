import java.util.*;

public class Theatre {
    public static void main(String[] args) {

        // Создаём 3 актёра и 2 режиссёра
        Actor actor1 = new Actor("Алена", "Тестова", Gender.FEMALE, 168);
        Actor actor2 = new Actor("Алексей", "Тестин", Gender.MALE, 182);
        Actor actor3 = new Actor("Андрей", "Тестко", Gender.MALE, 175);
        Actor actor4 = new Actor("Андрей", "Тестко", Gender.MALE, 175);

        Director dir1 = new Director("Дарья", "Тестицзе", Gender.FEMALE, 15);
        Director dir2 = new Director("Дмитрий", "Тестик", Gender.MALE, 9);

        String musicAuthor = "Автор Музиков";
        String choreographer = "Граф Хоров";

        // Создаём три спектакля
        Show drama = new Show("На дне", 120, dir1);
        Opera opera = new Opera("Евгений Онегин", 160, dir2, musicAuthor,
                "Сад в усадьбе Лариных. Юные голоса дочерей, Татьяны и Ольги...", 40);
        Ballet ballet = new Ballet("Лебединое озеро", 145, dir1, musicAuthor,
                "Озеро в лесной чаще. Лебеди, выходя на берег, превращаются в девушек,...", choreographer);

        // Распределяем актёров по спектаклям
        System.out.println("->Расспределение актеров");
        addActor(drama, actor1);
        addActor(drama, actor2);

        addActor(opera, actor2);
        addActor(opera, actor3);

        addActor(ballet, actor1);
        addActor(ballet, actor3);
        addActor(ballet, actor4);

        // драма
        System.out.println( );
        System.out.println("->Директор драмы '" + drama.getTitle() + "'");
        printDirector(drama);
        System.out.println("->Актеры '" + drama.getTitle() + "':") ;
        printActors(drama);

        // опера
        System.out.println( );
        System.out.println("->либретто оперы:") ;
        System.out.println(opera.getLibrettoText());
        System.out.println("->Директор оперы '" + opera.getTitle() + "'");
        printDirector(opera);
        System.out.println("->Актеры '" + opera.getTitle() + "':") ;
        printActors(opera);

        // балет
        System.out.println( );
        System.out.println("->либретто балета:" );
        System.out.println(ballet.getLibrettoText());
        System.out.println("->Директор балета '" + ballet.getTitle() + "'");
        printDirector(ballet);
        System.out.println("->Актеры '" + ballet.getTitle() + "':") ;
        printActors(ballet);

        // Заменяем актёра в одном из спектаклей
        System.out.println( );
        System.out.println("->заменить актёра в опере: Тестин на Тестова");
        replaceActor( opera, "Тестин", actor1 );
        printActors(opera);

        // Попытка заменить несуществующего актёра
        System.out.println( );
        System.out.println("->заменить несуществующего актёра в драме: 'Сидоров' на Тестко");
        replaceActor( drama, "Сидоров" , actor3 );


    }

    private static void printActors(Show show) {
        List<Actor> actors = show.getListOfActors( );
        if (actors.isEmpty()) {
            System.out.println("нет актёров");
        } else {
            for (int i = 0; i < actors.size(); i++) {
                System.out.println(actors.get(i));
            }
        }
    }

    private static void replaceActor(Show show, String surname, Actor newActor) {
        if (show.checkExist(newActor)) {
            System.out.println("актёр " + newActor + " уже участвует в спектакле");
            return;
        }

        if (!show.checkUnique(surname)) {
            System.out.println("в спектакле несколько актеров с фамилией '" + surname + "'");
            return;
        }

        if (show.replaceActorBySurname(surname, newActor)) {
            System.out.println("успешно");
        } else {
            System.out.println("в спектакле '" + show.getTitle() + "' нет актёра '" + surname + "'");
        }
    }

    private static void printDirector(Show show) {
        Director director = show.getDirector( );
        System.out.println(director);
    }

    private static void addActor(Show show, Actor actor) {
       if (!show.addActor(actor)){
           System.out.println("в '" + show.getTitle() + "' уже есть '" + actor + "'");
       };
    }
}