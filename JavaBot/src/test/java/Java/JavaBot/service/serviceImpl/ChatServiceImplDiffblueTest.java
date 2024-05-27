package Java.JavaBot.service.serviceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {ChatServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ChatServiceImplDiffblueTest {
    @Autowired
    private ChatServiceImpl chatServiceImpl;

    /**
     * Method under test: {@link ChatServiceImpl#loadIntents()}
     */
    @Test
    void testLoadIntents() {
        //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

        // Arrange
        ChatServiceImpl chatServiceImpl = new ChatServiceImpl();

        // Act
        chatServiceImpl.loadIntents();

        // Assert
        assertEquals("I'm sorry, I didn't understand that.", chatServiceImpl.getResponse("User Message"));
    }

    /**
     * Method under test: {@link ChatServiceImpl#loadIntents()}
     */
    @Test
    void testLoadIntents2() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ChatServiceImpl.intents

        // Arrange and Act
        chatServiceImpl.loadIntents();
    }

    /**
     * Method under test: {@link ChatServiceImpl#getResponse(String)}
     */
    @Test
    void testGetResponse() {
        // Arrange, Act and Assert
        assertEquals("I'm sorry, I didn't understand that.", chatServiceImpl.getResponse("User Message"));
    }
}
