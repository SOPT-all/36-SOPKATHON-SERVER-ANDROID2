package or.sopt.atsoptkathon.global.status;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorStatus {

    _TEST_EXCEPTION(HttpStatus.NOT_FOUND,"TEST4001","테스트 예외입니다"),

    _POST_TITLE_NOT_NULL(HttpStatus.BAD_REQUEST,"POST4001","게시글의 제목은 필수 입력입니다"),
    _POST_CONTENT_NOT_NULL(HttpStatus.BAD_REQUEST,"POST4002","게시글의 내용은 필수 입력입니다"),
    _POST_TITLE_LENGTH(HttpStatus.BAD_REQUEST,"POST4003","게시글의 길이는 30자를 넘을 수 없습니다"),
    _POST_TITLE_DUPLICATE(HttpStatus.BAD_REQUEST,"POST4004","게시글의 제목이 중복되었습니다"),
    _POST_CONTENT_LENGTH(HttpStatus.BAD_REQUEST,"POST4005","게시글의 내용은 1000자를 넘을 수 없습니다"),
    _POST_CREATE_TIMER(HttpStatus.BAD_REQUEST,"POST4006","게시글은 이전 게시글 작성 후 3분 뒤에 작성 할 수 있습니다"),
    _POST_NOT_FOUND(HttpStatus.BAD_REQUEST,"POST4007","게시글을 찾을 수 없습니다"),
    _POST_TAG_NOT_FOUND(HttpStatus.BAD_REQUEST,"POST4008","게시글 태그가 일치하지 않습니다"),

    _SERVER_ERROR(HttpStatus.NOT_ACCEPTABLE,"SERVER5001","서버에러입니다. 서버개발자에게 문의해주세요")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ErrorStatus(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
