package client.gui;

import client.controller.ClientController;

import javax.swing.*;

public class CarsListFrame extends JFrame{
    private JPanel carsFrame;
    private JList carsList;
    private JButton refreshButton;

    private DefaultListModel model;

    public CarsListFrame(){
        setContentPane(carsFrame);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        model = new DefaultListModel<>();
        carsList.setModel(model);
        showCars();
        refreshButton.addActionListener(
                ev -> {
                    model.clear();
                    showCars();
                }
        );
    }

    private void showCars(){
        ClientController.getInstance().getCars().forEach(c -> model.addElement(c));
    }
}
