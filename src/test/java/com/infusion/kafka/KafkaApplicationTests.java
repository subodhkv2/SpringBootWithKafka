package com.infusion.kafka;
import com.infusion.kafka.constant.AppConstant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.infusion.kafka.service.BookProducer;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class KafkaApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private BookProducer bookProducer;

	@MockBean
	private KafkaTemplate<String, String> kafkaTemplate1;

	@Test
	void testSendMessage_Success() {
		String message = "Test Hello World !";
		bookProducer.sendMessage(message);
		// Verify that the send method was called with the correct parameters
		verify(kafkaTemplate1, times(1)).send(eq(AppConstant.TOPIC_2), eq(message));
	}



	@Test
	void testSendMessage_Exception() {
		String message = "Test Message";
		doThrow(new RuntimeException()).when(kafkaTemplate1).send(anyString(), anyString());
		assertThrows(RuntimeException.class, () -> bookProducer.sendMessage(message));
		// This verification will pass !

	}

}
