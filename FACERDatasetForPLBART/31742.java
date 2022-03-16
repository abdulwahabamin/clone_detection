    private boolean checkIfWeatherForecastServiceIsNotBound() {
        if (weatherForecastService != null) {
            return false;
        }
        try {
            bindWeatherForecastService();
        } catch (Exception ie) {
            appendLog(getBaseContext(), TAG, "weatherForecastServiceIsNotBound interrupted:", ie);
        }
        return (weatherForecastService == null);
    }

