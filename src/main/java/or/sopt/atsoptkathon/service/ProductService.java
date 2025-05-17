package or.sopt.atsoptkathon.service;

import or.sopt.atsoptkathon.dto.GetProductDetailsDTO;

public interface ProductService {
    GetProductDetailsDTO getDetail(Long productId);
}
