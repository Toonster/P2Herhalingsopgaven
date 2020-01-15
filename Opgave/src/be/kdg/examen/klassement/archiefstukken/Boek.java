package be.kdg.examen.klassement.archiefstukken;

import be.kdg.examen.klassement.archiefhouders.ArchiefHouder;
import be.kdg.examen.klassement.archiefhouders.Doos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

// gegeven, mag je wijzigen
public final class Boek extends Archiefstuk{

    // hier aanvullen
    Random rand = new Random();
    private final int aantalPaginas = rand.nextInt(1000) + 10;
    private final double lengte = 0.29;
    private final double breedte = 0.29;
    private final double hoogte = ((aantalPaginas * 0.004) + (2*0.006));

    public Boek() {
        super(LocalDateTime.now());
    }

    @Override
    public double getOmvang() {
        return lengte*breedte*hoogte;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-mm-DD HH:MM:ss");
        return String.format("boek (%s, %dp, %1.2fm³)", format.format(this.getArchiveringsDatum()), aantalPaginas, getOmvang());
    }

    @Override
    public ArchiefHouder.Soort hoortIn() {
        return ArchiefHouder.Soort.DoosType;
    }
}
