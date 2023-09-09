    public double calculateTax(String brand, String line, int model) {
    double tax = 0;
    if (extractValue(brand, line, model) > ranges.get(0).getMin()
    && extractValue(brand, line, model) < ranges.get(0).getMax()) {
    tax = (this.extractValue(brand, line, model) *
    (ranges.get(0).getPercentage()/100));
    } else if (extractValue(brand, line, model) > ranges.get(1).getMin()
    && extractValue(brand, line, model) < ranges.get(1).getMax()) {
    tax = (this.extractValue(brand, line, model) *
    (ranges.get(1).getPercentage()/100));

    } else if (extractValue(brand, line, model) > ranges.get(2).getMin()
    && extractValue(brand, line, model) < ranges.get(2).getMax()) {
    tax = (this.extractValue(brand, line, model) *
    (ranges.get(2).getPercentage()/100));
    }
    return tax;
    }


    public String[][] getDiscounts(String discount1, String discount2, String
    discount3) {
    String[][] discounts = new String[3][3];
    discounts[0][0] = discount1.split(",")[0];
    discounts[0][1] = discount1.split(",")[1];
    discounts[0][2] = discount1.split(",")[2];
    discounts[1][0] = discount2.split(",")[0];
    discounts[1][1] = discount2.split(",")[1];
    discounts[1][2] = discount2.split(",")[2];
    discounts[2][0] = discount3.split(",")[0];
    discounts[2][1] = discount3.split(",")[1];
    discounts[2][2] = discount3.split(",")[2];
    return discounts;
    }

    public String[][] getRanges(String range1, String range2, String range3) {
    String[][] ranges = new String[3][2];
    ranges[0][0] = range1.split(",")[0];
    ranges[0][1] = range1.split(",")[1];
    ranges[1][0] = range2.split(",")[0];
    ranges[1][1] = range2.split(",")[1];
    ranges[2][0] = range3.split(",")[0];
    ranges[2][1] = range3.split(",")[1];
    return ranges;
    }

    public void addModel(String nameBrand, String nameLine, Model model) throws ValueNotFoundException {
        for (int i = 0; i < brands.size(); i++) {
            if (brands.get(i).getName().equals(nameBrand)) {
                for (int j = 0; j < brands.get(i).getLines().size(); j++) {
                    if (brands.get(i).getLines().get(j).getName().equals(nameLine)) {
                        brands.get(i).getLines().get(j).addModel(model);
                    } else
                        throw new ValueNotFoundException("La linea no existe");
                }
            } else
                throw new ValueNotFoundException("La marca no existe");
        }
    }

    public void addLine(String name, Line line) throws ValueNotFoundException {
        for (int i = 0; i < brands.size(); i++) {
            if (brands.get(i).getName().equals(name)) {
                brands.get(i).addLine(line);
            } else
                throw new ValueNotFoundException("La marca no existe");
        }
    }