    private void createDetailsSettingsDialog(final int widgetId) {
        final Set<Integer> mSelectedItems = new HashSet<>();
        final WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(WidgetSettingsDialogue.this);

        WidgetDefaultDetailsResult currentWeatherDetailsAvailableInWidget = getNumberOfCurrentWeatherDetails(widgetId);

        Set<Integer> currentWeatherDetailValues = WidgetUtils.getCurrentWeatherDetailsFromSettings(
                widgetSettingsDbHelper,
                widgetId,
                currentWeatherDetailsAvailableInWidget.getDefaultDetails());

        boolean[] checkedItems = new boolean[NUMBER_OF_WEATHER_DETAIL_OPTIONS];
        for (Integer visibleDetail: currentWeatherDetailValues) {
            mSelectedItems.add(visibleDetail);
            checkedItems[visibleDetail] = true;
        }

        boolean fullSetOfOptions = currentWeatherDetailValues.size() >= currentWeatherDetailsAvailableInWidget.getMaxNumberOfDetails();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View forecastSettingView = inflater.inflate(R.layout.widget_setting_weather_detail, null);
        Switch[] switches = new Switch[NUMBER_OF_WEATHER_DETAIL_OPTIONS];
        final CurrentWeatherDetailSwitchListener[] switchListeners = new CurrentWeatherDetailSwitchListener[NUMBER_OF_WEATHER_DETAIL_OPTIONS];
        switches[0] = forecastSettingView.findViewById(R.id.widget_setting_weather_detail_wind_switch);
        switches[1] = forecastSettingView.findViewById(R.id.widget_setting_weather_detail_humidity_switch);
        switches[2] = forecastSettingView.findViewById(R.id.widget_setting_weather_detail_pressure_switch);
        switches[3] = forecastSettingView.findViewById(R.id.widget_setting_weather_detail_cloudiness_switch);
        switches[4] = forecastSettingView.findViewById(R.id.widget_setting_weather_detail_dew_point_switch);
        switches[5] = forecastSettingView.findViewById(R.id.widget_setting_weather_detail_sunrise_switch);
        switches[6] = forecastSettingView.findViewById(R.id.widget_setting_weather_detail_sunset_switch);
        for (int i = 0; i < NUMBER_OF_WEATHER_DETAIL_OPTIONS; i++) {
            if (!checkedItems[i] && fullSetOfOptions) {
                switches[i].setEnabled(false);
            } else {
                switches[i].setEnabled(true);
            }
            switches[i].setChecked(checkedItems[i]);
            switchListeners[i] = new CurrentWeatherDetailSwitchListener(
                    checkedItems[i],
                    switches,
                    i,
                    currentWeatherDetailsAvailableInWidget.getMaxNumberOfDetails());
            switches[i].setOnCheckedChangeListener(switchListeners[i]);
        }
        
        builder.setTitle(R.string.widget_details_setting_button)
                .setView(forecastSettingView)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        StringBuilder valuesToStore = new StringBuilder();

                        for (int i = 0; i < NUMBER_OF_WEATHER_DETAIL_OPTIONS; i++) {
                            if (switchListeners[i].isChecked()) {
                                valuesToStore.append(i);
                                valuesToStore.append(",");
                            }
                        }

                        widgetSettingsDbHelper.saveParamString(widgetId, "currentWeatherDetails", valuesToStore.toString());

                        Intent refreshWidgetIntent = new Intent(Constants.ACTION_FORCED_APPWIDGET_UPDATE);
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

