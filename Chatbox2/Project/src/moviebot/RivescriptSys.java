package moviebot;

import com.rivescript.macro.Subroutine;
import com.rivescript.util.StringUtils;
import org.omg.SendingContext.RunTime;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RivescriptSys implements Subroutine {

    String cmd;
    public String call(com.rivescript.RiveScript rs, String[] args){
        cmd = StringUtils.join(args, " ");

        java.util.Scanner js;
        try{
            js = new java.util.Scanner(RunTime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
            return js.hasNext() ? js.next() : "";
        } catch (IOException ex) {
            Logger.getLogger(RivescriptSys.class.getName()).log(Level.SEVERE, null, ex);

        }
        return "";

    }


}
