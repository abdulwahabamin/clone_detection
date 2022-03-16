    public void saveBooleanParam(Long voiceSettingId, int paramType, Boolean value) {
        SQLiteDatabase db = getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            Long valueToStore;
            if (value == null) {
                valueToStore = null;
            } else if (value) {
                valueToStore = 1l;
            } else {
                valueToStore = 0l;
            }
            values.put(VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_LONG_VALUE, valueToStore);
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

