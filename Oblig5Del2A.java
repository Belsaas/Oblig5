import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


// OPPGAVE 5 
public class Oblig5Del2A {
    public static void main(String[] args) {

        // Må gi minst ett argument
        if (args.length < 1) {
            System.err.println("Maa oppgi filbane.");
            System.exit(1);
        }

        // Henter filbanen, lagres som en String
        String testDataSinFilBane = args[0].strip();
    
        // OPPGAVE 8
        // Oppretter en Monitor1-instans
        Monitor1 monitor = new Monitor1();

        try {
            // Oppretter en Scanner-instans som leser fra metadata.csv-filen i mappen
            Scanner metadataScanner = new Scanner(new File(testDataSinFilBane, "metadata.csv"));

            // Opprett og start LeseTrad-tråder
            // Oppretter en tom ArrayList for LeseTrad-tråder
            List<Thread> trader = new ArrayList<>();
            while (metadataScanner.hasNextLine()) {

                // Leser neste linje fra metadata.csv-filen, som representerer en fil som skal leses
                String filnavn = metadataScanner.nextLine();

                // Oppretter en ny LeseTrad-instans og en ny tråd-instans for hver fil som skal leses
                LeseTrad leseTrad = new LeseTrad(new File(testDataSinFilBane, filnavn).getPath(), monitor);
                Thread trad = new Thread(leseTrad);

                // Starter tråden og legger den til i traader-ArrayListen
                trad.start();
                trader.add(trad);
            }
            metadataScanner.close();
    
            // Vent på at alle LeseTrad-trådene skal bli ferdige
            for (Thread trad : trader) {
                trad.join();
            }

            
    
        // Feilbehandling
        } catch (FileNotFoundException e) {
            System.err.println("Finner ikke metadata.csv-filen.");
            System.exit(1);
        } catch (InterruptedException e) {
            System.err.println("En traad ble avbrutt.");
            System.exit(1);
        }
    }
}
    
   
