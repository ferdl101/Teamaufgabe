public class PlacesArray {

    //Array mit Places Objekten

    private Places[] pArray;

    public PlacesArray() {

    }

    public PlacesArray(Places[] pArray) {
        this.pArray = pArray;
    }

    public Places[] getpArray() {
        return pArray;
    }

    public void setpArray(Places[] pArray) {
        this.pArray = pArray;
    }


    //Methode, die für einen beliebigen Punkt in der euklidischen Ebene und einen Radius
    //die Anzahl der Flughäfen und Bahnhöfe berechnet, die sich innerhalb des Radius befinden.
    //Wenn Wurzel((XArrayeintrag -x)^2 + (YArrayeintrag -y)^2) < Radius, wird entweder der Airport oder
    //Trainstation Counter erhöht.
    //Rückgabe ist ein ATCount Objekt, mit int airports und int trainstations
    //Number Of Places (in Radius r)
    public ATCount numOfPlaces(double x, double y, double radius) {


        ATCount result = new ATCount();
        for (int i = 0; i < this.pArray.length; i++) {
            if (Math.sqrt(Math.pow(this.pArray[i].getX() - x, 2) + Math.pow(this.pArray[i].getY() - y, 2)) < radius) {
                if (this.pArray[i].getType().compareTo("AIRPORT") == 0) {
                    result.incA();
                } else {
                    result.incT();
                }
            }
        }

        return result;
    }


    //Methode, die die Anzahl aller Flughäfen berechnet, in deren Radius r sich mindestens n Bahnhöfe befinden.
    //Wenn ein Punkt des Arrays ein Airport ist, wird die Methode numOfPlaces mit dessen Koordinaten aufgerufen.
    //Wenn die Anzahl der zurückgegebenen Trainstations >n ist, wird der result-counter um 1 erhöht.
    //ACHTUNG: lange Laufzeit aufgrund der Array-Implementierung. (2-3 Minuten? für beide Testfälle)
    //Airports With N Trainstations
    public int AWithNT(double radius, int n) {
        int result = 0;

        for (int i = 0; i < this.pArray.length; i++) {
            if (this.pArray[i].getType().compareTo("AIRPORT") == 0) {
                if (numOfPlaces(this.pArray[i].getX(), this.pArray[i].getY(), radius).getTrainstations() >= n) {
                    result++;
                }
            }
        }


        return result;
    }

}
