    public void saveParamLong(int widgetId, String paramName, long value) {
        SQLiteDatabase db = getWritableDatabase();

        try {
            Long oldValue = getParamLong(widgetId, paramName);

            ContentValues values = new ContentValues();
            values.put(WidgetSettingsContract.WidgetSettings.COLUMN_NAME_PARAM_LONG, value);
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

