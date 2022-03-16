    public void saveLongParam(Long voiceSettingId, int paramType, long value) {
        SQLiteDatabase db = getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_LONG_VALUE, value);
            if (!dbRecordExists(voiceSettingId, paramType)) {
                values.put(VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_TYPE_ID, paramType);
                values.put(VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_VOICE_SETTING_ID, voiceSettingId);
                db.insert(VoiceSettingParameterContract.VoiceSettingParameters.TABLE_NAME, null, values);
            } else {
                db.updateWithOnConflict(VoiceSettingParameterContract.VoiceSettingParameters.TABLE_NAME,
                        values,
                        VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_VOICE_SETTING_ID + "=" + voiceSettingId +
                        " AND " + VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_TYPE_ID + "=" + paramType,
                        null,
                        SQLiteDatabase.CONFLICT_IGNORE);
            }
        } finally {
        }
    }

