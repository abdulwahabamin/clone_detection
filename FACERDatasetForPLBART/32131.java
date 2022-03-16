    public String getParamString(int widgetId, String paramName) {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                WidgetSettingsContract.WidgetSettings.COLUMN_NAME_PARAM_STRING
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
                return cursor.getString(cursor.getColumnIndexOrThrow(WidgetSettingsContract.WidgetSettings.COLUMN_NAME_PARAM_STRING));
            } else {
                return null;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

