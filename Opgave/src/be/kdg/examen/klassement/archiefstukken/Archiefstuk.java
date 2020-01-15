package be.kdg.examen.klassement.archiefstukken;

import be.kdg.examen.klassement.archiefhouders.ArchiefHouder;

import java.time.LocalDateTime;

// gegeven, mag je wijzigen
public abstract class Archiefstuk implements Comparable<Archiefstuk>{

    // gegeven, mag je niet wijzigen
    private LocalDateTime archiveringsDatum;

    // gegeven, mag je niet wijzigen
    public Archiefstuk(LocalDateTime archiveringsDatum) {
        this.archiveringsDatum = archiveringsDatum;
    }

    public abstract double getOmvang();

    @Override
    public int compareTo(Archiefstuk archiefstuk) {
        return Double.compare(this.getOmvang(), archiefstuk.getOmvang());
    }

    public LocalDateTime getArchiveringsDatum() {
        return archiveringsDatum;
    }

    public abstract ArchiefHouder.Soort hoortIn();
}
