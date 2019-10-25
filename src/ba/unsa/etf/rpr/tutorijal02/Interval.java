package ba.unsa.etf.rpr.tutorijal02;

import java.util.Objects;

public class Interval {
    private double poc_tacka;
    private double krajnja_tacka;
    private boolean da_li_pripada_poc;
    private boolean da_li_pripada_krajnja;


    public Interval(double v, double v1, boolean b, boolean b1) {
        if(v>v1)
            throw new IllegalCallerException("Oprez, pocetna tacka veca od krajnje tacke");
        poc_tacka=v;
        krajnja_tacka=v1;
        da_li_pripada_poc=b;
        da_li_pripada_krajnja=b1;
    }

    public Interval() {
        poc_tacka=0;
        krajnja_tacka=0;
        da_li_pripada_krajnja=false;
        da_li_pripada_poc=false;
    }

    public static Interval intersect(Interval i, Interval i2) {

    }

    public boolean isIn(double v) {
        if((da_li_pripada_poc || (poc_tacka<=v)) && (da_li_pripada_krajnja || (krajnja_tacka>=v)) && !(poc_tacka>v) && !(krajnja_tacka<v))
            return true;
        return false;
    }

    public boolean isNull() {
        if(poc_tacka==0 && krajnja_tacka==0 && !da_li_pripada_poc && !da_li_pripada_krajnja)
            return true;
        return false;
    }

    public Interval intersect(Interval interval) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return Double.compare(interval.poc_tacka, poc_tacka) == 0 &&
                Double.compare(interval.krajnja_tacka, krajnja_tacka) == 0 &&
                da_li_pripada_poc == interval.da_li_pripada_poc &&
                da_li_pripada_krajnja == interval.da_li_pripada_krajnja;
    }

    @Override
    public String toString() {
            String s;
            if(da_li_pripada_poc) s = "[";
            else s = "(";
            if(poc_tacka == 0 && krajnja_tacka == 0) {
                if(da_li_pripada_krajnja) s += "]";
                else s +=")";
                return s;
            }
            s += poc_tacka + "," + krajnja_tacka;
            if(da_li_pripada_krajnja) s += "]";
            else s +=")";
            return s;
        }



    @Override
    public int hashCode() {
        return Objects.hash(poc_tacka, krajnja_tacka, da_li_pripada_poc, da_li_pripada_krajnja);
    }
}
