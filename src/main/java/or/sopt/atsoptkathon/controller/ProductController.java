package or.sopt.atsoptkathon.controller;

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
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/{productId}")
    public ResponseEntity<ResponseDTO<?>> findProduct(@PathVariable Long productId) {
        GetProductDetailsDTO result = productService.getDetail(productId);

        return ApiResponse.ok(result);
    }
}
