package com.example.validation.model;

import com.example.validation.annotation.PhoneNumber;
import com.example.validation.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

    //@NotNull    // != null
    //@NotEmpty   // != null && name != ""
    //@NotBlank   // != null && name != "" && name != " "
    private String name;

    private String nickName;

    @Size(min = 1, max = 12)    // length min ~ max
    @NotBlank
    private String password;

    @Min(1)
    @Max(100)   // 1 <= value <= 100
    @NotNull
    private Integer age;

    @Email
    private String email;

    //@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다.") // PhoneNumber Validation
    @PhoneNumber // 예제로 만든 Validation Annotation
    private String phoneNumber;

    @FutureOrPresent    // 오늘 or 미래
    private LocalDateTime registerAt;

    @YearMonth(pattern = "yyyy-MM") // 예제로 만든 Validation Annotation
    private String birthDay;

    // 복합적인 Validation 이 필요할 때
    @AssertTrue(message = "name or nickName은 반드시 1개가 존재해야 합니다.")
    public boolean isNameCheck(){

        if(Objects.nonNull(name) && !name.isBlank()){
            return true;
        }

        if(Objects.nonNull(nickName) && !nickName.isBlank()){
            return true;
        }

        return false;
    }
}
