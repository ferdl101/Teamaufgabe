public class ATCount {

    //Klasse für Rückgabe aus Methode numOfPlaces

    private int airports;
    private int trainstations;

    public ATCount() {
        this.airports = 0;
        this.trainstations = 0;
    }

    public void incA() {
        this.airports++;
    }

    public void incT() {
        this.trainstations++;
    }

    public int getAirports() {
        return airports;
    }

    public int getTrainstations() {
        return trainstations;
    }

    @Override
    public String toString() {
        return "ATCount{" +
                "airports=" + airports +
                ", trainstations=" + trainstations +
                '}';
    }
}
