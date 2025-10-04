package co.edu.uco.nose.crosscuting.exception;

import co.edu.uco.nose.crosscuting.helpers.ObjetcHelper;
import co.edu.uco.nose.crosscuting.helpers.TextHelper;

public final class  NoseException extends RuntimeException {

    private static final long serialVersionUID = -433023700129543247L;
    private Throwable rootException;
    private String userMessage;
    private String technicalMessage;

    private NoseException( final Throwable rootException, final String userMessage, final String technicalMessage) {
        setTechnicalMessage(technicalMessage);
        setUserMessage(userMessage);
        setRootException(rootException);
    }

    public static NoseException create(final String userMessage){
        return new NoseException(new Exception(), userMessage, userMessage);
    }

    public static NoseException create(final String userMessage, final String technicalMessage){
        return new NoseException(new Exception(), userMessage, technicalMessage);
    }

    public static NoseException create(final Throwable rootException, final  String userMessage, final String technicalMessage){
        return new NoseException(rootException, userMessage, technicalMessage);
    }
    public String getTechnicalMessage() {

        return technicalMessage;
    }

    public void setTechnicalMessage(final String technicalMessage) {
        this.technicalMessage = TextHelper.getDefaultWithTrim(technicalMessage);
    }

    public Throwable getRootException() {

        return rootException;
    }

    public void setRootException(final Throwable rootException) {
        this.rootException = ObjetcHelper.getDefault(rootException, new Exception());
    }

    public String getUserMessage() {

        return userMessage;
    }

    private void setUserMessage(String userMessage) {
        this.userMessage = TextHelper.getDefaultWithTrim(userMessage);
    }
}
