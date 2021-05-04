package be.bxl.formation.models;



public class Duree {

    private int days;
    private int hours;
    private int minutes;
    private int seconds;

    public Duree(int nbSecondes) {
//        if(nbSecondes < 0) {
//            throw new PatternSyntaxException("Pas de nombre négartif");
//        }
        this.convertSecondToHumain(nbSecondes);
    }

    public Duree(int jour, int heure, int minute, int seconde) {
//        if(jour < 0 || heure < 0 || minute < 0 || seconde < 0) {
//            throw new PatternSyntaxException("Pas de nombre négartif");
//        }

        this.days = jour;
        this.hours = heure;
        this.minutes = minute;
        this.seconds = seconde;
    }

    private void convertSecondToHumain(int nbSec) {
        int totalSec = nbSec;

        this.seconds = nbSec % 60;
        totalSec -= this.seconds;

        int minutes = nbSec / 60;
        this.minutes = nbSec % 60;
        totalSec -= this.minutes *60;

        int hours = minutes / 60;
        this.hours = minutes % 60;
        totalSec -= this.hours *60 *60;

        this.days = hours / 24;
    }

    public void getDuree() {
        String textPattern = " ->  %s jours %s heures %s minutes %s secondes";
        String text = String.format(textPattern, this.days, this.hours, this.minutes, this.seconds);
        System.out.println(text);
    }
/*
    public int getTotalSeconde() {

    }

    //Prend un objet de type Duree en paramètre et soustrait cette dernière à notre objet.
    public void subDuree() {

    }

    //Même principe, mais la Duree reçue est ajoutée à notre objet.
    public void addDuree() {

    }

 */
}
