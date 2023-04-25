// OPPGAVE 1 
public class Subsekvens {

    // String som inneholder selve subsekvensen. Kan ikke endres
    public final String subsekvens;
    // Antall ganger subsekvensen forekomemr
    private int antall; 

    // Konstruktør som tar inn subsekvensen og antall forekomster
    public Subsekvens(String subsekvens, int antall) {
        // Initialiserer instansvariabler
        this.subsekvens = subsekvens;
        this.antall = antall;
    }

    // Get-metode for å hente antallet forekomster
    public int hentAntallForekomster() {
        return antall;
    }

    // Set-metode for å endre antallet forekomster
    public void endreAntallForekomster(int antall) {
        // Setter instansvariabelen til det nye antallet
        this.antall = antall; 
    }

    // Metode for å øke antallet forekomster med 1
    public void oekAntallForekomster() {
        // Øker instansvariabelen med 1
        this.antall++;
    }

    // toString-metode for å formatere utskrift av Subsekvens-objektet
    @Override
    public String toString() {
        // Returnerer en String i formatet "(subsekvens,antall)"
        return "(" + subsekvens + "," + antall + ")";
        }
    }
