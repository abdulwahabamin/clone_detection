    /**
     * Formats and represents the provided {@code double} value.
     *
     * @param d a {@code double} value
     * @return a textual representation of the decimal number with one decimal place
     */
    public static String formatDoubleValue(double d, int decimalPlaces) {
        String pattern;
        switch (decimalPlaces) {
            case 1:
                pattern = "##.#";
                break;
            case 2:
                pattern = "##.##";
                break;
            default:
                throw new IllegalArgumentException("Provide a pattern for " + decimalPlaces +
                        " decimal places!");
        }
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(d);
    }

