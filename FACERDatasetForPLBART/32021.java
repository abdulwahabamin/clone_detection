    public void saveGeneralStringParam(int paramType, String value) {
        SQLiteDatabase db = getWritableDatabase();

        try {
            ContentValues values = new ContentValues();
            values.put(VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_STRING_VALUE, value);
            if (!dbRecordExists(paramType)) {
                values.put(VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_TYPE_ID, paramType);
                db.insert(VoiceSettingParameterContract.VoiceSettingParameters.TABLE_NAME, null, values);
            } else {
                db.updateWithOnConflict(VoiceSettingParameterContract.VoiceSettingParameters.TABLE_NAME,
                        values,
                        VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_TYPE_ID + "=" + paramType,
                        null,
                        SQLiteDatabase.CONFLICT_IGNORE);
            }
        } finally {
        }
    }

