package or.sopt.atsoptkathon.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import or.sopt.atsoptkathon.domain.common.BaseEntity;
import or.sopt.atsoptkathon.domain.common.enums.ProductCategory;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
public class ProductImage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private String imageLink;
    private String fileName;
    private String imageName;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;


}
