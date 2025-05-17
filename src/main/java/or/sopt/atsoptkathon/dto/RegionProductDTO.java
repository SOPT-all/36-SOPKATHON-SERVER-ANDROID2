package or.sopt.atsoptkathon.dto;

import or.sopt.atsoptkathon.domain.Product;

public record RegionProductDTO(Long id, String productName,int price, String productThumbnail) {

    public static RegionProductDTO from(Product product,String productThumbnail) {
        return new RegionProductDTO(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                productThumbnail
        );
    }
}