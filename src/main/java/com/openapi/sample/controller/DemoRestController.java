package com.openapi.sample.controller;

import com.openapi.sample.dto.ReadyRequestDto;
import com.openapi.sample.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class DemoRestController {

    private final DemoService demoService;

    @PostMapping("/readysubmit")
    public void readySubmit(@ModelAttribute("requestDto") ReadyRequestDto requestDto)
    {
        System.out.printf(requestDto.toString());
        demoService.readySubmit(requestDto);
    }
}
