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
            if(Objects.equals(ServerForm.instance.getTextAreaLogs().getText(), "")){
                ServerForm.instance.getTextAreaLogs().append("Server has been started");
            }
            else ServerForm.instance.getTextAreaLogs().append("\nServer has been started");
        }
       if(e.getSource()==ServerForm.instance.getExitButton()){
           System.exit(0);
       }
        if(e.getSource()==ServerForm.instance.getStopButton()){
            ServerForm.instance.stopServer();
            if(Objects.equals(ServerForm.instance.getTextAreaLogs().getText(), "")){
                ServerForm.instance.getTextAreaLogs().append("Server has been stopped");
            }
            else ServerForm.instance.getTextAreaLogs().append("\nServer has been stopped");
        }
        if(e.getSource()==ServerForm.instance.getExitButton()){
            System.exit(0);
        }

    }

}
