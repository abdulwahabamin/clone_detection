    public RainSnowYAxisValueFormatter(Context context, Locale locale) {
        decimalFormat = NumberFormat.getNumberInstance(locale);
        int numberOfDecimalPlaces = AppPreference.getGraphFormatterForRainOrSnow(context);
        decimalFormat.setMaximumFractionDigits(numberOfDecimalPlaces);
        decimalFormat.setMinimumFractionDigits(numberOfDecimalPlaces);
    }

