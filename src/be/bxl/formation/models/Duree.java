package be.bxl.formation.models;



public class Duree {

    private int seconds;

    public Duree(int nbSecondes) {
        if(nbSecondes < 0) {
            throw new IllegalArgumentException("Pas de nombre négartif");
        }
    }

    public Duree(int jour, int heure, int minute, int seconde) {
        if(jour < 0 || heure < 0 || heure > 24 || minute < 0 || minute > 60|| seconde < 0 || seconde > 60) {
            throw new IllegalArgumentException("Pas de nombre négartif");
        }

        this.seconds = (jour * 86400) + (heure * 3600) + (minute * 60) + seconde;
    }

    private void convertSecondToHumain(int nbSec) {
        int sec = this.seconds % 60;
        int min = (this.seconds / 60) % 60;
        int hours = (this.seconds / 3600) % 60;
        int days = this.seconds / 86400;

    }

    public void getDuree() {
        String textPattern = " ->  %s jours %s heures %s minutes %s secondes";
        String text = String.format(textPattern, this.days, this.hours, this.minutes, this.seconds);
        System.out.println(text);
    }

    public int getTotalSeconde() {
        return this.seconds;
    }

    //Prend un objet de type Duree en paramètre et soustrait cette dernière à notre objet.
    public void subDuree() {

    }

    //Même principe, mais la Duree reçue est ajoutée à notre objet.
    public void addDuree() {

    }

}
