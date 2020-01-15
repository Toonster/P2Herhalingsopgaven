package be.kdg.examen.klassement.archiefhouders;

import be.kdg.examen.klassement.archiefstukken.Archiefstuk;

// gegeven, mag je wijzigen
public interface ArchiefHouder {

    // gegeven
    enum Soort {
        DoosType, KokerType;
    }

    double getMaxVolume();

    default double getHuidigeVullingsgraad() {
        return 1;
    }

    boolean isVol();

    void ontvangArchiefstuk(Archiefstuk archiefstuk);
}
