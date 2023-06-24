package com.openapi.sample.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReadyResponseDto {

    private String rescode;
        private String resmsg;
        private String fgkey;



    @Builder
    public ReadyResponseDto(String rescode, String resmsg, String fgkey) {
        this.rescode = rescode;
        this.resmsg = resmsg;
        this.fgkey = fgkey;
    }
}
