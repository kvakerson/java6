package events;

import serverForm.ServerForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class ServerFormListener implements ActionListener {
    public static final ServerFormListener instance=new ServerFormListener();

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== ServerForm.instance.getStartButton()){
            ServerForm.instance.startServer();
            if(ServerFormListener.instance.isCorrectHost() &&ServerFormListener.instance.isCorrectPort()) {
                addTextToTextArea("Server has been started");
            } else  addTextToTextArea("Server has not been started, because port or host is uncorrect");

        }
        ////////////////////////
       if(e.getSource()==ServerForm.instance.getExitButton()){
           System.exit(0);
       }
       //////////////////////
        if(e.getSource()==ServerForm.instance.getStopButton()){
            ServerForm.instance.stopServer();
            if(ServerFormListener.instance.isCorrectHost() &&ServerFormListener.instance.isCorrectPort()) {
                addTextToTextArea("Server has been stopped\"");
            }
        }
        if(e.getSource()==ServerForm.instance.getExitButton()){
            System.exit(0);
        }

    }

    public boolean isCorrectHost() {
        if ((!Objects.equals(ServerForm.instance.getHostTextField().getText(), "")) &&
                Objects.equals(ServerForm.instance.getHostTextField().getText(), "localhost")
        ) {
            return true;
        }
        return false;
    }

    public boolean isCorrectPort() {
        if ((!Objects.equals(ServerForm.instance.getPortTextField().getText(), ""))) {
            if( Integer.parseInt(ServerForm.instance.getPortTextField().getText())>0 &&
                    Integer.parseInt(ServerForm.instance.getPortTextField().getText())<65535)
                return true;
        }
        return false;
    }

    public void addTextToTextArea(String s){
        if (Objects.equals(ServerForm.instance.getTextAreaLogs().getText(), "")) {
            ServerForm.instance.getTextAreaLogs().append(s);
        } else ServerForm.instance.getTextAreaLogs().append("\n"+s);
    }

}
