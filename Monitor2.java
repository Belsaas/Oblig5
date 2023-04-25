import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

// Monitor-klasse som holder styr på SubsekvensRegister-objektet
class Monitor2 {
    private final SubsekvensRegister subsekvensRegister;
    private final ReentrantLock lock;

    public Monitor2() {
        subsekvensRegister = new SubsekvensRegister();
        lock = new ReentrantLock();
    }

// Legger til et HashMap i SubsekvensRegister-objektet
    public void leggTilHashMap(HashMap<String, Subsekvens> hashMap) {
        lock.lock();
        try {
            subsekvensRegister.leggTilHashMap(hashMap);
        } finally {
            lock.unlock();
        }
    }

// Henter antall HashMap-objekter i SubsekvensRegister-objektet
    public int tellAntallHashMaps() {
        lock.lock();
        try {
            return subsekvensRegister.tellAntallHashMaps();
        } finally {
            lock.unlock();
        }
    }

// Henter et vilkårlig HashMap-objekt fra SubsekvensRegister-objektet
    public HashMap<String, Subsekvens> hentVilkaarligHashMap(int index) {
        lock.lock();
        try {
            return subsekvensRegister.hentVilkaarligHashMap();
        } finally {
            lock.unlock();
        }
    }

// Fjerner et HashMap fra registeret basert på indeks
    public void fjernHashMap(int index) {
        lock.lock();
        try {
            subsekvensRegister.fjernHashMap(index);
        } finally {
            lock.unlock();
        }
    }
}
