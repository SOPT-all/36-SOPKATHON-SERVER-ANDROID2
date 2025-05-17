package or.sopt.atsoptkathon.service;

import or.sopt.atsoptkathon.global.exception.handler.CustomHandler;
import or.sopt.atsoptkathon.global.status.ErrorStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TestService {

    public String test(String input){

        if (Objects.equals(input, "1")){
            throw new CustomHandler(ErrorStatus._TEST_EXCEPTION);
        }

        return "예외는 이렇게 처리해주세요";
    }
}
