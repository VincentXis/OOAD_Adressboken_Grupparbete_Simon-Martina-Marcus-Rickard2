package Register.registryFileManagement;

import application.Console;
import application.ConsolePrinter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by MacsMac on 2016-12-20.
 */
public class AutoSave {

    private static final Logger log = Logger.getLogger(AutoSave.class.getName());

    private RegistryPersister registryPersister;
    private ConsolePrinter consolePrinter = new Console();

    public AutoSave(RegistryPersister registryPersister) {
        this.registryPersister = registryPersister;
    }

    public void autoSave() {
        new Thread(() -> {
            while (true) {
                try {
                    synchronized (this) {
                        Thread.sleep(5_000);
                        registryPersister.save();
                    }
                } catch (InterruptedException e) {
                    log.log(Level.SEVERE, "Auto-save failed", e);
                    consolePrinter.print("Auto-save failed");
                }
            }
        }).start();
    }
}