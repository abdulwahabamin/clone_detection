    private void createForecastSettingsDialog(final int widgetId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View forecastSettingView = inflater.inflate(R.layout.widget_setting_forecast, null);
        final Switch dayNameSwitch = forecastSettingView.findViewById(R.id.widget_setting_forecast_day_name_switch);

        final WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(this);
        final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(this);

        Long locationId = widgetSettingsDbHelper.getParamLong(widgetId, "locationId");

        Location currentLocation;
        if (locationId == null) {
            currentLocation = locationsDbHelper.getLocationByOrderId(0);
            if (!currentLocation.isEnabled()) {
                currentLocation = locationsDbHelper.getLocationByOrderId(1);
            }
        } else {
            currentLocation = locationsDbHelper.getLocationById(locationId);
        }
        Locale locale = (currentLocation != null)?currentLocation.getLocale(): Locale.getDefault();
        Date dateForSetting = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE", locale);
        final String textOn = sdf.format(dateForSetting);
        dayNameSwitch.setTextOn(textOn);
        sdf = new SimpleDateFormat("EEEE", locale);
        final String textOff = sdf.format(dateForSetting);
        dayNameSwitch.setTextOff(textOff);
        Boolean dayAbbrev = widgetSettingsDbHelper.getParamBoolean(widgetId, "forecast_day_abbrev");
        boolean dayAbbrevChecked = (dayAbbrev != null)?dayAbbrev:false;
        dayNameSwitch.setChecked(dayAbbrevChecked);
        dayNameSwitch.setText(getString(R.string.widget_setting_forecast_day_name_style) + " (" + (dayNameSwitch.isChecked()?textOn:textOff) + ")");
        final DayNameSwitchListener dayNameSwitchListener = new DayNameSwitchListener(dayAbbrevChecked, dayNameSwitch, textOn, textOff);
        dayNameSwitch.setOnCheckedChangeListener(dayNameSwitchListener);

        Spinner numberOfDaysSpinner = forecastSettingView.findViewById(R.id.widget_setting_forecast_number_of_days_hours);
        int predefinedSelection = 0;
        Long storedDays = widgetSettingsDbHelper.getParamLong(widgetId, "forecastDaysCount");
        Boolean hoursForecast = widgetSettingsDbHelper.getParamBoolean(widgetId, "hoursForecast");
        if (hoursForecast == null) {
            hoursForecast = false;
        }
        if (storedDays != null) {
            if (hoursForecast) {
                switch (storedDays.intValue()) {
                    case 3:
                        predefinedSelection = 3;
                        break;
                    case 4:
                        predefinedSelection = 4;
                        break;
                    case 5:
                        predefinedSelection = 5;
                        break;
                }
            } else {
                switch (storedDays.intValue()) {
                    case 3:
                        predefinedSelection = 0;
                        break;
                    case 4:
                        predefinedSelection = 1;
                        break;
                    case 5:
                        predefinedSelection = 2;
                        break;
                }
            }
        } else {
            storedDays = 5l;
        }
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.forecast_number_of_days_hours, android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberOfDaysSpinner.setAdapter(adapter);
        numberOfDaysSpinner.setSelection(predefinedSelection);
        final NumberOfDaysListener numberOfDaysListener = new NumberOfDaysListener(storedDays);
        numberOfDaysSpinner.setOnItemSelectedListener(numberOfDaysListener);

        builder.setView(forecastSettingView)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        widgetSettingsDbHelper.saveParamBoolean(widgetId, "forecast_day_abbrev", dayNameSwitchListener.isChecked());
                        widgetSettingsDbHelper.saveParamLong(widgetId, "forecastDaysCount", numberOfDaysListener.getNumberOfDays());
                        widgetSettingsDbHelper.saveParamBoolean(widgetId, "hoursForecast", numberOfDaysListener.isHoursForecast());
                        Intent intent = new Intent(Constants.ACTION_APPWIDGET_CHANGE_SETTINGS);
                        intent.setPackage("org.thosp.yourlocalweather");
                        intent.putExtra("widgetId", widgetId);
                        sendBroadcast(intent);
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

