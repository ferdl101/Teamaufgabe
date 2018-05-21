public class TwoDGrid {


    private TwoDNodes[][] p2D;

    public TwoDGrid(int x, int y) {
        this.p2D = new TwoDNodes[x][y];
        for (int i = 0;i<350;i++) {
            for (int j = 0;j<350;j++) {
                p2D[i][j] = new TwoDNodes();
            }
        }
    }

    public TwoDNodes[][] getGrid() {
        return p2D;
    }

    public void setP2D(TwoDNodes[][] p2D) {
        this.p2D = p2D;
    }

    public ATCount numOfPlaces(double x, double y, double radius) {


        ATCount result = new ATCount();
        ATCount result1 = new ATCount();
        /*for (int i = 0; i < this.pArray.length; i++) {
            if (Math.sqrt(Math.pow(this.pArray[i].getX() - x, 2) + Math.pow(this.pArray[i].getY() - y, 2)) < radius) {
                if (this.pArray[i].getType().compareTo("AIRPORT") == 0) {
                    result.incA();
                } else {
                    result.incT();
                }
            }
        }*/

        // X koordinate: (x + 20024)/40057*350 Y-Koordinate: (y + 14667)/26998*350
        for (int xz = (int)((x+20024-radius)/40057*350)-1;xz < (int)((x+20024+radius)/40057*350)+1;xz++) {
            if (xz <0 || xz >349) {
                continue;
            }
            for (int yz = ((int)(y + 14667-radius)/26998*350)-1;yz < (int)((y + 14667+radius)/26998*350)+1;yz++) {
                if (yz<0 || yz > 349) {
                    continue;
                }
                result = numOfPlacesRec(this.p2D[xz][yz],x,y,radius);
                result1.setAirports(result1.getAirports()+result.getAirports());
                result1.setTrainstations(result1.getTrainstations()+result.getTrainstations());

            }
        }



        return result1;
    }
    private ATCount numOfPlacesRec(TwoDNodes n,double x, double y, double radius) {
        ATCount result = new ATCount();
        if (n.getNext() != null) {
            result = numOfPlacesRec(n.getNext(),x,y,radius);
        }
        if (n.getP() != null) {
            if (Math.sqrt(Math.pow(n.getP().getX() - x, 2) + Math.pow(n.getP().getY() - y, 2)) < radius) {
                if (n.getP().getType().compareTo("AIRPORT") == 0) {
                    result.incA();
                } else {
                    result.incT();
                }
            }

        }
        return result;
    }

    public int AWithNT(double radius, int n) {
        int result = 0;

        /*for (int i = 0; i < this.pArray.length; i++) {
            if (this.pArray[i].getType().compareTo("AIRPORT") == 0) {
                if (numOfPlaces(this.pArray[i].getX(), this.pArray[i].getY(), radius).getTrainstations() >= n) {
                    result++;
                }
            }
        }*/

        for (int i = 0; i<350;i++) {
            for (int j = 0; j<350;j++) {
                if (this.getGrid()[i][j].getP() != null) {
                    result += AWithNTRec(this.getGrid()[i][j], radius, n);
                }
            }
        }


        return result;
    }

    private int AWithNTRec(TwoDNodes node, double radius, int n) {
        int result = 0;
        if (node.getNext() != null) {
            result = AWithNTRec(node.getNext(),radius,n);
        }
        if (node.getP() != null) {
            if (node.getP().getType().compareTo("AIRPORT") == 0) {
                if (numOfPlaces(node.getP().getX(),node.getP().getY(),radius).getTrainstations() >= n) {
                    result++;
                }
            }
        }
        return result;
    }


}
