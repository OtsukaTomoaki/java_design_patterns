package Mediator;

import java.awt.Frame;
import java.awt.Button;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.CheckboxGroup;
import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends Frame implements Mediator, ActionListener {
  private ColleagueCheckBox checkGuest;
  private ColleagueCheckBox checkLogin;
  private ColleagueTextField textUser;
  private ColleagueTextField textPass;
  private ColleagueButton buttonOk;
  private ColleagueButton buttonCancel;

  public LoginFrame(String title) {
    super(title);

    // 背景色を設定
    setBackground(Color.lightGray);

    // レイアウトを設定
    setLayout(new GridLayout(4, 2));

    // Colleagueのインスタンスを生成
    createColleagues();

    // 配置する
    add(checkGuest);
    add(checkLogin);
    add(new Label("Username:"));
    add(textUser);
    add(new Label("Password:"));
    add(textPass);
    add(buttonOk);
    add(buttonCancel);

    // 表示
    pack();
    setVisible(true);
  }

  @Override
  public void createColleagues() {
    // Colleagueのインスタンスを生成
    CheckboxGroup g = new CheckboxGroup();
    checkGuest = new ColleagueCheckBox("Guest", g, true);
    checkLogin = new ColleagueCheckBox("Login", g, false);

    // TextFieldのインスタンスを生成
    textUser = new ColleagueTextField("", 10);
    textPass = new ColleagueTextField("", 10);
    textPass.setEchoChar('*');

    // Buttonのインスタンスを生成
    buttonOk = new ColleagueButton("OK");
    buttonCancel = new ColleagueButton("Cancel");

    // Mediatorの設定
    checkGuest.setMediator(this);
    checkLogin.setMediator(this);
    textUser.setMediator(this);
    textPass.setMediator(this);
    buttonOk.setMediator(this);
    buttonCancel.setMediator(this);

    // Listenerの設定
    checkGuest.addItemListener(checkGuest);
    checkLogin.addItemListener(checkLogin);
    textUser.addTextListener(textUser);
    textPass.addTextListener(textPass);
    buttonOk.addActionListener(this);
    buttonCancel.addActionListener(this);
  }

  @Override
  public void colleagueChanged() {
    if (checkGuest.getState()) {
      textUser.setColleagueEnabled(false);
      textPass.setColleagueEnabled(false);
      buttonOk.setColleagueEnabled(true);
    } else {
      textUser.setColleagueEnabled(true);
      userPassChanged();
    }
  }

  private void userPassChanged() {
    if (textUser.getText().length() > 0) {
      textPass.setColleagueEnabled(true);
    } else {
      textPass.setColleagueEnabled(false);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(e.toString());
    if (e.getSource() == buttonOk) {
      System.out.println("OK button pressed.");
    } else {
      System.out.println("Cancel button pressed.");
    }
  }
}