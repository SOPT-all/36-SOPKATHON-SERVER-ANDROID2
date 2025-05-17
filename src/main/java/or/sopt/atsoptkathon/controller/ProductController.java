package or.sopt.atsoptkathon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import or.sopt.atsoptkathon.dto.GetProductDetailsDTO;
import or.sopt.atsoptkathon.global.reponse.ApiResponse;
import or.sopt.atsoptkathon.global.reponse.ResponseDTO;
import or.sopt.atsoptkathon.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
@Tag(name = "제품 관련 API")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "제품 상세조회 API 입니다")
    @GetMapping("/product/{productId}")
    public ResponseEntity<ResponseDTO<?>> findProduct(@PathVariable Long productId) {
        GetProductDetailsDTO result = productService.getDetail(productId);

        return ApiResponse.ok(result);
    }
}
