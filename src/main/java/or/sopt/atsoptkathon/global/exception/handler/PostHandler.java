package or.sopt.atsoptkathon.global.exception.handler;


import or.sopt.atsoptkathon.global.exception.CustomException;
import or.sopt.atsoptkathon.global.status.ErrorStatus;

public class PostHandler extends CustomException {

    public PostHandler(ErrorStatus errorDTO) {

        super(errorDTO);

    }
}
