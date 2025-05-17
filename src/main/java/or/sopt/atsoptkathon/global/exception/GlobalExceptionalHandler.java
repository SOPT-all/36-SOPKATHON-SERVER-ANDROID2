package or.sopt.atsoptkathon.global.exception;


import or.sopt.atsoptkathon.global.reponse.ApiResponse;
import or.sopt.atsoptkathon.global.status.ErrorDTO;
import or.sopt.atsoptkathon.global.status.ErrorStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorDTO(
                        e.getErrorStatus().getHttpStatus(),
                        e.getErrorStatus().getCode(),
                        e.getErrorStatus().getMessage())
        );
    }
}
