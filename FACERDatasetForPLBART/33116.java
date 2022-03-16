    private void createGraphSettingDialog(final int widgetId) {
        final Set<Integer> mSelectedItems = new HashSet<>();
        final WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(WidgetSettingsDialogue.this);
        Set<Integer> combinedGraphValues = GraphUtils.getCombinedGraphValuesFromSettings(this, widgetSettingsDbHelper, widgetId);

        boolean[] checkedItems = new boolean[4];
        for (Integer visibleColumn: combinedGraphValues) {
            mSelectedItems.add(visibleColumn);
            checkedItems[visibleColumn] = true;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View forecastSettingView = inflater.inflate(R.layout.widget_setting_graph, null);
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

        Boolean showLegend = widgetSettingsDbHelper.getParamBoolean(widgetId, "combinedGraphShowLegend");
        if (showLegend == null) {
            showLegend = true;
        }
        final Switch showLegendSwitch = forecastSettingView.findViewById(R.id.widget_setting_graph_show_legend);
        showLegendSwitch.setChecked(showLegend);
        final GraphValuesSwitchListener showLegendSwitchListener = new GraphValuesSwitchListener(showLegend);
        showLegendSwitch.setOnCheckedChangeListener(showLegendSwitchListener);

        builder.setTitle(R.string.forecast_settings_combined_values)
                .setView(forecastSettingView)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        StringBuilder valuesToStore = new StringBuilder();
                        if (temperatureSwitchListener.isChecked()) {
                            valuesToStore.append(0);
                            valuesToStore.append(",");
                        }
                        if (rainsnowSwitchListener.isChecked()) {
                            valuesToStore.append(1);
                            valuesToStore.append(",");
                        }
                        if (windSwitchListener.isChecked()) {
                            valuesToStore.append(2);
                            valuesToStore.append(",");
                        }
                        if (pressureSwitchListener.isChecked()) {
                            valuesToStore.append(3);
                        }

                        widgetSettingsDbHelper.saveParamString(widgetId, "combinedGraphValues", valuesToStore.toString());
                        widgetSettingsDbHelper.saveParamBoolean(widgetId, "combinedGraphShowLegend", showLegendSwitchListener.isChecked());
                        GraphUtils.invalidateGraph();
                        Intent refreshWidgetIntent = new Intent(Constants.ACTION_APPWIDGET_CHANGE_GRAPH_SCALE);
                        refreshWidgetIntent.setPackage("org.thosp.yourlocalweather");
                        sendBroadcast(refreshWidgetIntent);
                        finish();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

