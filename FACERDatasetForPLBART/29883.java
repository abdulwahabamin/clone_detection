    public void setOthers() {
        try {
            String wind = getString(R.string.wind_ , json.getSpeed() , PreferenceManager.getDefaultSharedPreferences(getContext()).getString(Constants.PREF_TEMPERATURE_UNITS , Constants.METRIC).equals(Constants.IMPERIAL) ? getString(R.string.mph) : getString(R.string.mps));
            windText.setText(wind);
            try {
                rainText.setText(getString(R.string.rain_ , getString(R.string.bottom_rain) , json.getRain()));
            }
            catch (Exception ex) {
                rainText.setText(getString(R.string.rain_ , getString(R.string.bottom_rain) , 0));
            }
            try {
                snowText.setText(getString(R.string.snow_ , json.getSnow() , preferences.getUnits().equals("metric") ? getContext().getString(R.string.mps) : getContext().getString(R.string.mph)));
            }
            catch (Exception ex) {
                snowText.setText(getString(R.string.snow_ , 0 , preferences.getUnits().equals("metric") ? getContext().getString(R.string.mps) : getContext().getString(R.string.mph)));
            }
            humidityText.setText(getString(R.string.humidity , json.getHumidity()));
            pressureText.setText(getString(R.string.pressure , json.getPressure()));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

