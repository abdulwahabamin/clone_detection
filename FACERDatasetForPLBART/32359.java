    private void startLocationAndWeatherUpdate(Intent intent) {
        appendLog(getBaseContext(), TAG, "startLocationAndWeatherUpdate:", intent);
        if (intent.getExtras() == null) {
            return;
        }
        this.updateSource = intent.getStringExtra("updateSource");
        this.forceUpdate = intent.getBooleanExtra("forceUpdate", false);
        processLocationAndWeatherUpdate(intent);
    }

