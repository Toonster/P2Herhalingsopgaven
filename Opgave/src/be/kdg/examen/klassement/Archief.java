package be.kdg.examen.klassement;

import be.kdg.examen.klassement.archiefhouders.ArchiefHouder;
import be.kdg.examen.klassement.archiefhouders.Doos;
import be.kdg.examen.klassement.archiefhouders.Koker;
import be.kdg.examen.klassement.archiefstukken.Archiefstuk;
import be.kdg.examen.klassement.archiefstukken.Boek;
import be.kdg.examen.klassement.exceptions.ArchiveringsException;

import java.util.*;

// gegeven
public class Archief {

    private Map<ArchiefHouder.Soort, List<ArchiefHouder>> archief;
    private static int kokerIndex = 0;
    private static int doosIndex = 0;

    public Archief(int aantalDozen, int aantalKokers) {
        archief = new TreeMap<>();
        initialiseerArchief(aantalDozen, aantalKokers);
    }

    private void initialiseerArchief(int aantalDozen, int aantalKokers) {
        archief.put(ArchiefHouder.Soort.DoosType, new ArrayList<>());
        List<ArchiefHouder> dozen = archief.get(ArchiefHouder.Soort.DoosType);
        for (int i = 0; i < aantalDozen; i++) {
            dozen.add(new Doos());
        }
        archief.put(ArchiefHouder.Soort.KokerType, new ArrayList<>());
        List<ArchiefHouder> kokers = archief.get(ArchiefHouder.Soort.KokerType);
        for (int i = 0; i < aantalKokers; i++) {
            kokers.add(new Koker());
        }
    }

    public void stockeer(Archiefstuk archiefstuk) {
        ArchiefHouder houder = bepaalHouder(archiefstuk);
        houder.ontvangArchiefstuk(archiefstuk);
    }

    // gegeven
    private ArchiefHouder bepaalHouder(Archiefstuk archiefstuk) {
        List<ArchiefHouder> houders;
        ArchiefHouder houder;
        if (archiefstuk.hoortIn() == ArchiefHouder.Soort.KokerType) {
            houders = archief.get(ArchiefHouder.Soort.KokerType);
            if (kokerIndex >= houders.size()) {
                throw new ArchiveringsException("Geen lege kokers beschikbaar");
            }
            houder = houders.get(kokerIndex);
            kokerIndex++;
        } else {
            houders = archief.get(ArchiefHouder.Soort.DoosType);
            if (houders.get(doosIndex).isVol()) {
                doosIndex++;
            }
            if (doosIndex >= houders.size()) {
                throw new ArchiveringsException("Geen lege dozen beschikbaar");
            }
            houder = houders.get(doosIndex);
        }
        return houder;
    }

    // gegeven
    public List<Archiefstuk> getSorteerdeBoeken() {
        List<Archiefstuk> alleBoeken = new ArrayList<>();
        List<ArchiefHouder> dozen = archief.get(ArchiefHouder.Soort.DoosType);
        for (ArchiefHouder doos : dozen) {
            List<Boek> boeken = ((Doos) doos).getBoeken();
            alleBoeken.addAll(boeken);
        }
        return alleBoeken;
    }

    public class Inventaris {
        private int gebruikteDozen;
        private int gebruikteKokers;

        public Inventaris(int gebruikteDozen, int gebruikteKokers) {
            this.gebruikteDozen = gebruikteDozen;
            this.gebruikteKokers = gebruikteKokers;
        }
    }

    private Inventaris getInventaris() {
        return new Inventaris(doosIndex, kokerIndex);
    }

    @Override
    public String toString() {
        Inventaris inventaris = getInventaris();
        StringBuilder sb = new StringBuilder("Inhoud archief\n");
        sb.append("Aantal gebruikte dozen: ").append(inventaris.gebruikteDozen).append("\n");
        sb.append("Aantal gebruikte kokers: ").append(inventaris.gebruikteKokers).append("\n");
        List<Archiefstuk> boeken = getSorteerdeBoeken();
        Collections.sort(boeken);
        for (Archiefstuk archiefstuk : boeken) {
            sb.append(archiefstuk).append("\n");
        }
        return sb.toString();
    }

}
