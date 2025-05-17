package or.sopt.atsoptkathon.service;

import or.sopt.atsoptkathon.dto.GetProductDetailsDTO;
import or.sopt.atsoptkathon.dto.PostProductResponseDTO;
import or.sopt.atsoptkathon.dto.GetRegionProductDTO;

public interface ProductService {
    GetProductDetailsDTO getDetail(Long productId);

    PostProductResponseDTO registerProduct(Long productId, Long memberId);

    GetRegionProductDTO getRegionProduct(Long regionId);
}
