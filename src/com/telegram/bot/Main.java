package com.telegram.bot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
public class Main {
    public static void main(String[] args) {

    	ApiContextInitializer.init();
    	TelegramBotsApi botsApi = new TelegramBotsApi();
    	 try {
             botsApi.registerBot(new MyAmazingBot());
         } catch (TelegramApiException e) {
             e.printStackTrace();
         }
    }
}