package weishi;

import java.util.Objects;

public class Nuctech implements Comparable<Nuctech>{
    private String name;
    private String x;
    private String y;
    private String d;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return   name+","+x+","+y+","+d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nuctech)) return false;
        Nuctech nuctech = (Nuctech) o;
        return Objects.equals (getName (), nuctech.getName ()) &&
                Objects.equals (getX (), nuctech.getX ()) &&
                Objects.equals (getY (), nuctech.getY ()) &&
                Objects.equals (getD (), nuctech.getD ());
    }

    @Override
    public int hashCode() {
        return Objects.hash (getName (), getX (), getY (), getD ());
    }

    @Override
    public int compareTo(Nuctech o) {
        String s1=this.name;
        String s2=o.getName ();
        return s1.compareTo (s2);
    }
}
