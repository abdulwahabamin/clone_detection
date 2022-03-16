    public void deleteAllSettings(Long voiceSettingId) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            String selection = VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_VOICE_SETTING_ID + " = ?";
            String[] selectionArgs = {voiceSettingId.toString()};
            db.delete(VoiceSettingParameterContract.VoiceSettingParameters.TABLE_NAME, selection, selectionArgs);
        } finally {
        }
    }

