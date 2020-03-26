package pl.jasinski.tomasz.user.manager.dao;

import pl.jasinski.tomasz.user.manager.dao.entity.UserEntity;
import pl.jasinski.tomasz.user.manager.service.mapper.CsvMapper;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;


public class UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());
    private static Long id = 0L;
    private static String DB_NAME = "src/main/resources/user_db.txt";
//    private Path dataBase;
//    private BufferedWriter bufferedWriter;

    public UserDao() {
        LOGGER.info("Constructing UserDao");

        Properties properties = new Properties();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("db.properties");
//            properties.load(new FileReader("db.properties"));
            properties.load(inputStream);
            String dbName = properties.getProperty("db.name");

            DB_NAME = dbName;
            LOGGER.info("dbName: " + dbName);

            String dbUser = properties.getProperty("db.user");
            LOGGER.info("dbUser: " + dbUser);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        dataBase = Paths.get("D:/user-manager.txt");
//        try {
//            bufferedWriter = Files.newBufferedWriter(dataBase, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public UserEntity create(UserEntity userEntity) {

        LOGGER.info("saving User to DB: " + userEntity);
//        IDGenerator idGenerator = new IDGenerator();
        Integer idGenerated = IDGeneratorWithResources.generateID();

        LOGGER.info("" + idGenerated);

        userEntity.setId(Long.valueOf(idGenerated));
        CsvMapper csvMapper = new CsvMapper();
        String string = csvMapper.csvFromEntity(userEntity) + "\n";
//        String string = userEntity.toString() + "\n";
        try (FileOutputStream fileOutputStream = new FileOutputStream(DB_NAME, true)) {
            fileOutputStream.write(string.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userEntity;
    }

    public UserEntity   read(Long id) {
        try (BufferedReader br = new BufferedReader(new FileReader(DB_NAME))) {
            String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(DB_NAME, true);
//            fos.write(string.getBytes());
//        } catch (IOException e){
//            e.printStackTrace();
//        }finally {
//            if (fos != null){
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        /*
        try {
            String string = userEntity.toString() + "\n";
            Path path = Paths.get(DB_NAME);

            // Java 1.7 - new I/O
//            Files.write(
//                    path,
//                    string.getBytes(),
//                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);

//            I/O using wrappers
//            FileWriter fileWriter = new FileWriter(DB_NAME, true);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.append(string);
//            bufferedWriter.close();

//            low level I/O
            FileOutputStream fileOutputStream = new FileOutputStream(DB_NAME, true);
            fileOutputStream.write(string.getBytes());
//            fileOutputStream.flush();
//            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

//        OpenOption[] options = {StandardOpenOption.WRITE};
//        OpenOption[] options = {StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING};
//        try (BufferedWriter writer = Files.newBufferedWriter(dataBase, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
//        try (BufferedWriter writer = bufferedWriter) {
//            writer.append("User data: ").append(String.valueOf(userEntity));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

}
