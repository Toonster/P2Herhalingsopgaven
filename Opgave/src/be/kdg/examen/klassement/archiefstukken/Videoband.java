package be.kdg.examen.klassement.archiefstukken;

import be.kdg.examen.klassement.archiefhouders.ArchiefHouder;
import be.kdg.examen.klassement.archiefhouders.Doos;

import java.time.LocalDateTime;

// gegeven, mag je wijzigen
public final class Videoband extends Archiefstuk{

    // hier aanvullen
    private final double lengte = 0.187;
    private final double breedte = 0.103;
    private final double hoogte = 0.025;

    public Videoband() {
        super(LocalDateTime.now());
    }

    @Override
    public double getOmvang() {
        return lengte * breedte * hoogte;
    }

    @Override
    public ArchiefHouder.Soort hoortIn() {
        return ArchiefHouder.Soort.DoosType;
    }
}
