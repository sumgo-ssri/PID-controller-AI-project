package com.develop.capstoneproject.feedback;


import com.develop.capstoneproject.ResponseMessage;
import com.develop.capstoneproject.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user/")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping("/feedback")
    public ResponseEntity<SuccessResponse<FeedbackResponseDto>> submitFeedback(@RequestBody FeedbackRequestDto dto){

        Feedback feedback = feedbackService.submitFeedback(dto);
        FeedbackResponseDto feedbackResponseDto = FeedbackResponseDto.from(feedback);

        return ResponseEntity.ok(SuccessResponse.of(
                ResponseMessage.FEEDBACK_SUBMIT_SUCCESS,
                feedbackResponseDto
        ));
    }




}
