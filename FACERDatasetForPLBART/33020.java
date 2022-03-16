    private boolean checkIfCurrentWeatherServiceIsNotBound(Context context) {
        if (currentWeatherService != null) {
            return false;
        }
        try {
            bindCurrentWeatherService(context);
        } catch (Exception ie) {
            appendLog(context, TAG, "currentWeatherServiceIsNotBound interrupted:", ie);
        }
        return (currentWeatherService == null);
    }

