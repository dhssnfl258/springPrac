package tester;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest //메인 애플리케이션 클래스에 추가하는 @SpringBootApplication 이 있는 클래스를 찾고 그 클래스에 포함되어 있는 빈을 찾은 후 테스트용 컨텍스트를 만든다.
@AutoConfigureMockMvc //MockMvc를 생성하고 자동으로 구성하는 애플리케이션. MockMvc는 애플리케이션을 서버에 배포하지 않고도 MVC 환경을 만들어 테스트 할 수 있게 해준다.
class TestControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void setMockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @AfterEach
    public void cleanUp() {
        memberRepository.deleteAll();
    }


    @DisplayName("getAllMembers: 아티클 조회에 성공한다")
    @Test
    public void getAllMembers() throws Exception {
        //given
        final String url = "/test";
        Member savedMember = memberRepository.save(new Member(1L, "tester"));
        Member savedMember2 = memberRepository.save(new Member(2L, "tester2"));

        //when
        final ResultActions result = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON));

        //then
        result
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[1].id").value(savedMember2.getId()))
                .andExpect(jsonPath("$[1].name").value(savedMember2.getName()));
    }
}