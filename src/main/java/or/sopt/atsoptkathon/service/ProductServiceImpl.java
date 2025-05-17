package or.sopt.atsoptkathon.service;

import lombok.RequiredArgsConstructor;
import or.sopt.atsoptkathon.domain.Member;
import or.sopt.atsoptkathon.domain.Product;
import or.sopt.atsoptkathon.domain.ProductImage;
import or.sopt.atsoptkathon.dto.GetProductDetailsDTO;
import or.sopt.atsoptkathon.dto.PostProductResponseDTO;
import or.sopt.atsoptkathon.global.exception.handler.CustomHandler;
import or.sopt.atsoptkathon.global.status.ErrorStatus;
import or.sopt.atsoptkathon.repository.MemberRepository;
import or.sopt.atsoptkathon.repository.ProductImageRepository;
import or.sopt.atsoptkathon.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final MemberRepository memberRepository;


    @Override
    public GetProductDetailsDTO getDetail(Long productId) {
        Product findProduct = getFindProduct(productId);

        List<ProductImage> allByProduct = productImageRepository.findAllByProduct(findProduct);

        List<String> imageLinks = allByProduct.stream()
                .map(ProductImage::getImageLink)
                .toList();

        return GetProductDetailsDTO.from(findProduct,imageLinks);
    }


    @Override
    public PostProductResponseDTO registerProduct(Long productId, Long memberId){

        // 추후 주문정보 저장 기능 추가 시, 이용됩니다
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new CustomHandler(ErrorStatus._MEMBER_NOT_FOUND));

        Product findProduct = getFindProduct(productId);
        addProductParticipantCount(findProduct);

        return PostProductResponseDTO.from(findProduct);
    }



    private static void addProductParticipantCount(Product findProduct) {
        if (findProduct.getParticipantCount() >= findProduct.getMaxParticipantCount()){
            throw new CustomHandler(ErrorStatus._PRODUCT_MAX_COUNT);
        }
        findProduct.addParticipantCount();
    }

    private Product getFindProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new CustomHandler(ErrorStatus._PRODUCT_NOT_FOUND));
    }
}
