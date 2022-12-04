package serverForm;

import events.ServerFormListener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class ServerForm extends Frame {
    public static final ServerForm instance = new ServerForm();
    private Label hostLabel;
    private Label portLabel;

    private final WindowAdapter windowAdapterClose = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent evt) {
            System.exit(0);
        }
    };
    private final WindowAdapter windowAdapterOpen = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent evt) {
        }
    };

    public Label getHostLabel() {
        return hostLabel;
    }

    public Label getPortLabel() {
        return portLabel;
    }

    public TextField getHostTextField() {
        return hostTextField;
    }

    public TextField getPortTextField() {
        return portTextField;
    }

    public Button getStopButton() {
        return stopButton;
    }

    public Button getStartButton() {
        return startButton;
    }

    public Button getExitButton() {
        return exitButton;
    }

    private TextField hostTextField;
    private TextField portTextField;
    private Button stopButton;
    private Button startButton;
    private Button exitButton;
    private TextArea textAreaLogs;

    private ServerForm() {
    }

    public TextArea getTextAreaLogs() {
        return textAreaLogs;
    }

    public void init() {
        ///////////////////////////menu
        this.setTitle("Lab 6.0");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int) (dim.width / 3.5 - this.getSize().width / 2), (int) (dim.height / 3.5 - this.getSize().height / 2));
        this.setSize(1000, 700);
        this.setVisible(true);
        //////////////////////////elements
        setLayout(null);
        hostLabel = new Label("Host");
        hostLabel.setBounds(25, 25, 30, 25);
        add(hostLabel);

        portLabel = new Label("Port");
        portLabel.setBounds(150, 25, 30, 25);
        add(portLabel);

        hostTextField = new TextField();
        hostTextField.setBounds(25, 50, 100, 30);
        add(hostTextField);

        portTextField = new TextField();
        portTextField.setBounds(150, 50, 100, 30);
        add(portTextField);

        startButton = new Button("Start");
        startButton.setBounds(25, 100, 100, 30);
        add(startButton);

        stopButton = new Button("Stop");
        stopButton.setBounds(150, 100, 100, 30);
        add(stopButton);

        exitButton = new Button("Exit");
        exitButton.setBounds(275, 100, 100, 30);
        add(exitButton);
        /////////////////////////////////adding events
        ServerForm.instance.getStartButton().addActionListener(ServerFormListener.instance);
        ServerForm.instance.getStopButton().addActionListener(ServerFormListener.instance);
        ServerForm.instance.getExitButton().addActionListener(ServerFormListener.instance);


        textAreaLogs = new TextArea();
        textAreaLogs.setBounds(10, 200, 900, 400);
        add(textAreaLogs);
        stopServer();

    }

    public void stopServer() {



        getStopButton().setEnabled(false);
        getExitButton().setEnabled(true);
        getStartButton().setEnabled(true);
        getHostTextField().setEnabled(true);
        getPortTextField().setEnabled(true);

        WindowAdapter windowAdapter = new WindowAdapter() {
        };
        ServerForm.instance.removeWindowListener(windowAdapter);
        ServerForm.instance.addWindowListener(windowAdapterClose);


    }

    public void startServer() {
        if (isCorrectHost() && isCorrectPort())
        {
            getStopButton().setEnabled(true);
            getExitButton().setEnabled(false);
            getStartButton().setEnabled(false);
            getHostTextField().setEnabled(false);
            getPortTextField().setEnabled(false);
            ServerForm.instance.removeWindowListener(windowAdapterClose);
            ServerForm.instance.addWindowListener(windowAdapterOpen);
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


}