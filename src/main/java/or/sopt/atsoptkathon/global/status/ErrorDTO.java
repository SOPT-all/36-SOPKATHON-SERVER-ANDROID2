package or.sopt.atsoptkathon.global.status;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorDTO {

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


    public ErrorDTO(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

}
