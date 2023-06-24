package com.openapi.sample.controller;

import com.openapi.sample.dto.ReadyRequestDto;
import com.openapi.sample.dto.ReadyResponseDto;
import com.openapi.sample.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class DemoRestController {

    private final DemoService demoService;

    @PostMapping("/readysubmit")
    public Mono<ReadyResponseDto> readySubmit(@ModelAttribute("requestDto") ReadyRequestDto requestDto)
    {
        return demoService.readySubmit(requestDto);
    }
}
