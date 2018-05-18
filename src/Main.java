import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    //Main Methode


    public static void main(String[] args) {

        //außen sichtbares Array
        PlacesArray p1 = new PlacesArray(new Places[1]);


        try (Scanner s = new Scanner(new File(System.getProperty("user.dir") + "/data/junctions.csv"), "UTF-8")) {

            s.useDelimiter(";|\n");
            //angeblich wäre es besser, wenn wir jede Zeile einzeln einlesen, und nur ";" verwenden

            Places[] p = new Places[94068];
            int i = 0;

            while (s.hasNext()) {
                p[i] = new Places();
                p[i].setName(s.next());
                p[i].setX(Double.parseDouble(s.next()));
                p[i].setY(Double.parseDouble(s.next()));
                p[i].setType(s.next());
                i++;

            }

            p1.setpArray(p); //innen erzeugtes Array wird an äußeres übergeben
            s.close();


        } catch (FileNotFoundException e) {
            System.exit(1);
        }


        //Testfälle aus Angabe
        System.out.println(p1.numOfPlaces(0, 0, 575.0));
        System.out.println(p1.numOfPlaces(1818.54657, 5813.29982, 100));

        System.out.println(p1.AWithNT(1, 5));
        System.out.println(p1.AWithNT(15, 20));


    }


}
