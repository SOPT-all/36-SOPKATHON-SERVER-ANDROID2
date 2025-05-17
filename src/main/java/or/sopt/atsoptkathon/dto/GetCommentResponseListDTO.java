package or.sopt.atsoptkathon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCommentResponseListDTO {

    List<GetCommentResponseDTO> comments;

    
}
