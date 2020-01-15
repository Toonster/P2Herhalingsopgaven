package be.kdg.examen.klassement.archiefhouders;

import be.kdg.examen.klassement.Archief;
import be.kdg.examen.klassement.archiefstukken.Archiefstuk;
import be.kdg.examen.klassement.archiefstukken.Boek;
import be.kdg.examen.klassement.archiefstukken.Videoband;

import java.util.ArrayList;
import java.util.List;

// gegeven, mag je wijzigen
public class Doos implements ArchiefHouder {

    private final double lengte = 0.305;
    private final double breedte = 0.215;
    private final double hoogte = 0.110;
    private final double maximaalVolume = lengte * breedte * hoogte;
    private List<Archiefstuk> boekenEnVideobanden = new ArrayList<>();

    @Override
    public double getMaxVolume() {
        return 0;
    }

    @Override
    public double getHuidigeVullingsgraad() {
        double vullingsgraad = 0;
        if (!boekenEnVideobanden.isEmpty()) {
            for (Archiefstuk archiefstuk : boekenEnVideobanden) {
                vullingsgraad += archiefstuk.getOmvang();
            }
        }
        return vullingsgraad / maximaalVolume;
    }

    @Override
    public boolean isVol() {
        return getHuidigeVullingsgraad() > 0.95;
    }

    @Override
    public void ontvangArchiefstuk(Archiefstuk archiefstuk) {
        boekenEnVideobanden.add(archiefstuk);
    }

    public List<Boek> getBoeken() {
        List<Boek> boeken = new ArrayList<>();
        for (Archiefstuk archiefstuk : boekenEnVideobanden) {
            if (archiefstuk instanceof Boek) {
                boeken.add((Boek) archiefstuk);
            }
        }
        return boeken;
    }
}
