package com.telegram.bot;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;


import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MyAmazingBot extends TelegramLongPollingBot {
	private String userName;
	// Integer i = 1;
	HashMap<Integer, User> memberMap = new HashMap<Integer, User>();
	HashMap<String, Integer> msgMap = new HashMap<String, Integer>();
	List<Member> memList = new ArrayList<Member>();
	private int count = 0;

	@Override
	public void onUpdateReceived(Update update) {
		SendMessage message;

		if (update.hasMessage() && update.getMessage().hasText()) {
			String message_text = update.getMessage().getText();
			long chat_id = update.getMessage().getChatId();
			userName = update.getMessage().getFrom().getFirstName();
			if (!memberMap.containsKey(update.getMessage().getFrom().getId())) {
				memberMap.put(update.getMessage().getFrom().getId(), update.getMessage().getFrom());
				// i++;
			}
			Member mem = new Member();
			mem.setName(userName);
			mem.setMsg(message_text);
			memList.add(mem);
			// msgMap.put(message_text,update.getMessage().getFrom());

			System.out.println("userName:=" + update.getMessage().getFrom().getUserName());
			message = new SendMessage();
			message.setChatId(chat_id);
			message.setText(message_text);
			if (message_text.equals("/Hi")) {
				message.setText("wasssup " + userName);
				try {
					execute(message); // Sending our message object to user
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
			if (message_text.equals("/Report")) {

				for (Member memL : memList) {
					for (Map.Entry<Integer, User> entry : memberMap.entrySet()) {
						User value = entry.getValue();
						if (memL.getName().equals(value.getFirstName())) {
							count++;
						}
						

					}
					msgMap.put(memL.getName(), count - 1);

				}

				message.setText("Report :: " + msgMap);
			}

			try {
				execute(message); // Sending our message object to user
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public String getBotUsername() {
		// TODO
		return "myfirstBot";
	}

	@Override
	public String getBotToken() {
		// TODO
		return "543365487:AAEiKUysXRzzBvosYtYspkLToIowrAWAkCc";
	}
}
