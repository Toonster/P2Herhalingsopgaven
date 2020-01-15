package be.kdg.examen.test;

import be.kdg.examen.klassement.archiefstukken.Archiefstuk;
import be.kdg.examen.klassement.archiefstukken.Boek;
import be.kdg.examen.klassement.archiefstukken.Kaart;
import be.kdg.examen.klassement.archiefstukken.Videoband;

/**
 * Kan gebruikt worden na Vraag 1.
 */
public class TestArchiefstukken {

    public static void main(String[] args) {

        // haal je onderstaande regel uit commentaar dan moet dit een compiler fout geven
        /*Archiefstuk archiefstuk = new Archiefstuk();*/

        // uit commentaar halen na vraag 1b
            Boek boek = new Boek();
            Videoband videoband = new Videoband();
            Kaart kaart = new Kaart();

            System.out.println(boek + ", hoort in archiefhouder van het type " + boek.hoortIn());
            System.out.println("Omvang videoband is " + videoband.getOmvang() + ", hoort in archiefhouder van het type " + videoband.hoortIn());
            System.out.println("Omvang kaart is " + kaart.getOmvang() + ", hoort in archiefhouder van het type " + kaart.hoortIn());

        /*
            Output moeten lijken op:
            boek (2016-12-12 14:39:30,  667p, 0,24m³), hoort in archiefhouder van het type DoosType
            Omvang videoband is 4.81525E-4, hoort in archiefhouder van het type DoosType
            Omvang kaart is 0.0, hoort in archiefhouder van het type KokerType
         */
    }
}
