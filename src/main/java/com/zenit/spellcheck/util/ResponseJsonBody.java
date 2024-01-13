package com.zenit.spellcheck.util;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class ResponseJsonBody {

    private HttpStatus status;
    private String message;
    private Object data;
    private List<String> errors;


}

