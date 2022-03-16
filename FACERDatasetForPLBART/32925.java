    public static Set<Integer> getCurrentWeatherDetailsFromSettings(
            WidgetSettingsDbHelper widgetSettingsDbHelper,
            int widgetId,
            String defaultSetting) {
        Set<Integer> currentWeatherDetails = new HashSet<>();

        String storedCurrentWeatherDetails = widgetSettingsDbHelper.getParamString(widgetId, "currentWeatherDetails");
        if (storedCurrentWeatherDetails == null) {
            storedCurrentWeatherDetails = defaultSetting;
        }
        String[] values = storedCurrentWeatherDetails.split(",");
        for (String value: values) {
            int intValue;
            try {
                intValue = Integer.parseInt(value);
                currentWeatherDetails.add(intValue);
            } catch (Exception e) {
                //do nothing, just continue
            }
        }

        return currentWeatherDetails;
    }

