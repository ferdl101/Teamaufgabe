public class TwoDNodes {

    private Places p;
    private TwoDNodes next;

    public TwoDNodes(){
        this.p = null;
        this.next = null;
    }

    public TwoDNodes(Places p, TwoDNodes n) {
        this.p=p;
        this.next=n;
    }
    public TwoDNodes(Places p){
        this.p = p;
        this.next=null;
    }

    public Places getP() {
        return p;
    }

    public void setP(Places p) {
        this.p = p;
    }

    public TwoDNodes getNext() {
        return next;
    }

    public void setNext(TwoDNodes n) {
        this.next = n;
    }

    public void add(Places p) {
        if (this.p==null) {
            this.p=p;
        } else if (this.next== null) {
            next = new TwoDNodes(p);
        } else {
            next.add(p);
        }

    }


}
