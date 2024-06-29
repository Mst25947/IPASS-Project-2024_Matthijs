package org.model.setup;

import org.model.backend.persistence.PersistenceManager;
import org.model.backend.security.MyUser;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    private static final String file = "C:\\Users\\trick\\IdeaProjects\\IPASS-Project-2024_Matthijs"

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
            Path homeDirectory = Path.of("path");
            if (!Files.exists(homeDirectory)) {
                Files.createDirectories(homeDirectory);
            }
            PersistenceManager.save(File)
        } catch (Exception e) {
            e.printStackTrace();
            ;
        }
    }
}