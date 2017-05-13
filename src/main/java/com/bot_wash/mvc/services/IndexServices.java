package com.bot_wash.mvc.services;

import com.bot_wash.mvc.model.Bot;
import com.bot_wash.mvc.model.TimeOutWash;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

@Service
public class IndexServices {

    public void myMethod(){
        ApiContextInitializer.init();
        TelegramBotsApi mybot = new TelegramBotsApi();
        TimeOutWash timeOutWash = new TimeOutWash();
        Bot bot = new Bot(timeOutWash);
//        TelegramBot b = TelegramBotAdapter.build("387023002:AAFp5tIFF_2OeZaZz7F_xZ1A4m07nopqfyY");

        try {
            mybot.registerBot(bot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }

    }
}
