package co.edu.uptc.model;

import java.util.ArrayList;

public class Simulator {
    private ArrayList<Brand> brands;
    private ArrayList<Discount> discounts;
    private ArrayList<Range> ranges;

    public Simulator() {
        this.brands = new ArrayList<>();
        this.discounts = new ArrayList<>();
        this.ranges = new ArrayList<>();
    }

    public void addBrand(Brand brand) {
        brands.add(brand);
    }

    public void addLine(String name, Line line) throws ValueNotFoundException {
        boolean brandFound = false;
        for (int i = 0; i < brands.size(); i++) {
            if (brands.get(i).getName().equals(name)) {
                brands.get(i).addLine(line);
                brandFound = true;
                break;
            }
        }

        if (!brandFound) {
            throw new ValueNotFoundException("La marca no existe");
        }
    }

    public void addModel(String nameBrand, String nameLine, Model model) throws ValueNotFoundException {
        boolean brandFound = false;
        boolean lineFound = false;
        for (int i = 0; i < brands.size(); i++) {
            if (brands.get(i).getName().equals(nameBrand)) {
                for (int j = 0; j < brands.get(i).getLines().size(); j++) {
                    if (brands.get(i).getLines().get(j).getName().equals(nameLine)) {

                        brands.get(i).getLines().get(j).addModel(model);

                        lineFound = true;
                        break;
                    }
                }
                brandFound = true;
                break;
            }
        }

        if (!brandFound) {
            throw new ValueNotFoundException("La marca no existe");
        }

        if (!lineFound) {
            throw new ValueNotFoundException("La linea no existe");
        }
    }

    public double extractValue(String brand, String line, int model) {
        double tax = 0;
        for (Brand individualBrand : brands) {
            if (individualBrand.getName().equalsIgnoreCase(brand)) {
                for (Line individualLine : individualBrand.getLines()) {
                    if (individualLine.getName().equalsIgnoreCase(line)) {
                        for (Model individualModel : individualLine.getModels()) {
                            if (individualModel.getYear() == model) {
                                tax = individualModel.getValue();
                            }
                        }
                    }
                }
            }
        }
        return tax;
    }

    public double calculateTax(String brand, String line, int model) {
        double tax = 0;
        double value = extractValue(brand, line, model);
        for (Range range : ranges) {
            if (value > range.getMin() && value < range.getMax()) {
                tax = value * (range.getPercentage() / 100);
                break;
            }
        }
        return tax;
    }

    public double calculateDiscounts(boolean earlyPayment, boolean registeredInBoyacá, boolean hybridOrElectric) {
        double discount = 0;
        if (earlyPayment) {
            discount += (discounts.get(0).getPercentage() / 100);
        }
        if (registeredInBoyacá) {
            discount += (discounts.get(1).getPercentage() / 100);
        }
        if (hybridOrElectric) {
            discount += (discounts.get(2).getPercentage() / 100);
        }
        return discount;
    }

    public Brand verifyBrand(String brand) {
        Brand brandFound = new Brand(brand);
        if (brands != null) {
            for (Brand individualBrand : brands) {
                if (individualBrand.getName().equalsIgnoreCase(brand)) {
                    brandFound = individualBrand;
                    break;
                }
            }
        }
        return brandFound;
    }

    public Line verifyLine(String brand, String line) {
        Line lineFound = new Line(line);
        if (brands.size() > 0) {
            for (Brand individualBrand : brands) {
                if (individualBrand.getName().equalsIgnoreCase(brand)) {
                    for (Line individualLine : individualBrand.getLines()) {
                        if (individualLine.getName().equalsIgnoreCase(line)) {
                            lineFound = individualLine;
                            break;
                        }
                    }
                }
            }
        }
        return lineFound;
    }

    public Model extractModel(String[] price) {
        int year = 1970;
        Model model = null;
        for (int i = 11; i < 66; i++) {
            if (Integer.parseInt(price[i]) != 0) {
                model = new Model(year, (Integer.parseInt(price[i]) * 1000));
                break;
            }
            year++;
        }
        year = 1970;
        return model;
    }

    public String[] splitValues(String value) {
        String[] values = value.split(",");
        return values;
    }

    public void addDiscount(Discount discount) {
        discounts.add(discount);
    }

    public void addRange(Range range) {
        ranges.add(range);
    }

}
