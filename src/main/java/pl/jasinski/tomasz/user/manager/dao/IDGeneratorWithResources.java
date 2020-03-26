package pl.jasinski.tomasz.user.manager.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Logger;

public class IDGeneratorWithResources {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
    private static String ID_NUMBER = "src/main/resources/ID.txt";

    public IDGeneratorWithResources() {
        Properties properties = new Properties();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("db.properties");
            properties.load(inputStream);
            ID_NUMBER = properties.getProperty("db.ID");
//            dbID = ID_NUMBER;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer generateID() {
        Integer ID = null;


//tutaj bylo dodane dbID (wczesniej utworzony string)
        try (FileReader fileReader = new FileReader(ID_NUMBER)) {

            char[] cbuf = new char[64];
            while (fileReader.read(cbuf) != -1) {

//            LOGGER.info(Arrays.toString(cbuf));
                String stringID = String.valueOf(cbuf);
                LOGGER.info(stringID);
                ID = Integer.valueOf(stringID.trim());
            }
            if (ID != null) {
                ID++;

                Files.write(
                        Paths.get(ID_NUMBER),
                        String.valueOf(ID).getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ID;
    }


}
