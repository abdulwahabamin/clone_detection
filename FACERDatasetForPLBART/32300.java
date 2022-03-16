    private boolean checkIfWeatherByVoiceServiceIsNotBound(Context context) {
        if (weatherByVoiceService != null) {
            return false;
        }
        try {
            bindWeatherByVoiceService(context);
        } catch (Exception ie) {
            appendLog(context, TAG, "currentWeatherServiceIsNotBound interrupted:", ie);
        }
        return (weatherByVoiceService == null);
    }

