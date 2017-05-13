package com.bot_wash.mvc.model;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.util.*;


public class Bot extends TelegramLongPollingBot {

    Set<Long> idSet= new LinkedHashSet<>();

    boolean free = true;
    private Date now;
    TimeOutWash timeOutWash;

    public Bot(TimeOutWash timeOutWash) {
        this.timeOutWash = timeOutWash;
    }

    @Override
    public void onUpdateReceived(Update update) {


        idSet.add(update.getMessage().getChatId());
        System.out.println(update.getMessage().getFrom().getFirstName() +" = " +
                update.getMessage().getText());
       // Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("YYYY.MM.dd HH:mm");
        System.out.println(format.format(calendar.getTime()));

        Iterator<Long> iterator = idSet.iterator();

        String timeForWashing = update.getMessage().getText();

        if (timeOutWash.isFree()) {
            while (iterator.hasNext()) {
                Long id = iterator.next();
                if (timeForWashing.equals("1") || timeForWashing.equals("2") || timeForWashing.equals("3")) {
                    timeOutWash.setTime(Long.parseLong(timeForWashing));
                    timeOutWash.setFirstName(update.getMessage().getFrom().getFirstName());
                    timeOutWash.setLastName(update.getMessage().getFrom().getLastName());
                    SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
                    sendMessage.setText("=> Сообщаю ВСЕМ! <=\n Я " + timeOutWash.getFirstName() + " " + timeOutWash.getLastName() +
                            "\n" + "поставил стирку на " + timeForWashing + " мин.\n" +
                            format.format(calendar.getTime()));
                    try {
                        sendMessage(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    MyTimerTask task = new MyTimerTask(new Timer(),Long.parseLong(timeForWashing),timeOutWash);
                    timeOutWash.setDateNow(calendar.getTime());
                    timeOutWash.setFree(false);
                }else{
                    SendMessage sendMessage = new SendMessage().setChatId(id);
                    sendMessage.setText("=> Сообщаю ВСЕМ! <=\n" + "Для запуска машинки необходимо ввести время стирки.\n" +
                            "Время стирки: \n"+
                            "Стирка 1 мин.\nСтирка 2 мин.\nСтирка 3 мин.");
                    try {
                        sendMessage(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{



        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
            sendMessage.setText("=> Сообщаю ВСЕМ! <=\nСтиральная машинка занята пользователем\n" + timeOutWash.getFirstName() + " " + timeOutWash.getLastName() +
                    "\n" + "поставил стирку на " + timeOutWash.getTime() + " мин.\n" +
                    "Стирка закончится в " + format.format(calendar.getTime().getTime() + (timeOutWash.getTime() * 60000))
            );
            try {
                sendMessage(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return "387023002:AAFp5tIFF_2OeZaZz7F_xZ1A4m07nopqfyY";
    }

}
