    public void deleteRecordFromTable(Integer id) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            String selection = VoiceSettingParameterContract.VoiceSettingParameters._ID + " = ?";
            String[] selectionArgs = {id.toString()};
            db.delete(VoiceSettingParameterContract.VoiceSettingParameters.TABLE_NAME, selection, selectionArgs);
        } finally {
        }
    }

