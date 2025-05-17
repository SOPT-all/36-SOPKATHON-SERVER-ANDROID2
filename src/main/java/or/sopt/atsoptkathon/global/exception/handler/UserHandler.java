package or.sopt.atsoptkathon.global.exception.handler;


import or.sopt.atsoptkathon.global.exception.CustomException;
import or.sopt.atsoptkathon.global.status.ErrorStatus;

public class UserHandler extends CustomException {
    public UserHandler(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
