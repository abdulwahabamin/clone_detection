    public Boolean getParamBoolean(int widgetId, String paramName) {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                WidgetSettingsContract.WidgetSettings.COLUMN_NAME_PARAM_LONG
        };

        Cursor cursor = null;
        try {
            cursor = db.query(
                    WidgetSettingsContract.WidgetSettings.TABLE_NAME,
                    projection,
                    WidgetSettingsContract.WidgetSettings.COLUMN_NAME_WIDGET_ID + "=" + widgetId +
                            " AND " + WidgetSettingsContract.WidgetSettings.COLUMN_NAME_PARAM_NAME + "=\"" + paramName + "\"",
                    null,
                    null,
                    null,
                    null
            );

            if (cursor.moveToNext()) {
                Long longValue = cursor.getLong(cursor.getColumnIndexOrThrow(WidgetSettingsContract.WidgetSettings.COLUMN_NAME_PARAM_LONG));
                if (longValue == null) {
                    return null;
                } else if (longValue > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return null;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

