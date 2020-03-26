package pl.jasinski.tomasz.user.manager.service.mapper;

import org.junit.jupiter.api.Test;
import pl.jasinski.tomasz.user.manager.dao.entity.UserEntity;

import static org.junit.jupiter.api.Assertions.*;

class CsvMapperTest {

    @Test
    void csvFromEntity() {
        //GIVEN
        CsvMapper csvMapper = new CsvMapper();
        UserEntity userEntity = new UserEntity("Kamil", "LoginKamil");
        userEntity.setId(1L);
        userEntity.setPassword(new char[]{'p', '1'});
        userEntity.setEmail("kamil@email.com");

        //WHEN
        String csvLine = csvMapper.csvFromEntity(userEntity);

        //THEN
        String expectedCsvLine = "1,Kamil,LoginKamil,p1,kamil@email.com" ;
        assertEquals(expectedCsvLine,csvLine, "Values are not the same");

    }
}