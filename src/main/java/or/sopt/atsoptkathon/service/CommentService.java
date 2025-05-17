package or.sopt.atsoptkathon.service;

import or.sopt.atsoptkathon.dto.GetCommentResponseListDTO;

public interface CommentService {
    GetCommentResponseListDTO getComments(Long productId);
}
