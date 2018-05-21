import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    //Main Methode


    public static void main(String[] args) {

        //außen sichtbares Array
        PlacesArray p1 = new PlacesArray(new Places[1]);

        //neues 2dGrid
        TwoDGrid td = new TwoDGrid(350,350);



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



            double minX = 0;
            double maxX = 0;
            double minY = 0;
            double maxY = 0;
            for (int j = 0; j<p.length;j++) {
                if (p[j].getX()<minX) {
                    minX = p[j].getX();
                }
                if (p[j].getX()>maxX) {
                    maxX = p[j].getX();
                }
                if (p[j].getY()<minY) {
                    minY = p[j].getY();
                }
                if (p[j].getY()>maxY) {
                    maxY = p[j].getY();
                }
            }
            System.out.println(minX+ " "+ maxX + " "+minY+" "+maxY);
            //minX -20023.8
            //maxX 20032.05
            //minY -14666.8
            //maxY 12330.2

            p1.setpArray(p); //innen erzeugtes Array wird an äußeres übergeben
            s.close();


        } catch (FileNotFoundException e) {
            System.exit(1);
        }

        //befüllen des 2DGrid mit vorhandenem Array

        // X koordinate: (x + 20024)/40057*350 Y-Koordinate: (y + 14667)/26998*350

        for (int i = 0; i<p1.getpArray().length;i++) {
            td.getGrid()[(int)((p1.getpArray()[i].getX()+20024)/40057*350)][(int)((p1.getpArray()[i].getY()+14667)/26998*350)].add(p1.getpArray()[i]);
        }




        //Testfälle aus Angabe
        System.out.println(p1.numOfPlaces(0, 0, 575.0));
        System.out.println(p1.numOfPlaces(1818.54657, 5813.29982, 100));
        System.out.println(td.numOfPlaces(0,0,575));
        System.out.println(td.numOfPlaces(1818.54657,5813.29982,100));


        //System.out.println(p1.AWithNT(1, 5));
        //System.out.println(p1.AWithNT(15, 20));
        System.out.println(td.AWithNT(1,5));
        System.out.println(td.AWithNT(15,20));



    }


}
