    public static void loadDefaults() {
        //设置SharedPreferences默认值
        try {
            Map<WeatherSettings, Object> defaultPrefs = new HashMap<>();
            WeatherSettings[] values = WeatherSettings.values();
            for (WeatherSettings value : values) {
                defaultPrefs.put(value, value.getDefaultValue());
            }
            savePreferences(defaultPrefs, true);
        } catch (Exception ex) {
            Log.e(TAG, "Save default settings fails", ex);
        }
    }

