package pl.jasinski.tomasz.user.manager.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class IDGenerator {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
    private static final String ID_NUMBER = "src/main/resources/ID.txt";
    private static String ID;

    public static String generateID() {
        FileReader fileReader = null;
        try {
            char[] cbuf = new char[64];
            fileReader = new FileReader(ID_NUMBER);
            while (fileReader.read(cbuf) != -1) {

//            LOGGER.info(Arrays.toString(cbuf));
                String stringID = String.valueOf(cbuf);
                LOGGER.info(stringID);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
