package Java.JavaBot.controller;

import static org.mockito.Mockito.when;

import Java.JavaBot.service.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ChatController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ChatControllerDiffblueTest {
    @Autowired
    private ChatController chatController;

    @MockBean
    private ChatService chatService;

    /**
     * Method under test: {@link ChatController#chat(String)}
     */
    @Test
    void testChat() throws Exception {
        // Arrange
        when(chatService.getResponse(Mockito.<String>any())).thenReturn("Response");
        MockHttpServletRequestBuilder contentTypeResult = MockMvcRequestBuilders.post("/chat/chatResponse")
                .contentType(MediaType.APPLICATION_JSON);
        MockHttpServletRequestBuilder requestBuilder = contentTypeResult
                .content((new ObjectMapper()).writeValueAsString("foo"));

        // Act and Assert
        MockMvcBuilders.standaloneSetup(chatController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Response"));
    }
}
