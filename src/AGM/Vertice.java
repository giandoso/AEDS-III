package AGM;

/**
 *
 * @author 2015.1.08.029
 */
public class Vertice {
    int index;
    double x;
    double y;

    public Vertice(int index, double x, double y) {
        this.index = index;
        this.x = x;
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void see() {
        System.out.println(this.index + "\t\t" + this.x + "\t\t" + this.y);
    }
    
    
}
