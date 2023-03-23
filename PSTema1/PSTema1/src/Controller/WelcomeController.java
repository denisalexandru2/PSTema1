package Controller;

import View.LogInView;
import View.WelcomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class WelcomeController implements ActionListener {

    private JFrame frame;
    public WelcomeView welcomeView;

    public WelcomeController(JFrame frame) {
        this.frame = frame;
        this.welcomeView = new WelcomeView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("Log In")) {
            // Open the LogIn view
            LogInView logInView = new LogInView();
            LogInController logInController = new LogInController(logInView);
            logInView.setVisible(true);
            frame.setVisible(false);
        }
//        else if (button.getText().equals("Register")) {
//            // Open the Register view
//            RegisterView registerView = new RegisterView();
//            RegisterController registerController = new RegisterController(registerView);
//            registerView.setVisible(true);
//            frame.dispose();
//        }
    }
}
