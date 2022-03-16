    private String windFormat(Context context, String wind) {
        if (wind.contains("风")) {
            return wind;
        } else {
            return context.getString(R.string.hourly_forecast_wind, wind);
        }
    }

