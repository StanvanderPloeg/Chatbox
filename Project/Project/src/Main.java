package SuperSwagMovieBot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

public class Main
{
    public static void main(String args[])
    {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        Bot bot = new Bot();


        // Register our bot
        try {
            botsApi.registerBot(new SuperSwagMovieBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println("MovieBuffBot successfully started.");
    }
        /*try
        {
            telegramBotsApi.registerBot(bot);
        }
        catch (TelegramApiRequestException e)
        {
            e.printStackTrace();
        }
*/

    }

}
