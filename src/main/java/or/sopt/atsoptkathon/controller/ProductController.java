package or.sopt.atsoptkathon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import or.sopt.atsoptkathon.dto.GetProductDetailsDTO;
import or.sopt.atsoptkathon.dto.PostProductResponseDTO;
import or.sopt.atsoptkathon.dto.GetRegionProductDTO;
import or.sopt.atsoptkathon.global.reponse.ApiResponse;
import or.sopt.atsoptkathon.global.reponse.ResponseDTO;
import or.sopt.atsoptkathon.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @Operation(summary = "제품 공구 신청 API 입니다")
    @PostMapping("/register/{productId}")
    public ResponseEntity<ResponseDTO<?>> registerProduct(@PathVariable Long productId,
                                                          @RequestParam Long memberId) {
        PostProductResponseDTO result = productService.registerProduct(productId, memberId);

        return ApiResponse.ok(result);
    }


    @GetMapping("/products/{regionId}")
    public ResponseEntity<ResponseDTO<?>> findRegionProduct(@PathVariable Long regionId) {
        GetRegionProductDTO result = productService.getRegionProduct(regionId);
        return ApiResponse.ok(result);
    }
}
