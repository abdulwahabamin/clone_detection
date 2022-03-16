    public static String convertUvIndexToRiskLevel(double value, Context context) {
        /* based on: https://en.wikipedia.org/wiki/Ultraviolet_index */
        if (value < 0) {
            return context.getString(R.string.uvi_no_info);
        } else if (value >= 0.0 && value < 3.0) {
            return context.getString(R.string.uvi_low);
        } else if (value >= 3.0 && value < 6.0) {
            return context.getString(R.string.uvi_moderate);
        } else if (value >= 6.0 && value < 8.0) {
            return context.getString(R.string.uvi_high);
        } else if (value >= 8.0 && value < 11.0) {
            return context.getString(R.string.uvi_very_high);
        } else {
            return context.getString(R.string.uvi_extreme);
        }
    }

