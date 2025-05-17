package or.sopt.atsoptkathon.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import or.sopt.atsoptkathon.domain.Comment;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCommentResponseDTO {

    private String name;

    private String content;

    private int score;

    public static GetCommentResponseDTO from(String name,Comment comment) {
        return GetCommentResponseDTO.builder()
                .name(name)
                .content(comment.getContent())
                .score(comment.getScore())
                .build();
    }
}
