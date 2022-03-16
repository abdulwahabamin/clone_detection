    public static String[] getRainSnowLabelForCombinedGraph(Context context, Locale locale, double multiplier, boolean isRain, boolean isSnow) {
        NumberFormat decimalFormat = NumberFormat.getNumberInstance(locale);
        decimalFormat.setMaximumFractionDigits(1);
        decimalFormat.setMinimumFractionDigits(1);

        int resultSize = 1;
        if (isRain && isSnow) {
            resultSize = 2;
        }
        String[] result = new String[resultSize];
        StringBuilder rainLabelBuilder = new StringBuilder();
        StringBuilder snowLabelBuilder = new StringBuilder();
        if (isRain) {
            rainLabelBuilder.append(context.getString(R.string.graph_rain_label));
        }
        if (isSnow) {
            snowLabelBuilder.append(context.getString(R.string.graph_snow_label));
        }
        if (!isRain && !isSnow) {
            rainLabelBuilder.append(context.getString(R.string.graph_rain_label));
        }

        StringBuilder addInfoLabelBuilder;
        if (isRain && isSnow) {
            addInfoLabelBuilder = snowLabelBuilder;
        } else if (isRain) {
            addInfoLabelBuilder = rainLabelBuilder;
        } else if (isSnow) {
            addInfoLabelBuilder = snowLabelBuilder;
        } else {
            addInfoLabelBuilder = rainLabelBuilder;
        }

        if (multiplier != 1.0) {
            addInfoLabelBuilder.append(" (*");
            addInfoLabelBuilder.append(decimalFormat.format(1 / multiplier));
            addInfoLabelBuilder.append(" ");
            addInfoLabelBuilder.append(context.getString(AppPreference.getRainOrSnowUnit(context)));
            addInfoLabelBuilder.append(" on ");
            addInfoLabelBuilder.append(TemperatureUtil.getTemperatureUnit(context));
            addInfoLabelBuilder.append(")");
        }
        if (isRain && isSnow) {
            result[0] = rainLabelBuilder.toString();
            result[1] = snowLabelBuilder.toString();
        } else if (isRain) {
            result[0] = rainLabelBuilder.toString();
        } else if (isSnow){
            result[0] = snowLabelBuilder.toString();
        } else {
            result[0] = rainLabelBuilder.toString();
        }
        return result;
    }

