// Nødvendige importeringer
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;


// OPPGAVE 2
// Oppretter klassen/beholderen SubsekvensRegister
public class SubsekvensRegister {

    // Bruker ArrayList, kaller den "register"
    // Registeret tar vare på alle HashMaps som inneholder subsekvenser
    private ArrayList <HashMap <String, Subsekvens>> register;

    // Konstruktør som initialiserer "register" som et tomt ArrayList
    public SubsekvensRegister() {
        register = new ArrayList<>();
    }

    // Metode for å legge til en ny HashMap med subsekvenser i registeret
    public void leggTilHashMap(HashMap <String, Subsekvens> hashMap) {
        // Legger til hashMapet i registeret
        register.add(hashMap);
    }

    // Metode for å hente ut et HashMap med subsekvenser
    public HashMap <String, Subsekvens> hentVilkaarligHashMap () {
        // Bruker util.Random for å lage et tilfeldig tall
        Random tallGenererer = new Random();
        int index = tallGenererer.nextInt(register.size());
        // Hvis indeksen ikke er negativ og ikke større enn antallet HashMaps i registeret
        // returneres HashMapet på denne registerplassen
        if (index >= 0 && index < register.size()) {
            return register.get(index);
        }
        // Hvis if-sjekken ikke oppfylles returneres ingenting 
        else {
            return null;
        }
    }

    // Metode som returnerer antallet hashMaps i registeret v.h.a. .size
    public int tellAntallHashMaps() {
        return register.size();
    }

    // OPPGAVE 3
    // Statisk metode som leser én fil med én persons immunrepertoar 
    public static HashMap <String, Subsekvens> lagHashMapFraFil (String filnavn, int subsekvensLengde) throws FileNotFoundException {
        // Oppretter nytt HashMap
        HashMap <String, Subsekvens> subsekvensHashMap = new HashMap<>();
        
        // Leser inn linjer fra filnavn
        try (Scanner scanner = new Scanner(new File(filnavn))) {
            while (scanner.hasNextLine()) {
                // Lager String linje som linjen i filen
                String linje = scanner.nextLine();
            
                if (linje.length() < subsekvensLengde) {
                    System.err.println("Linjen er kortere enn 3 tegn");
                    System.exit(1);
                    
                // Løkke som går gjennom alle mulige startposisjoner for subsekvensene (alt fra 0 til lengde-3)
                    for (int i = 0; i <= linje.length() - subsekvensLengde; i++) {
                        // Oppretter subsekvensene 
                        String subsekvens = linje.substring(i, i + subsekvensLengde);
                        // legger de til i hashMapene, setter antallet til 1 (siden det er et krav for å ta de med)
                        // men kun/maks én gang
                        subsekvensHashMap.putIfAbsent(subsekvens, new Subsekvens(subsekvens, 1));
                            }
                        }
                    }
            // Returnerer det endelige hashMapet 
            return subsekvensHashMap;
            }
        }

        // OPPGAVE 4
        public static HashMap<String, Subsekvens> flettHashMaps(HashMap<String, Subsekvens> hashMap1, HashMap<String, Subsekvens> hashMap2) {
            // Oppretter en ny HashMap som vil inneholde den sammenslåtte resultatet
            HashMap<String, Subsekvens> sammenslattHashMap = new HashMap<>();

            // Går gjennom første HashMap og legger til alle elementer i det sammenslåtte HashMapet
            for (String subsekvens : hashMap1.keySet()) {
                sammenslattHashMap.put(subsekvens, hashMap1.get(subsekvens));
            }

            // Går gjennom andre HashMap og legger til elementer i det sammenslåtte HashMapet
            // Hvis en subsekvens allerede finnes i det sammenslåtte HashMapet, øker vi antallet forekomster
            for (String subsekvens : hashMap2.keySet()) {
                Subsekvens eksisterendeSubsekvens = sammenslattHashMap.get(subsekvens);

                if (eksisterendeSubsekvens != null) {
                    // Hvis subsekvensen allerede finnes i det sammenslåtte HashMapet, øker vi antallet forekomster
                    eksisterendeSubsekvens.endreAntallForekomster(eksisterendeSubsekvens.hentAntallForekomster() + hashMap2.get(subsekvens).hentAntallForekomster());
                } else {
                    // Hvis subsekvensen ikke finnes i det sammenslåtte HashMapet, legger vi den til
                    sammenslattHashMap.put(subsekvens, hashMap2.get(subsekvens));
                }
            }
            return sammenslattHashMap;
        }

    // Metode for å fjerne HashMap
    public void fjernHashMap(int index) {
        if (index >= 0 && index < register.size()) {
            register.remove(index);
        }
    }    
}

