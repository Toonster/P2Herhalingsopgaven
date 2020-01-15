package be.kdg.examen.test;

import be.kdg.examen.klassement.Archief;
import be.kdg.examen.klassement.exceptions.ArchiveringsException;

// heel de klasse is gegeven en moet enkel gebruikt worden
// mag je pas gebruiken na het oplossen van Vraag 4 anders geeft het een oneindige loop

public class TestArchief {
    public static void main(String[] args) {

        System.out.println("Zonder oplossing zal dit programma in een oneindige lus terecht komen");
        System.out.println("Je kan het altijd stoppen m.b.v. IntellIJ");

        Archief archief = new Archief(200, 100);

        try {
            while (true) {
                archief.stockeer(ArchiefStukGenerator.maakRandomArchiefStuk());
            }
        } catch (ArchiveringsException exception) {
            System.out.println(exception);
        }
        System.out.println(archief);
    }
}

