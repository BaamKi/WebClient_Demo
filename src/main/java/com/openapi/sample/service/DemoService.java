package com.openapi.sample.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openapi.sample.dto.ReadyRequestDto;
import com.openapi.sample.dto.ReadyResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@Slf4j
public class DemoService {

    private static final String API_ENDPOINT = "https://api-test.eximbay.com/v1/payments/ready";
    private static final String AUTHORIZATION_HEADER = "Basic dGVzdF9DMkZBMUY1ODQ4OUMxNTg0MTk5Qjo=";

    public Mono<ReadyResponseDto> readySubmit(ReadyRequestDto requestDto) {

        WebClient webClient = WebClient.create();
        log.info("log request : {}",requestDto.toString());
        return webClient.post()
                .uri(API_ENDPOINT)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .header(HttpHeaders.AUTHORIZATION, AUTHORIZATION_HEADER)
                .body(BodyInserters.fromValue(requestDto))
                .retrieve()
                .bodyToMono(ReadyResponseDto.class)
                .doOnSuccess(responseDto -> System.out.println("Response: " + responseDto.toString()))
                .doOnError(Throwable::printStackTrace);
    }
}



//    public void ready()
//    {
//        ReadyRequestDto requestDto = ReadyRequestDto.builder()
//                .payment(ReadyRequestDto.Payment.builder()
//                        .transactionType("PAYMENT")
//                        .orderId("KOBE_TEST")
//                        .currency("USD")
//                        .amount("1")
//                        .lang("EN")
//                        .build())
//                .merchant(ReadyRequestDto.Merchant.builder()
//                        .mid("1849705C64")
//                        .build())
//                .url(ReadyRequestDto.Url.builder()
//                        .returnUrl("https://secureapi.test.eximbay.com/paytest/demo/returnurl.jsp")
//                        .statusUrl("https://secureapi.test.eximbay.com/paytest/demo/status.jsp")
//                        .build())
//                .buyer(ReadyRequestDto.Buyer.builder()
//                        .name("kobe")
//                        .email("kobe123@eximbay.com")
//                        .build())
//                .settings(ReadyRequestDto.Settings.builder()
//                        .displayType("P")
//                        .build())
//                .build();
//
//        WebClient webClient = WebClient.create();
//        webClient.post()
//                .uri(API_ENDPOINT)
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .header(HttpHeaders.AUTHORIZATION, AUTHORIZATION_HEADER)
//                .body(BodyInserters.fromValue(requestDto))
//                .exchange()
//                .flatMap(response -> response.bodyToMono(String.class))
//                .subscribe(System.out::println, Throwable::printStackTrace);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json = null;
//        try {
//            json = objectMapper.writeValueAsString(requestDto);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        System.out.println(json);
//    }



