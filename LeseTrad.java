import java.io.FileNotFoundException;
import java.util.HashMap;

// OPPGAVE 7
    // Oppretter en ny klasse LeseTrad som implementerer Runnable-interfacet
    class LeseTrad implements Runnable {
        
        // Deklarerer private instansvariabler
        private String filnavn;
        private Monitor1 monitor;

        // Konstruktør som tar imot filnavn og monitor som argumenter
        public LeseTrad(String filnavn, Monitor1 monitor) {
            this.filnavn = filnavn;
            this.monitor = monitor;
        }

        // Override av run-metoden
        @Override
        public void run() {
            int subsekvensLengde = 3; // Lengden på subsekvensene som skal lages
            HashMap<String, Subsekvens> hashMap;
            
            // Prøver å opprette et HashMap basert på filnavn og subsekvensLengde
            try {
                hashMap = SubsekvensRegister.lagHashMapFraFil(filnavn, subsekvensLengde);
            } 
            // Hvis filen ikke finnes, skrives det ut en feilmelding og metoden returnerer
            catch (FileNotFoundException e) {
                System.err.println("Finner ikke filen: " + filnavn);
                return;
            }
            
            // Legger til HashMap-en i monitoren
            monitor.leggTilHashMap(hashMap);
        }
    }