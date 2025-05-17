package or.sopt.atsoptkathon.service;

import lombok.RequiredArgsConstructor;
import or.sopt.atsoptkathon.domain.Product;
import or.sopt.atsoptkathon.domain.ProductImage;
import or.sopt.atsoptkathon.dto.GetProductDetailsDTO;
import or.sopt.atsoptkathon.global.exception.handler.CustomHandler;
import or.sopt.atsoptkathon.global.status.ErrorStatus;
import or.sopt.atsoptkathon.repository.ProductImageRepository;
import or.sopt.atsoptkathon.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;

    @Override
    public GetProductDetailsDTO getDetail(Long productId) {
        Product findProduct = productRepository.findById(productId)
                .orElseThrow(() -> new CustomHandler(ErrorStatus._PRODUCT_NOT_FOUND));

        productImageRepository.findAllByProduct()

        return GetProductDetailsDTO.from(findProduct);
    }
}
