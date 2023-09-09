package co.edu.uptc.view;


import java.awt.event.ActionListener;


import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SimulatorView extends JFrame {

	private SearchCarLayer searchCarLayer;
	private CalculateDiscountsLayer calculateDiscountsLayer;
	private ActionButtonsLayer actionButtonsLayer;

	public SimulatorView(ActionListener listener) {
		super("Calculadora de impuestos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 420);
		initComponents(listener);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void initComponents(ActionListener listener) {
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	
		searchCarLayer = new SearchCarLayer(listener);
		calculateDiscountsLayer = new CalculateDiscountsLayer(listener);
		actionButtonsLayer = new ActionButtonsLayer(listener);
	
		add(searchCarLayer);
		add(calculateDiscountsLayer);
		add(actionButtonsLayer);
	}
	

	public void cleanSearchFilter() {
		searchCarLayer.getBtnSearchBrand().setText("");
		searchCarLayer.getBtnSearchLine().setText("");
		searchCarLayer.getBtnSearchModel().setText("");
	}

	public void cleanAll() {
		cleanSearchFilter();
		searchCarLayer.getLblPrice().setText("Precio: ");
		calculateDiscountsLayer.getCheckEarlyPayment().setSelected(false);
		calculateDiscountsLayer.getCheckPlaceOfRegistered().setSelected(false);
		calculateDiscountsLayer.getCheckHybridOrElectric().setSelected(false);
		actionButtonsLayer.getTxtResult().setText("El impuesto del carro es: : ");
	}

	public void updatePrice(String price) {
		searchCarLayer.getLblPrice().setText("Precio: "+price);
	}

	public void showErrorMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
	}

	public boolean earlyPayment() {
		return calculateDiscountsLayer.getCheckEarlyPayment().isSelected();
	}

	public boolean placeOfRegistered() {
		return calculateDiscountsLayer.getCheckPlaceOfRegistered().isSelected();
	}

	public boolean hybridOrElectric() {
		return calculateDiscountsLayer.getCheckHybridOrElectric().isSelected();
	}

	public void updateResult(String result) {
		actionButtonsLayer.getTxtResult().setText("El impuesto del carro es: : "+result);
	}

	public String getBrandValue() {
		return searchCarLayer.getBtnSearchBrand().getText();
	}
	
	public String getLineValue() {
		return searchCarLayer.getBtnSearchLine().getText();
	}
	
	public String getModelValue() {
		return searchCarLayer.getBtnSearchModel().getText();
	}

	public boolean isEarlyPayment() {
		return calculateDiscountsLayer.getCheckEarlyPayment().isSelected();
	}

	public boolean isPlaceOfRegistered() {
		return calculateDiscountsLayer.getCheckPlaceOfRegistered().isSelected();
	}

	public boolean isHybridOrElectric() {
		return calculateDiscountsLayer.getCheckHybridOrElectric().isSelected();
	}
}