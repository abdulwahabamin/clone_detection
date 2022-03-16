    private void updateUVIndexUI() {
        try {
            if (todayWeather.getCountry().isEmpty()) {
                return;
            }
        } catch (Exception e) {
            preloadUVIndex();
            return;
        }

        // UV Index
        double uvIndex = todayWeather.getUvIndex();
        todayUvIndex.setText(getString(R.string.uvindex) + ": " + UnitConvertor.convertUvIndexToRiskLevel(uvIndex, this));
    }

