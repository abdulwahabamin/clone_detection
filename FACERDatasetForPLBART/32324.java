    private boolean checkIfWeatherByVoiceServiceIsNotBound() {
        if (weatherByVoiceService != null) {
            return false;
        }
        try {
            bindWeatherByVoiceService();
        } catch (Exception ie) {
            appendLog(getBaseContext(), TAG, "currentWeatherServiceIsNotBound interrupted:", ie);
        }
        return (weatherByVoiceService == null);
    }

