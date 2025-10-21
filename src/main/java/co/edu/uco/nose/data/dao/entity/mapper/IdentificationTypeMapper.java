package co.edu.uco.nose.data.dao.entity.mapper;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.crosscuting.messagescatalog.MessagesEnum;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.IdentificationTypeEntity;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IdentificationTypeMapper {

    public static IdentificationTypeEntity map(final ResultSet resultSet){
        var idType = new IdentificationTypeEntity();

        try {
            idType.setId(UUIDHelper.getUUIDHelper().getFromString(resultSet.getString("idIdentificationType")));
            idType.setName(resultSet.getString("nameIdentificationType"));
        } catch (final SQLException exception){

            var userMessage = MessagesEnum.USER_ERROR_SQL_EXCEPTION_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_EXCEPTION_MAPPER.getContent() + "En IdentificationTypeMapper: " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesEnum.USER_ERROR_UNEXPECTED_EXCEPTION_MAPPER.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_EXCEPTION_MAPPER.getContent() + "En IdentificationTypeMapper: " + exception.getMessage();
            throw NoseException.create(exception, userMessage, technicalMessage);

        }
        return idType;
    }


}
