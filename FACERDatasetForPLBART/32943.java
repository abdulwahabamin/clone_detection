    public YAxisValueFormatter(Locale locale, int fractionalDigits, String unit) {
        this.unit = unit;
        decimalFormat = NumberFormat.getNumberInstance(locale);
        decimalFormat.setMaximumFractionDigits(fractionalDigits);
        decimalFormat.setMinimumFractionDigits(fractionalDigits);
    }

