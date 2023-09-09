package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;


import co.edu.uptc.model.Brand;
import co.edu.uptc.model.Constants;
import co.edu.uptc.model.Discount;
import co.edu.uptc.model.Line;
import co.edu.uptc.model.Range;
import co.edu.uptc.model.Simulator;
import co.edu.uptc.model.ValueNotFoundException;
import co.edu.uptc.view.SimulatorView;
import co.edu.uptc.persistence.Persistence;

public class Presenter implements ActionListener {

	private Simulator simulator;
	private SimulatorView simulatorView;

	public Presenter() {
		simulator = new Simulator();
		simulatorView = new SimulatorView(this);
	}

	public void run() {
		try {
			loadFile("data/Guia_CSV_324.csv");
		} catch (IOException e) {
			simulatorView.showErrorMessage(e.getMessage());
		}
		loadData();
	}

	public void actionPerformed(ActionEvent action) {
		this.carsManagerLayer(action);
		this.discountsManagerLayer(action);
		this.actionLayer(action);
	}

	// public void addBrand() {
	// // String name = simulatorView.read("Ingrese el nombre de la marca: ");
	// // Brand brand = new Brand(name);
	// // simulator.addBrand(brand);
	// }

	// public void addLine() {
	// // try {
	// // String nameBrand = simulatorView.read("Ingrese el nombre de la marca donde
	// // quiere añadir la linea: ");
	// // String name = simulatorView.read("Ingrese el nombre de la linea: ");
	// // Line line = new Line(name);
	// // simulator.addLine(nameBrand, line);
	// // } catch (ValueNotFoundException e) {
	// // simulatorView.showErrorMessage(e.getMessage());
	// // }
	// }

	// public void addModel() {
	// // try {
	// // String nameBrand = simulatorView.read("Ingrese el nombre de la marca donde
	// // quiere añadir el modelo: ");
	// // String nameLine = simulatorView.read("Ingrese el nombre de la linea donde
	// // quiere añadir el modelo: ");
	// // int name = Integer.parseInt(simulatorView.read("Ingrese el año del modelo:
	// // "));
	// // int price = Integer.parseInt(simulatorView.read("Ingrese el precio del
	// // modelo: "));
	// // Model model = new Model(name, price);
	// // simulator.addModel(nameBrand, nameLine, model);
	// // } catch (Exception e) {
	// // simulatorView.showErrorMessage(e.getMessage());
	// // }
	// }

	public Brand carsManagerLayer(ActionEvent action) {
		Brand brand = null;
		Object actionCommand = action.getActionCommand();
		String nameBrand = simulatorView.getBrandValue();
		String nameLine = simulatorView.getLineValue();
		int nameModel = Integer.parseInt(simulatorView.getModelValue());
		if (actionCommand.equals(Constants.SEARCH_BUTTON)) {
			simulatorView.updatePrice(simulator.extractValue(nameBrand, nameLine, nameModel) + "");
		}else if (actionCommand.equals(Constants.CLEAN_CAR_BUTTON)) {
			simulatorView.cleanSearchFilter();
		}
		return brand;
	}

	public double discountsManagerLayer(ActionEvent action) {
		boolean earlyPayment = simulatorView.earlyPayment();
		boolean registeredInBoyaca = simulatorView.placeOfRegistered();
		boolean hybridOrElectric = simulatorView.hybridOrElectric();
		Object actionCommand = action.getActionCommand();
	
		if (actionCommand.equals(Constants.EARLY_PAYMENT_VALUE)) {
			earlyPayment = !earlyPayment; 
		} else if (actionCommand.equals(Constants.PLACE_OF_REGISTERED_VALUE)) {
			registeredInBoyaca = !registeredInBoyaca;
		} else if (actionCommand.equals(Constants.HYBRID_OR_ELECTRIC_VALUE)) {
			hybridOrElectric = !hybridOrElectric;
		}
		return simulator.calculateDiscounts(earlyPayment, registeredInBoyaca, hybridOrElectric);
	}
	

	public void actionLayer(ActionEvent action) {
		Object actionCommand = action.getActionCommand();
		String nameBrand = simulatorView.getBrandValue();
		String nameLine = simulatorView.getLineValue();
		int nameModel = Integer.parseInt(simulatorView.getModelValue());
		if (actionCommand.equals(Constants.LIQUIDATE_BUTTON)) {
			double discounts = discountsManagerLayer(action);
			double tax = simulator.calculateTax(nameBrand, nameLine, nameModel);
			double finalTax = tax - (tax * discounts);
			simulatorView.updateResult(finalTax + "");
		}else if (actionCommand.equals(Constants.CLEAN_ALL_BUTTON)) {
			simulatorView.cleanAll();
		}
	}

	public void loadFile(String fileName) throws IOException {
		try {
			ArrayList<String> lines = new Persistence(fileName).loadFile();
			for (int i = 1; i < lines.size(); i++) {
				String line = lines.get(i);
				String[] values = simulator.splitValues(line);
				try {
					String brandWithoutQuotes = values[1].substring(1, values[1].length() - 1);
					String lineWithoutQuotes = values[5].substring(1, values[5].length() - 1);
					Brand addBrand = simulator.verifyBrand(brandWithoutQuotes);
					Line addLine = simulator.verifyLine(brandWithoutQuotes, lineWithoutQuotes);
					simulator.addBrand(addBrand);
					simulator.addLine(brandWithoutQuotes, addLine);
					simulator.addModel(brandWithoutQuotes, lineWithoutQuotes, simulator.extractModel(values));
				} catch (ValueNotFoundException e) {
					simulatorView.showErrorMessage(e.getMessage());
				}
			}
		} catch (IOException e) {
			simulatorView.showErrorMessage(e.getMessage());
		}
	}

	public void loadData() {
		Properties file = new Properties();
		try {
			file.load(new FileReader("config.properties"));
		} catch (FileNotFoundException e) {
			simulatorView.showErrorMessage(e.getMessage());
		} catch (IOException e) {
			simulatorView.showErrorMessage(e.getMessage());
		}

		String range1 = file.getProperty("range1");
		String range2 = file.getProperty("range2");
		String range3 = file.getProperty("range3");
		String discount1 = file.getProperty("discount1");
		String discount2 = file.getProperty("discount2");
		String discount3 = file.getProperty("discount3");

		simulator.addRange(new Range(Float.parseFloat(simulator.splitValues(range1)[0]),
				Integer.parseInt(simulator.splitValues(range1)[1]),
				Integer.parseInt(simulator.splitValues(range1)[2])));
		simulator.addRange(new Range(Float.parseFloat(simulator.splitValues(range2)[0]),
				Integer.parseInt(simulator.splitValues(range2)[1]),
				Integer.parseInt(simulator.splitValues(range2)[2])));
		simulator.addRange(new Range(Float.parseFloat(simulator.splitValues(range3)[0]),
				Integer.parseInt(simulator.splitValues(range3)[1]),
				Integer.parseInt(simulator.splitValues(range3)[2])));
		simulator.addDiscount(new Discount(simulator.splitValues(discount1)[0],
				Float.parseFloat(simulator.splitValues(discount1)[1])));
		simulator.addDiscount(new Discount(simulator.splitValues(discount2)[0],
				Float.parseFloat(simulator.splitValues(discount2)[1])));
		simulator.addDiscount(new Discount(simulator.splitValues(discount3)[0],
				Float.parseFloat(simulator.splitValues(discount3)[1])));
	}

	public static void main(String[] args) {
		Presenter presenter = new Presenter();
		presenter.run();
	}
}
