    public void saveParamBoolean(int widgetId, String paramName, Boolean value) {
        SQLiteDatabase db = getWritableDatabase();

        try {
            Boolean oldValue = getParamBoolean(widgetId, paramName);

            ContentValues values = new ContentValues();
            Long valueToStore;
            if (value == null) {
                valueToStore = null;
            } else if (value) {
                valueToStore = 1l;
            } else {
                valueToStore = 0l;
            }
            values.put(WidgetSettingsContract.WidgetSettings.COLUMN_NAME_PARAM_LONG, valueToStore);
            if (oldValue == null) {
                values.put(WidgetSettingsContract.WidgetSettings.COLUMN_NAME_PARAM_NAME, paramName);
                values.put(WidgetSettingsContract.WidgetSettings.COLUMN_NAME_WIDGET_ID, widgetId);
                db.insert(WidgetSettingsContract.WidgetSettings.TABLE_NAME, null, values);
            } else {
                db.updateWithOnConflict(WidgetSettingsContract.WidgetSettings.TABLE_NAME,
                        values,
                        WidgetSettingsContract.WidgetSettings.COLUMN_NAME_WIDGET_ID + "=" + widgetId +
                                " AND " + WidgetSettingsContract.WidgetSettings.COLUMN_NAME_PARAM_NAME + "=\"" + paramName + "\"",
                        null,
                        SQLiteDatabase.CONFLICT_IGNORE);
            }
        } finally {
        }
    }

