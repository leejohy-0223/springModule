package com.community.community.havi;

import com.community.community.havi.domain.Book;
import com.community.community.havi.service.BookRestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@ExtendWith(SpringExtension.class)
@RestClientTest(BookRestService.class) // 테스트 대상이 되는 빈을 주입받는다.
public class BookRestTest {


    @Autowired
    private BookRestService bookRestService;

    @Autowired
    private MockRestServiceServer server; // 이 클래스는 클라 - 서버 사이의 REST test를 위한 객체이다.
                                          // 이 코드에서는 목 객체처럼 실제로 통신이 이루어지지는 않지만, 지정한 경로에 얘ㅖ상하는 반환값 명시했다.

    @Test
    public void rest_테스트() {
        this.server.expect(requestTo("/rest/test")) // 여기로 요청 보내면, 아래 /test/json을 보내도록 설정했다.
                .andRespond(withSuccess(new ClassPathResource("/test.json",
                        getClass()), MediaType.APPLICATION_JSON));
        Book book = this.bookRestService.getRestBook();
        assertThat(book.getTitle()).isEqualTo("테스트");
    }


}
