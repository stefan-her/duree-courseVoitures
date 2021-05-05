package be.bxl.formation.models;

import java.util.HashMap;

public class Duree {

    private int totSec;

    public Duree(int sec) {
        this.totSec = sec;
        this.setDuree(sec);
    }

    public Duree(int jour, int heure, int minute, int seconde) {
        if(jour < 0 || heure < 0 || heure > 24 || minute < 0 || minute > 60|| seconde < 0 || seconde > 60) {
            throw new IllegalArgumentException("respecter la valeur des temps");
        }

        int sec = (jour * 86400) + (heure * 3600) + (minute * 60) + seconde;
        this.totSec = sec;
        this.setDuree(sec);
    }

    private HashMap convertSecondToHumain(int sec) {
        HashMap<String, Integer> dhms = new HashMap<String, Integer>();
        dhms.put("sec", sec % 60);
        dhms.put("min", (sec / 60) % 60);
        dhms.put("hours", (sec / 3600) % 24);
        dhms.put("days", sec / 86400);
        return dhms;
    }

    public String getDuree() {
        HashMap dhms = this.convertSecondToHumain(this.totSec);
        String textPattern = " ->  %s jours %s heures %s minutes %s secondes";
        String text = String.format(textPattern, dhms.get("days"), dhms.get("hours"), dhms.get("min"), dhms.get("sec"));
        return text;
    }

    private void setDuree(int sec) {
        if(sec < 0) {
            throw new IllegalArgumentException("pas de temps négatif");
        }
        this.totSec = sec;
    }

    public int getTotalSeconde() {
        return this.totSec;
    }

    //Prend un objet de type Duree en paramètre et soustrait cette dernière à notre objet.
    public void subDuree(Duree obj) {
        int tmp = this.totSec - obj.totSec;
        this.setDuree(tmp);
    }

    //Même principe, mais la Duree reçue est ajoutée à notre objet.
    public void addDuree(Duree obj) {
        this.setDuree(this.totSec + obj.totSec);
    }
}
