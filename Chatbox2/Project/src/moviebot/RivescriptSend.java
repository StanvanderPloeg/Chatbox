package moviebot;

import com.rivescript.macro.Subroutine;
import com.rivescript.util.StringUtils;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class RivescriptSend implements Subroutine {
    DefaultAbsSender def;

    String type;
    String id;
    String cap;

    public RivescriptSend(DefaultAbsSender sender) { def = sender; }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public String call(com.rivescript.RiveScript rs, String[] args){
        type = args[0];
        if ("photo".equals(type)) {
            id = args[1];
            cap = "";
            for (int i=2; i<args.length; i++)
                cap = cap + " " + args[i];
            cap  = cap.trim();
            SendPhoto msg = new SendPhoto()
                    .setChatId(rs.currentUser())
                    .setNewPhoto(new File(id))
                    .setCaption(cap);
            try{
                 def.sendPhoto(msg);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


}
