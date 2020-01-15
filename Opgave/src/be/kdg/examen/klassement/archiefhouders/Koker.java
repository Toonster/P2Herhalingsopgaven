package be.kdg.examen.klassement.archiefhouders;

import be.kdg.examen.klassement.archiefstukken.Archiefstuk;
import be.kdg.examen.klassement.archiefstukken.Kaart;

// gegeven, mag je wijzigen
public class Koker implements ArchiefHouder{

    private final double hoogte = 0.450;
    private final double straal = 0.25;
    private final double maximaalVolume = 2 * Math.PI * Math.pow(straal, 2) * hoogte;
    private Archiefstuk kaart;

    @Override
    public double getMaxVolume() {
        return 0;
    }

    @Override
    public boolean isVol() {
        return getHuidigeVullingsgraad() == 1;
    }

    @Override
    public void ontvangArchiefstuk(Archiefstuk archiefstuk) {
        this.kaart = archiefstuk;
    }
}

