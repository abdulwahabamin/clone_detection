    private void createLocationSettingsDialog(final int widgetId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View forecastSettingView = inflater.inflate(R.layout.widget_setting_location, null);

        final WidgetSettingsDbHelper widgetSettingsDbHelper = WidgetSettingsDbHelper.getInstance(this);
        final LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(this);

        Long locationId = widgetSettingsDbHelper.getParamLong(widgetId, "locationId");

        Location currentLocation;
        if (locationId == null) {
            currentLocation = locationsDbHelper.getLocationByOrderId(0);
            if (!currentLocation.isEnabled()) {
                currentLocation = locationsDbHelper.getLocationByOrderId(1);
                if ((currentLocation != null) && currentLocation.isEnabled()) {
                    locationId = currentLocation.getId();
                }
            } else {
                locationId = currentLocation.getId();
            }
        } else {
            currentLocation = locationsDbHelper.getLocationById(locationId);
        }

        if (locationId == null) {
            locationId = 0l;
            currentLocation = locationsDbHelper.getLocationById(locationId);
        }

        List<Location> allLocations = locationsDbHelper.getAllRows();

        List<String> locationLabels = new ArrayList<>();
        for (Location location: allLocations) {
            StringBuilder locationLabel = new StringBuilder();
            locationLabel.append(location.getOrderId());
            if (location.getAddress() != null) {
                locationLabel.append(" - ");
                locationLabel.append(Utils.getCityAndCountryFromAddress(location.getAddress()));
            }
            locationLabels.add(locationLabel.toString());
        }

        Spinner numberOfDaysSpinner = forecastSettingView.findViewById(R.id.widget_setting_location_locations);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, locationLabels);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numberOfDaysSpinner.setAdapter(adapter);
        numberOfDaysSpinner.setSelection(currentLocation.getOrderId());
        final LocationsListener locationListener = new LocationsListener(currentLocation.getOrderId());
        numberOfDaysSpinner.setOnItemSelectedListener(locationListener);

        boolean hasLocationToHide = false;
        AppWidgetManager widgetManager = AppWidgetManager.getInstance(this);
        ComponentName widgetGraphComponent = new ComponentName(this, WeatherGraphWidgetProvider.class);
        int[] graphWidgets = widgetManager.getAppWidgetIds(widgetGraphComponent);
        for (int widgetIdToSearch: graphWidgets) {
            if (widgetIdToSearch == widgetId) {
                hasLocationToHide = true;
                break;
            }
        }
        if (!hasLocationToHide) {
            ComponentName widgetForecastComponent = new ComponentName(this, WeatherForecastWidgetProvider.class);
            int[] forecastWidgets = widgetManager.getAppWidgetIds(widgetForecastComponent);
            for (int widgetIdToSearch: forecastWidgets) {
                if (widgetIdToSearch == widgetId) {
                    hasLocationToHide = true;
                    break;
                }
            }
        }
        final boolean saveLocationSetting = hasLocationToHide;
        final Switch showLocationSwitch = forecastSettingView.findViewById(R.id.widget_setting_show_location);
        Boolean showLocation = widgetSettingsDbHelper.getParamBoolean(widgetId, "showLocation");
        if (showLocation == null) {
            showLocation = false;
        }
        final GraphValuesSwitchListener showLocationSwitchListener = new GraphValuesSwitchListener(showLocation);
        if (hasLocationToHide) {
            showLocationSwitch.setVisibility(View.VISIBLE);
            showLocationSwitch.setChecked(showLocation);
            showLocationSwitch.setOnCheckedChangeListener(showLocationSwitchListener);
        } else {
            showLocationSwitch.setVisibility(View.GONE);
        }

        builder.setView(forecastSettingView)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Location location = locationsDbHelper.getLocationByOrderId(locationListener.getLocationOrderId());
                        widgetSettingsDbHelper.saveParamLong(widgetId, "locationId", location.getId());
                        if (saveLocationSetting) {
                            widgetSettingsDbHelper.saveParamBoolean(widgetId, "showLocation", showLocationSwitchListener.isChecked());
                        }
                        GraphUtils.invalidateGraph();
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

