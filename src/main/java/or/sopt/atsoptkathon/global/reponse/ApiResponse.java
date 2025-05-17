package or.sopt.atsoptkathon.global.reponse;


import or.sopt.atsoptkathon.global.status.ErrorStatus;
import or.sopt.atsoptkathon.global.status.SuccessStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public class ApiResponse {


    public static <T> ResponseEntity<ResponseDTO<?>> ok(T result) {

        // 매번 성공 상태를 반환하는게 해커톤에 맞지 않을 것 같아 하드코딩으로 추가하였습니다
        SuccessStatus soptkathonSuccess = SuccessStatus._SOPTKATHON_SUCCESS;

        return ResponseEntity
                .status(200)
                .body(
                        new ResponseDTO<>(
                                soptkathonSuccess.getHttpStatus(),
                                soptkathonSuccess.getCode(),
                                soptkathonSuccess.getMessage(),
                                true,
                                result
                        )
                );
    }

    public static <T> ResponseEntity<ResponseDTO<?>> ok() {

        // 매번 성공 상태를 반환하는게 해커톤에 맞지 않을 것 같아 하드코딩으로 추가하였습니다
        SuccessStatus soptkathonSuccess = SuccessStatus._SOPTKATHON_SUCCESS;

        return ResponseEntity
                .status(200)
                .body(
                        new ResponseDTO<>(
                                soptkathonSuccess.getHttpStatus(),
                                soptkathonSuccess.getCode(),
                                soptkathonSuccess.getMessage(),
                                true
                        )
                );
    }


    public static <T> ResponseEntity<ResponseDTO<?>> okWithHeader(SuccessStatus successStatus, HttpHeaders headers) {
        return ResponseEntity
                .status(200)
                .headers(headers)
                .body(
                        new ResponseDTO<>(
                                successStatus.getHttpStatus(),
                                successStatus.getCode(),
                                successStatus.getMessage(),
                                true
                        )
                );
    }

    public static <T> ResponseEntity<ResponseDTO<?>> okWithHeader(SuccessStatus successStatus, HttpHeaders headers,T result) {
        return ResponseEntity
                .status(200)
                .headers(headers)
                .body(
                        new ResponseDTO<>(
                                successStatus.getHttpStatus(),
                                successStatus.getCode(),
                                successStatus.getMessage(),
                                true,
                                result
                        )
                );
    }


    // 근데 예외사항은 보통 서비스 단에서 잡히기 때문에 이렇게 컨트롤러에서 실패 응답을 보낼 상황이 잘 없지 않을까 하는 생각이...
    public static <T> ResponseEntity<ResponseDTO<?>> fail(ErrorStatus errorStatus) {
        return ResponseEntity
                .status(400)
                .body(
                        new ResponseDTO<>(
                                errorStatus.getHttpStatus(),
                                errorStatus.getCode(),
                                errorStatus.getMessage(),
                                false
                        )
                );
    }


}
