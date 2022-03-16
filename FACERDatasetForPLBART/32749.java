    public static Set<Integer> getCombinedGraphValuesFromSettings(Context context, WidgetSettingsDbHelper widgetSettingsDbHelper, int widgetId) {
        Set<Integer> combinedGraphValues = new HashSet<>();

        String storedGraphValues = widgetSettingsDbHelper.getParamString(widgetId, "combinedGraphValues");
        if ((storedGraphValues == null) || !storedGraphValues.contains(",")) {
            combinedGraphValues = AppPreference.getCombinedGraphValues(context);
            StringBuilder valuesToStore = new StringBuilder();
            for (int selectedValue: combinedGraphValues) {
                valuesToStore.append(selectedValue);
                valuesToStore.append(",");
            }
            widgetSettingsDbHelper.saveParamString(widgetId, "combinedGraphValues", valuesToStore.toString());
        } else {
            String[] values = storedGraphValues.split(",");
            for (String value: values) {
                int intValue;
                try {
                    intValue = Integer.parseInt(value);
                    combinedGraphValues.add(intValue);
                } catch (Exception e) {
                    //do nothing, just continue
                }
            }
        }

        return combinedGraphValues;
    }

