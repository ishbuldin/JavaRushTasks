package com.javarush.task.task30.task3008.client;



import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int x = (int)(Math.random() * 100);
        return "date_bot_" + x;
    }

    public class BotSocketThread extends Client.SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (!message.contains(":")) {
                return;
            }
            String userName = message.split(":")[0].trim();
            String msgData = message.split(":")[1].trim();
            switch (msgData) {
                case "дата": {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.MM.YYYY");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(Calendar.getInstance().getTime()));
                    break;
                }
                case "день": {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(Calendar.getInstance().getTime()));
                    break;
                }
                case "месяц": {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(Calendar.getInstance().getTime()));
                    break;
                }
                case "год": {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(Calendar.getInstance().getTime()));
                    break;
                }
                case "время": {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H:mm:ss");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(Calendar.getInstance().getTime()));
                    break;
                }
                case "час": {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("H");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(Calendar.getInstance().getTime()));
                    break;
                }
                case "минуты": {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("m");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(Calendar.getInstance().getTime()));
                    break;
                }
                case "секунды": {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("s");
                    sendTextMessage("Информация для " + userName + ": " + simpleDateFormat.format(Calendar.getInstance().getTime()));
                    break;
                }
            }
        }
    }
}