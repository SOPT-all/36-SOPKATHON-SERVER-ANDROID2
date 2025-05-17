package or.sopt.atsoptkathon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import or.sopt.atsoptkathon.domain.Product;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProductDetailsDTO {

    private String productName;

    private String description;

    private int price;

    private String sellerName;

    private int participantCount;

    private int maxParticipantCount;

    private List<String> imageLinks;

    public static GetProductDetailsDTO from(Product product,List<String> imageLinks) {

        return GetProductDetailsDTO.builder()
                .productName(product.getProductName())
                .description(product.getDescription())
                .price(product.getPrice())
                .sellerName(product.getSellerName())
                .participantCount(product.getParticipantCount())
                .maxParticipantCount(product.getMaxParticipantCount())
                .imageLinks(imageLinks)
                .build();
    }
}
