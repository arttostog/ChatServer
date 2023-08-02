package me.arttostog.ChatServer.server;

import java.util.ArrayList;
import java.util.List;

public class Message {
	public String User;
	public String Message;
	public String Date;

	private Message(String User, String Message, String Date) {
		this.User = User;
		this.Message = Message;
		this.Date = Date;
	}

	private static final List<Message> messages = new ArrayList<>();

	public static void CreateMessage(String User, String Message, String Date) {
		messages.add(new Message(User, Message, Date));
	}

	public static List<Message> GetMessages() {
		return messages;
	}
}
