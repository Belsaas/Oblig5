import java.util.HashMap;

 //  OPPGAVE 6
    // Monitor-klasse som holder styr på SubsekvensRegister-objektet
    
    class Monitor1 {
        private SubsekvensRegister subsekvensRegister;

        public Monitor1() {
            subsekvensRegister = new SubsekvensRegister();
        }

        // Legger til et HashMap i SubsekvensRegister-objektet
        public synchronized void leggTilHashMap(HashMap<String, Subsekvens> hashMap) {
            subsekvensRegister.leggTilHashMap(hashMap);
        }

        // Henter antall HashMap-objekter i SubsekvensRegister-objektet
        public synchronized int tellAntallHashMaps() {
            return subsekvensRegister.tellAntallHashMaps();
        }

        // Henter et vilkårlig HashMap-objekt fra SubsekvensRegister-objektet
        public synchronized HashMap<String, Subsekvens> hentVilkaarligHashMap(int index) {
            return subsekvensRegister.hentVilkaarligHashMap();
        }

        // Fjerner et HashMap fra registeret basert på indeks
        public synchronized void fjernHashMap(int index) {
            subsekvensRegister.fjernHashMap(index);
    }
}