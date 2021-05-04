package be.bxl.formation.models;

import java.util.HashMap;

public class Duree {

    private int totSecondsOrg;
    private int totSecondsMod;

    public Duree(int sec) {
        if(sec < 0) {
            throw new IllegalArgumentException("Pas de nombre négartif");
        }

        this.totSecondsOrg = sec;
        this.totSecondsMod = this.totSecondsOrg;
    }

    public Duree(int jour, int heure, int minute, int seconde) {
        if(jour < 0 || heure < 0 || heure > 24 || minute < 0 || minute > 60|| seconde < 0 || seconde > 60) {
            throw new IllegalArgumentException("Pas de nombre négartif");
        }

        int sec = (jour * 86400) + (heure * 3600) + (minute * 60) + seconde;
        this.totSecondsOrg = sec;
        this.totSecondsMod = this.totSecondsOrg;
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
        HashMap dhms = this.convertSecondToHumain(this.totSecondsMod);
        String textPattern = " ->  %s jours %s heures %s minutes %s secondes";
        String text = String.format(textPattern, dhms.get("days"), dhms.get("hours"), dhms.get("min"), dhms.get("sec"));
        return text;
    }

    public int getTotalSeconde() {
        return this.totSecondsMod;
    }

    //Prend un objet de type Duree en paramètre et soustrait cette dernière à notre objet.
    public void subDuree(Duree obj) {
        int tmp = this.totSecondsOrg - obj.totSecondsOrg;
        if(tmp < 0) {
            throw new IllegalArgumentException("pas de temps négatif");
        }
        this.totSecondsMod = tmp;
    }

    //Même principe, mais la Duree reçue est ajoutée à notre objet.
    public void addDuree(Duree obj) {
        this.totSecondsMod = this.totSecondsOrg + obj.totSecondsOrg;
    }
}
