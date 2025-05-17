package or.sopt.atsoptkathon.global.exception;


import lombok.Getter;
import or.sopt.atsoptkathon.global.status.ErrorStatus;

@Getter
public class CustomException extends RuntimeException {

    private final ErrorStatus errorStatus;

    public CustomException(ErrorStatus errorStatus) {
        this.errorStatus = errorStatus;
    }

}
