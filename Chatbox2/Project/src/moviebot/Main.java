package moviebot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class Main
{
    public static void main(String args[])
    {
        //Initialize API
        ApiContextInitializer.init();
        //Initialize TelegramAPI
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        //Bot bot = new Bot();

        try
        {
            telegramBotsApi.registerBot(new MovieBot());
        }
        catch (TelegramApiRequestException e)
        {
            e.printStackTrace();
        }
        System.out.println("Bot successfully started");

    }

}
