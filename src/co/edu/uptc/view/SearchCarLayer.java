package co.edu.uptc.view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.model.Constants;

public class SearchCarLayer extends JPanel {
    private JLabel lblSearchBrand;
    private JLabel lblSearchLine;
    private JLabel lblSearchModel;
    private JLabel lblPrice;

    private JTextField btnSearchBrand;
    private JTextField btnSearchLine;
    private JTextField btnSearchModel;

    private JButton btnSearch;
    private JButton btnClean;

    public SearchCarLayer(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        lblSearchBrand = new JLabel("Marca");
        add(lblSearchBrand);

        btnSearchBrand = new JTextField(15);
        btnSearchBrand.setActionCommand(Constants.SEARCH_BRAND_VALUE);
        btnSearchBrand.addActionListener(listener);
        add(btnSearchBrand);

        lblSearchLine = new JLabel("Linea");
        add(lblSearchLine);

        btnSearchLine = new JTextField();
        btnSearchLine.setColumns(15);
        btnSearchLine.setActionCommand(Constants.SEARCH_LINE_VALUE);
        btnSearchLine.addActionListener(listener);
        add(btnSearchLine);

        lblSearchModel = new JLabel("Modelo");
        add(lblSearchModel);

        btnSearchModel = new JTextField();
        btnSearchModel.setColumns(15);
        btnSearchModel.setActionCommand(Constants.SEARCH_MODEL_VALUE);
        btnSearchModel.addActionListener(listener);
        add(btnSearchModel);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        btnSearch = new JButton("Buscar");
        btnSearch.setActionCommand(Constants.SEARCH_BUTTON);
        btnSearch.addActionListener(listener);
        buttonPanel.add(btnSearch);

        btnClean = new JButton("Limpiar");
        btnClean.setActionCommand(Constants.CLEAN_CAR_BUTTON);
        btnClean.addActionListener(listener);
        buttonPanel.add(btnClean);

        lblPrice = new JLabel("Precio: ");
        buttonPanel.add(lblPrice);
        add(buttonPanel);

    }

    public JLabel getLblSearchBrand() {
        return lblSearchBrand;
    }

    public void setLblSearchBrand(JLabel lblSearchBrand) {
        this.lblSearchBrand = lblSearchBrand;
    }

    public JLabel getLblSearchLine() {
        return lblSearchLine;
    }

    public void setLblSearchLine(JLabel lblSearchLine) {
        this.lblSearchLine = lblSearchLine;
    }

    public JLabel getLblSearchModel() {
        return lblSearchModel;
    }

    public void setLblSearchModel(JLabel lblSearchModel) {
        this.lblSearchModel = lblSearchModel;
    }

    public JLabel getLblPrice() {
        return lblPrice;
    }

    public void setLblPrice(JLabel lblPrice) {
        this.lblPrice = lblPrice;
    }

    public JTextField getBtnSearchBrand() {
        return btnSearchBrand;
    }

    public void setBtnSearchBrand(JTextField btnSearchBrand) {
        this.btnSearchBrand = btnSearchBrand;
    }

    public JTextField getBtnSearchLine() {
        return btnSearchLine;
    }

    public void setBtnSearchLine(JTextField btnSearchLine) {
        this.btnSearchLine = btnSearchLine;
    }

    public JTextField getBtnSearchModel() {
        return btnSearchModel;
    }

    public void setBtnSearchModel(JTextField btnSearchModel) {
        this.btnSearchModel = btnSearchModel;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(JButton btnSearch) {
        this.btnSearch = btnSearch;
    }

    public JButton getBtnClean() {
        return btnClean;
    }

    public void setBtnClean(JButton btnClean) {
        this.btnClean = btnClean;
    }

}
