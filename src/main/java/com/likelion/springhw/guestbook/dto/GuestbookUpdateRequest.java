package com.likelion.springhw.guestbook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GuestbookUpdateRequest {

    @NotBlank(message = "제목은 필수입니다.")
    @Size(max = 100, message = "제목은 100자 이하로 작성해주세요.")
    private String title;

    @NotBlank(message = "본문은 필수입니다.")
    @Size(max = 2000, message = "본문은 2000자 이하로 작성해주세요.")
    private String content;

    @Size(max = 200, message = "PS는 200자 이하로 작성해주세요.")
    private String ps;
}
