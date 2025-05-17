package or.sopt.atsoptkathon.global.exception.handler;

import or.sopt.atsoptkathon.global.exception.CustomException;
import or.sopt.atsoptkathon.global.status.ErrorStatus;

public class CustomHandler extends CustomException {
    public CustomHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
