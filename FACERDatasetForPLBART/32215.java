    private boolean checkIfLocationUpdateServiceIsNotBound() {
        if (locationUpdateService != null) {
            return false;
        }
        try {
            bindLocationUpdateService();
        } catch (Exception ie) {
            appendLog(getBaseContext(), TAG, "currentWeatherServiceIsNotBound interrupted:", ie);
        }
        return (locationUpdateService == null);
    }

