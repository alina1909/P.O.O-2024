package MyStore;

public class Produs {
private String nume;
private double pret;
private double stoc;
private double vanzari;
public static final double ADD = 5;

public Produs(String nume, double pret,double stoc){
    this.nume=nume;
    this.pret=pret + ADD;
    this.stoc=stoc;
}

public Produs(String nume,double pret,double stoc,double vanzari){
    this.nume=nume;
    this.pret=pret + ADD;
    this.stoc=stoc - vanzari;
}

  
 
public boolean stoc_suf(double stoc){
    if(stoc>0)return true;
    else return false;
}


public String getnume(){
    return nume;
}

public void setnume(String nume){
    this.nume=nume;
}

public double getpret(){
    return pret;
}

public void setpret(double pret){
    this.pret=pret;
}

public double getstoc(){
    return stoc;
}

public void setstoc(double stoc){
    this.stoc=stoc;
}

public double getvanzari(){
    return vanzari;
}

@Override
public String toString() {
    StringBuffer str = new StringBuffer();
    str.append("Nume: ").append(getnume());
    str.append("  Pret vanzare:").append(getpret());

    if(stoc_suf(stoc)) {
        str.append("  Stocul ramas:").append(getstoc());

    }

    return str.toString();

}


}
