package com.amr.ctx.user.user_context.shared.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class HealthCheckRestControllerTest {

    @InjectMocks
    private HealthCheckRestController healthCheckRestController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {

        mockMvc = MockMvcBuilders.standaloneSetup(healthCheckRestController).build();
    }

    @Test
    void shouldHealthCheckReturnStatusOkWithBody() throws Exception {

        HashMap<String, String> expectedStatus = new HashMap<>();
        expectedStatus.put("bounded-context", "user-context");
        expectedStatus.put("status", "ok");
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedStatusJson = objectMapper.writeValueAsString(expectedStatus);
        String url = "/api/users/health-check/bounded-context";
        MockHttpServletResponse response = mockMvc.perform(get(url).accept(MediaType.APPLICATION_JSON))
                                                  .andExpect(status().isOk())
                                                  .andReturn()
                                                  .getResponse();
        String actualResponseBody = response.getContentAsString();
        assertEquals(expectedStatusJson, actualResponseBody);
    }

}