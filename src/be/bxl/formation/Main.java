package be.bxl.formation;

import be.bxl.formation.models.Duree;

public class Main {
    public static void main(String[] args) {

        Duree vers1 = new Duree(500);
        System.out.print(vers1.getDuree());
        System.out.println(" -> : " + vers1.getTotalSeconde());

        Duree vers2 = new Duree(1, 3, 20, 30);
        System.out.print(vers2.getDuree());
        System.out.println(" -> : " + vers2.getTotalSeconde());

        System.out.println("________________________________________");

        vers1.addDuree(vers2);
        System.out.print(vers1.getDuree());
        System.out.println(" -> : " + vers1.getTotalSeconde());

        vers2.subDuree(vers1);
        System.out.print(vers2.getDuree());
        System.out.println(" -> : " + vers2.getTotalSeconde());
    }
}
