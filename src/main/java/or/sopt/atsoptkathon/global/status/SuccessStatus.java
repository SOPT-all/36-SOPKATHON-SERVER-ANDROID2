package or.sopt.atsoptkathon.global.status;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessStatus {

    _SOPTKATHON_SUCCESS(HttpStatus.OK,"SUCCESS200","정상적으로 처리되었습니다"),

    _READ_SUCCESS(HttpStatus.OK,"200","정상적으로 조회되었습니다"),
    _UPDATE_SUCCESS(HttpStatus.OK,"200","정상적으로 수정되었습니다"),
    _DELETE_SUCCESS(HttpStatus.OK,"200","정상적으로 삭제되었습니다"),
    _CREATED_SUCCESS(HttpStatus.CREATED,"201","정상적으로 생성되었습니다");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    SuccessStatus(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
