package or.sopt.atsoptkathon.service;

import lombok.RequiredArgsConstructor;
import or.sopt.atsoptkathon.domain.Product;
import or.sopt.atsoptkathon.dto.GetCommentResponseDTO;
import or.sopt.atsoptkathon.dto.GetCommentResponseListDTO;
import or.sopt.atsoptkathon.global.exception.handler.CustomHandler;
import or.sopt.atsoptkathon.global.status.ErrorStatus;
import or.sopt.atsoptkathon.repository.CommentRepository;
import or.sopt.atsoptkathon.repository.MemberRepository;
import or.sopt.atsoptkathon.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;

    @Override
    public GetCommentResponseListDTO getComments(Long productId){
        Product findProduct = getFindProduct(productId);

        List<GetCommentResponseDTO> result = commentRepository.findAllByProduct(findProduct).stream()
                .map(comment -> GetCommentResponseDTO.builder()
                        .name(comment.getMember().getName())
                        .score(comment.getScore())
                        .content(comment.getContent())
                        .build())
                .toList();

        return GetCommentResponseListDTO.from(result);
    }


    private Product getFindProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new CustomHandler(ErrorStatus._PRODUCT_NOT_FOUND));
    }
}
