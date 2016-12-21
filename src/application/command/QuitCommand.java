package application.command;

import Register.RegistryPersister;
import application.Application;
import application.Console;
import application.ConsolePrinter;

/**
 * Created by PereZ on 2016-12-20.
 */
public class QuitCommand implements Command {
    private String name = "Quit";
    private String description = "Quit program";
    private Application application;
    private RegistryPersister registryPersister;
    private ConsolePrinter consolePrinter = new Console();

    public QuitCommand(Application application, RegistryPersister registryPersister) {
        this.application = application;
        this.registryPersister = registryPersister;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void execute() {
        registryPersister.save();
        consolePrinter.print("Goodbye!");
        application.quit();
    }
}
