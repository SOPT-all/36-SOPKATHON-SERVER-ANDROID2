package or.sopt.atsoptkathon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import or.sopt.atsoptkathon.domain.Product;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostProductResponseDTO {

    private int participantCount;

    public static PostProductResponseDTO from(Product product){

        return PostProductResponseDTO.builder()
                .participantCount(product.getParticipantCount())
                .build();
    }
}
