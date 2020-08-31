package client.gui;

import client.controller.ClientController;

import javax.swing.*;

public class DealershipListFrame extends JFrame{
    private JPanel dealershipFrame;
    private JList dealershipList;
    private JButton refreshButton;

    private DefaultListModel model;

    public DealershipListFrame(){
        setContentPane(dealershipFrame);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        model = new DefaultListModel<>();
        dealershipList.setModel(model);
        getDealerships();
        refreshButton.addActionListener(
                ev -> {
                    model.clear();
                    getDealerships();
                }
        );
    }

    private void getDealerships(){
        model.clear();
        ClientController.getInstance().getDealerships().forEach(d -> model.addElement(d));
    }
}
