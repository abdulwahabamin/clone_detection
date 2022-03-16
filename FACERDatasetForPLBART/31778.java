    @Override
    protected void updateUI() {
        WeatherForecastDbHelper weatherForecastDbHelper = WeatherForecastDbHelper.getInstance(this);
        long locationId = AppPreference.getCurrentLocationId(this);
        currentLocation = locationsDbHelper.getLocationById(locationId);
        if (currentLocation == null) {
            return;
        }
        mValueFormatter = new CustomValueFormatter(currentLocation.getLocale());
        rainSnowYAxisValueFormatter = new RainSnowYAxisValueFormatter(this, currentLocation.getLocale());
        WeatherForecastDbHelper.WeatherForecastRecord weatherForecastRecord = weatherForecastDbHelper.getWeatherForecast(locationId);
        if (weatherForecastRecord != null) {
            weatherForecastList.put(locationId, weatherForecastRecord.getCompleteWeatherForecast().getWeatherForecastList());
            locationWeatherForecastLastUpdate.put(locationId, weatherForecastRecord.getLastUpdatedTime());
        } else if (ForecastUtil.shouldUpdateForecast(this, locationId)) {
            updateWeatherForecastFromNetwork("GRAPHS", GraphsActivity.this);
            return;
        }

        TextView temperatureLabel = (TextView) findViewById(R.id.graphs_temperature_label);
        temperatureLabel.setBackgroundColor(PreferenceUtil.getBackgroundColor(this));
        temperatureLabel.setTextColor(PreferenceUtil.getTextColor(this));
        TextView windLabel = (TextView) findViewById(R.id.graphs_wind_label);
        windLabel.setBackgroundColor(PreferenceUtil.getBackgroundColor(this));
        windLabel.setTextColor(PreferenceUtil.getTextColor(this));
        TextView rainLabel = (TextView) findViewById(R.id.graphs_rain_label);
        rainLabel.setBackgroundColor(PreferenceUtil.getBackgroundColor(this));
        rainLabel.setTextColor(PreferenceUtil.getTextColor(this));
        TextView snowLabel = (TextView) findViewById(R.id.graphs_snow_label);
        snowLabel.setBackgroundColor(PreferenceUtil.getBackgroundColor(this));
        snowLabel.setTextColor(PreferenceUtil.getTextColor(this));
        TextView rainBarLabel = (TextView) findViewById(R.id.graphs_bar_rain_label);
        rainBarLabel.setBackgroundColor(PreferenceUtil.getBackgroundColor(this));
        rainBarLabel.setTextColor(PreferenceUtil.getTextColor(this));
        TextView snowBarLabel = (TextView) findViewById(R.id.graphs_bar_snow_label);
        snowBarLabel.setBackgroundColor(PreferenceUtil.getBackgroundColor(this));
        snowBarLabel.setTextColor(PreferenceUtil.getTextColor(this));

        TextView combinedLabel = (TextView) findViewById(R.id.graphs_combined_label);
        StringBuilder combinedGraphLabel  = new StringBuilder();
        if (combinedGraphValues.contains(0)) {
            combinedGraphLabel.append(getString(R.string.label_temperature));
            combinedGraphLabel.append(" (");
            combinedGraphLabel.append(TemperatureUtil.getTemperatureUnit(this));
            combinedGraphLabel.append(")");
        }
        if (combinedGraphValues.contains(1)) {
            combinedGraphLabel.append(", ");
            combinedGraphLabel.append(getString(R.string.graph_rain_label));
            combinedGraphLabel.append("/");
            combinedGraphLabel.append(getString(R.string.graph_snow_label));
            combinedGraphLabel.append(" (");
            combinedGraphLabel.append(getString(AppPreference.getRainOrSnowUnit(this)));
            combinedGraphLabel.append(")");
        }
        if (combinedGraphValues.contains(2)) {
            combinedGraphLabel.append(", ");
            combinedGraphLabel.append(getString(R.string.label_wind));
            combinedGraphLabel.append(" (");
            combinedGraphLabel.append(AppPreference.getWindUnit(this));
            combinedGraphLabel.append(")");
        }
        if (combinedGraphValues.contains(3)) {
            combinedGraphLabel.append(", ");
            combinedGraphLabel.append(getString(R.string.label_pressure));
            combinedGraphLabel.append(" (");
            combinedGraphLabel.append(AppPreference.getPressureUnit(this));
            combinedGraphLabel.append(")");
        }
        combinedLabel.setText(combinedGraphLabel.toString());

        setCombinedChart(locationId, currentLocation.getLocale());
        setTemperatureChart(locationId, currentLocation.getLocale());
        setWindChart(locationId, currentLocation.getLocale());
        setRainChart(locationId, currentLocation.getLocale());
        setRainBarChart(locationId, currentLocation.getLocale());
        setSnowChart(locationId, currentLocation.getLocale());
        setSnowBarChart(locationId, currentLocation.getLocale());
        setPressureChart(locationId, currentLocation.getLocale());
        localityView.setText(Utils.getCityAndCountry(this, currentLocation.getOrderId()));
    }

