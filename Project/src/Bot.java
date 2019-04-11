import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import com.rivescript.RiveScript;


public class Bot extends TelegramLongPollingBot
{

    @Override
    public void onUpdateReceived(Update update)
    {
        System.out.println(update.getMessage().getFrom().getFirstName()+ ": " + update.getMessage().getText());
        //Send message
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setText("Hello " + update.getMessage().getFrom().getFirstName() + "\n" + update.getMessage().getText());

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return null;
    }

    @Override
    public String getBotToken() {
        return "695590627:AAHIRS9QUnUjVT0EsJUCsIUjpaHbB615pPQ";
    }
}
