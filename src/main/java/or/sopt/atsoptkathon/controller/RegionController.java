package or.sopt.atsoptkathon.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import or.sopt.atsoptkathon.dto.GetRegionDetailDTO;
import or.sopt.atsoptkathon.global.reponse.ApiResponse;
import or.sopt.atsoptkathon.global.reponse.ResponseDTO;
import or.sopt.atsoptkathon.service.RegionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
@Tag(name = "지역 관련 API")
public class RegionController {

    private final RegionService regionService;

    @Operation(summary = "지역 상세 조회 API 입니다")
    @GetMapping("/region/{regionId}")
    public ResponseEntity<ResponseDTO<?>> findRegionDetail(@PathVariable Long regionId) {
        GetRegionDetailDTO result = regionService.getRegionDetail(regionId);
        return ApiResponse.ok(result);
    }
}
