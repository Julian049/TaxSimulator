package co.edu.uptc.view;


import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.model.Constants;

public class ActionButtonsLayer extends JPanel {

    private JButton btnClean;
    private JButton btnLiquidate;
    private JLabel result;
    private JTextField errorMessage;

    public ActionButtonsLayer(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new FlowLayout());

        result = new JLabel("Resultado: ");
        add(result);

        btnLiquidate = new JButton("Liquidar");
        btnLiquidate.setActionCommand(Constants.LIQUIDATE_BUTTON);
        btnLiquidate.addActionListener(listener);
        add(btnLiquidate);

        btnClean = new JButton("Limpiar");
        btnClean.setActionCommand(Constants.CLEAN_ALL_BUTTON);
        btnClean.addActionListener(listener);
        add(btnClean);
    }

    public JButton getBtnClean() {
        return btnClean;
    }



    public JButton getBtnLiquidate() {
        return btnLiquidate;
    }



    public JLabel getTxtResult() {
        return result;
    }



    public JTextField getTxtErrorMessage() {
        return errorMessage;
    }


}

