package client.gui;

import client.controller.ClientController;
import lib.dto.CarsDto;
import lib.dto.DealershipDto;
import lib.dto.UserDto;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame{
    private JTextField dealershipNameField;
    private JTextField carNameField;
    private JTextField carPriceField;
    private JButton addButton;
    private JButton showButton;
    private JPanel mainFrame;
    private JTextField userField;
    private JButton showDealershipsButton;
    private JButton showCarsButton;
    private JTextField telefonField;
    private JTextField eMailField;
    private JButton deleteButton;


    public MainFrame(){

        setContentPane(mainFrame);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        dealershipNameField.setToolTipText("Dealership name");
        carNameField.setToolTipText("Car name");
        carPriceField.setToolTipText("Car price");
        userField.setToolTipText("Name");


        addButton.addActionListener(
                ev -> {
                    String userName = userField.getText();
                    String phone = telefonField.getText();
                    String eMail = eMailField.getText();
                    String dealershipName = dealershipNameField.getText();
                    String carName = carNameField.getText();
                    double carPrice = Double.parseDouble(carPriceField.getText());

                    CarsDto carsDto = new CarsDto(0, carName, carPrice);
                    UserDto userDto = new UserDto(0, userName, phone, eMail);
                    DealershipDto dealershipDto = new DealershipDto(0, dealershipName);

                    ClientController.getInstance().addOrder(dealershipDto, carsDto, userDto);
                    JOptionPane.showMessageDialog(null, "New order added");

                    setTextNull();

                }
        );

        showButton.addActionListener(
                ev -> {
                    new UserListFrame();
                }
        );

        showDealershipsButton.addActionListener(
                ev -> {
                    new DealershipListFrame();
                }
        );

        showCarsButton.addActionListener(
                ev -> {
                    new CarsListFrame();
                }
        );


    }

    private void setTextNull(){
        dealershipNameField.setText("");
        carNameField.setText("");
        carPriceField.setText("");
        userField.setText("");
        telefonField.setText("");
        eMailField.setText("");
    }


}
