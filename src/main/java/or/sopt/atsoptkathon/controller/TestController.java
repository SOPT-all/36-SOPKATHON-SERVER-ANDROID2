package or.sopt.atsoptkathon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import or.sopt.atsoptkathon.global.reponse.ApiResponse;
import or.sopt.atsoptkathon.global.reponse.ResponseDTO;
import or.sopt.atsoptkathon.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
@Tag(name = "여기에 API에 대한 전체적인 정리를 하고")
public class TestController {

    private final TestService testService;

    @GetMapping
    @Operation(summary = "여기서 API에 대한 정리를 하면 좋겠네요")
    public ResponseEntity<ResponseDTO<?>> test(String input){

        String result = testService.test(input);

        return ApiResponse.ok(result);
    }
}
