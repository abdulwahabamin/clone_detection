    public static double getDouble(String value) {
        try {
            double i = Double.parseDouble(value);
            return i;
        } catch (Exception e) {
            return 0.00;
        }
    }

