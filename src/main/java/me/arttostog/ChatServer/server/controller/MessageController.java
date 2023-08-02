package me.arttostog.ChatServer.server.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.arttostog.ChatServer.server.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
	@GetMapping("/send")
	public HttpStatus SendMessage(@RequestParam("user") String user, @RequestParam("date") String date, @RequestParam("message") String message) {
		if (user != null && !user.isEmpty() && message != null && !message.isEmpty() && date != null && !date.isEmpty()) {
			Message.CreateMessage(user, message, date);
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/get")
	public String GetMessages() {
		return new Gson().toJson(Message.GetMessages(), new TypeToken<List<Message>>() {}.getType());
	}
}
