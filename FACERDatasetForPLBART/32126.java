    public void deleteRecordFromTable(Integer widgetId) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            String selection = WidgetSettingsContract.WidgetSettings.COLUMN_NAME_WIDGET_ID + " = ?";
            String[] selectionArgs = {widgetId.toString()};
            db.delete(WidgetSettingsContract.WidgetSettings.TABLE_NAME, selection, selectionArgs);
        } finally {
        }
    }

