package org.model.backend.persistence;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.nio.file.Files;
import java.nio.file.Path;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    private static final String file = "C:\\Users\\trick\\IdeaProjects\\IPASS-Project-2024_Matthijs\\data.obj";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            PersistenceManager.load(file);
        } catch (Exception e) {
            System.out.println("Could not load data from file");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            Path homeDirectory = Path.of("C:\\Users\\trick\\IdeaProjects\\IPASS-Project-2024_Matthijs");
            if (!Files.exists(homeDirectory)) {
                Files.createDirectories(homeDirectory);
            }
            PersistenceManager.save(file);
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
    }
}