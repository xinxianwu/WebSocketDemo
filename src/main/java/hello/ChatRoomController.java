package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatRoomController {

	@MessageMapping("/messageControl")
	@SendTo("/topic/Response")
	public ServerResponseModel said(ChatClientModel responseMessage) throws InterruptedException{
		
		System.out.println("ChatRoomController");
		
		Thread.sleep(1000);
		
		return new ServerResponseModel("歡迎來到,"+responseMessage.getName());
		
	}

}
