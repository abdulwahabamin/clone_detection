    private void showCombinedGraphSettings() {
        boolean[] checkedItems = new boolean[4];
        for (Integer visibleColumn: combinedGraphValues) {
            checkedItems[visibleColumn] = true;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View forecastSettingView = inflater.inflate(R.layout.activity_setting_graph, null);
        final Switch temperatureSwitch = forecastSettingView.findViewById(R.id.widget_setting_graph_temperatre_switch);
        final Switch rainsnowSwitch = forecastSettingView.findViewById(R.id.widget_setting_graph_rain_switch);
        final Switch windSwitch = forecastSettingView.findViewById(R.id.widget_setting_graph_wind_switch);
        final Switch pressureSwitch = forecastSettingView.findViewById(R.id.widget_setting_graph_pressure_switch);
        temperatureSwitch.setChecked(checkedItems[0]);
        final GraphValuesSwitchListener temperatureSwitchListener = new GraphValuesSwitchListener(checkedItems[0]);
        temperatureSwitch.setOnCheckedChangeListener(temperatureSwitchListener);
        rainsnowSwitch.setChecked(checkedItems[1]);
        final GraphValuesSwitchListener rainsnowSwitchListener = new GraphValuesSwitchListener(checkedItems[1]);
        rainsnowSwitch.setOnCheckedChangeListener(rainsnowSwitchListener);
        windSwitch.setChecked(checkedItems[2]);
        final GraphValuesSwitchListener windSwitchListener = new GraphValuesSwitchListener(checkedItems[2], pressureSwitch);
        windSwitch.setOnCheckedChangeListener(windSwitchListener);
        pressureSwitch.setChecked(checkedItems[3]);
        final GraphValuesSwitchListener pressureSwitchListener = new GraphValuesSwitchListener(checkedItems[3], windSwitch);
        pressureSwitch.setOnCheckedChangeListener(pressureSwitchListener);
        if (windSwitch.isChecked()) {
            pressureSwitch.setEnabled(false);
        } else if (pressureSwitch.isChecked()) {
            windSwitch.setEnabled(false);
        }

        builder.setTitle(R.string.forecast_settings_combined_values)
                .setView(forecastSettingView)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        combinedGraphValues = new HashSet<>();
                        if (temperatureSwitchListener.isChecked()) {
                            combinedGraphValues.add(0);
                        }
                        if (rainsnowSwitchListener.isChecked()) {
                            combinedGraphValues.add(1);
                        }
                        if (windSwitchListener.isChecked()) {
                            combinedGraphValues.add(2);
                        }
                        if (pressureSwitchListener.isChecked()) {
                            combinedGraphValues.add(3);
                        }
                        AppPreference.setCombinedGraphValues(GraphsActivity.this, combinedGraphValues);
                        updateUI();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

