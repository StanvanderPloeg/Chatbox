package moviebot;

import com.rivescript.RiveScript;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class MovieBot extends TelegramLongPollingBot
{
    Rivescript bot = new RiveScript();

    String MessageText;
    long chat_id;
    String Reply;

    public MovieBot(){
        super();
        bot.setSubroutine("system", new RivescriptSys());
        bot.setSubroutine("database", new DBConnection());
        bot.setSubroutine("send", new RivescriptSend());
        bot.loadDirectory("resources/rivescript");
        bot.sortReplies();
    }

    @Override
    public void onUpdateReceived(Update update)
    {

        if(update.hasMessage() && update.getMessage().hasText()) {
            MessageText = update.getMessage().getText();
            chat_id = update.getMessage().getChatId();

            Reply = bot.reply(String.valueOf(chat_id), MessageText);

            SendMessage message = new SendMessage()
                    .setChatId(chat_id)
                    .setText(Reply);
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        //Return bot UserName
        return "IMDB11 BOT";
    }

    @Override
    public String getBotToken() {
        //Return Telegram Token
        return "695590627:AAHIRS9QUnUjVT0EsJUCsIUjpaHbB615pPQ";
    }
}