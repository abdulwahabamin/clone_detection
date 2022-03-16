    private void checkAndUpdateWeather() {
        appendLog(context, TAG, "checkAndUpdateWeather");
        if (screenOnOffUpdateService == null) {
            screenOnOffUpdateServiceActions.add("checkAndUpdateWeather");
            bindScreenOnOffService();
            return;
        }
        screenOnOffUpdateService.checkAndUpdateWeather();
    }

