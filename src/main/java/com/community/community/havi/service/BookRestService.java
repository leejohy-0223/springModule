package com.community.community.havi.service;

import com.community.community.havi.domain.Book;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookRestService {

    private final RestTemplate restTemplate; // 특정 url로 비동기 요청을 처리하는 서비스

    // RestTemplateBuilder를 통해 RestTemplate를 생성한다. 이 빌더는 RestTemplate을 핸들링하는 빌더 객체로,
    // connectionTimeout.ReadTimeOut 설정 뿐 아니라, 여러 다른 설정을 간편하게 제공한다.
    public BookRestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.rootUri("/rest/test").build();
    }

    // RestTemplate의 Get 방식으로 통신하는 getForObject를 통해, /rest/test uri에 요청을 보내고, 요청 응답을 book 객체 형식으로 받아온다.
    public Book getRestBook() {
        return this.restTemplate.getForObject("/rest/test", Book.class);
    }
}
