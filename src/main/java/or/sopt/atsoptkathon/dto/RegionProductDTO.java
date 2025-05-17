package or.sopt.atsoptkathon.dto;

import or.sopt.atsoptkathon.domain.Product;

public record RegionProductDTO(Long id, String productName, String productThumbnail) {
    public static RegionProductDTO from(Product product) {
        return new RegionProductDTO(
                product.getId(),
                product.getProductName(),
                product.getDescription()
        );
    }
}