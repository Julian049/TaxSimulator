package co.edu.uptc.view;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import co.edu.uptc.model.Constants;

public class CalculateDiscountsLayer extends JPanel {

    private JCheckBox checkEarlyPayment;
    private JCheckBox checkPlaceOfRegistered;
    private JCheckBox checkHybridOrElectric;

    public CalculateDiscountsLayer(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        checkEarlyPayment = new JCheckBox("Pago anticipado");
        checkEarlyPayment.setActionCommand(Constants.EARLY_PAYMENT_VALUE);
        checkEarlyPayment.addActionListener(listener);
        add(checkEarlyPayment);

        checkPlaceOfRegistered = new JCheckBox("Lugar de matricula");
        checkPlaceOfRegistered.setActionCommand(Constants.PLACE_OF_REGISTERED_VALUE);
        checkPlaceOfRegistered.addActionListener(listener);
        add(checkPlaceOfRegistered);

        checkHybridOrElectric = new JCheckBox("Híbrido o eléctrico");
        checkHybridOrElectric.setActionCommand(Constants.HYBRID_OR_ELECTRIC_VALUE);
        checkHybridOrElectric.addActionListener(listener);
        add(checkHybridOrElectric);
    }


    public JCheckBox getCheckEarlyPayment() {
        return checkEarlyPayment;
    }

    public void setCheckEarlyPayment(JCheckBox checkEarlyPayment) {
        this.checkEarlyPayment = checkEarlyPayment;
    }

    public JCheckBox getCheckPlaceOfRegistered() {
        return checkPlaceOfRegistered;
    }

    public void setCheckPlaceOfRegistered(JCheckBox checkPlaceOfRegistered) {
        this.checkPlaceOfRegistered = checkPlaceOfRegistered;
    }

    public JCheckBox getCheckHybridOrElectric() {
        return checkHybridOrElectric;
    }

    public void setCheckHybridOrElectric(JCheckBox checkHybridOrElectric) {
        this.checkHybridOrElectric = checkHybridOrElectric;
    }

}
