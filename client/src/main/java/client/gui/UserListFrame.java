package client.gui;

import client.controller.ClientController;
import lib.model.User;

import javax.swing.*;
import java.util.List;

public class UserListFrame extends JFrame{
    private JList userList;
    private JPanel userFrame;
    private JButton refreshButton;

    private DefaultListModel model;

    public UserListFrame(){

        setContentPane(userFrame);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        model = new DefaultListModel<>();
        userList.setModel(model);

        getUsers();
        refreshButton.addActionListener(
                ev -> {
                    model.clear();
                    getUsers();
                }
        );
    }

    private void getUsers(){
        model.clear();
        ClientController.getInstance().getAllUsers().forEach(u -> model.addElement(u));
    }
}
