    public Boolean getBooleanParam(Long voiceSettingId, int paramType) {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_LONG_VALUE
        };

        Cursor cursor = null;
        try {
            cursor = db.query(
                    VoiceSettingParameterContract.VoiceSettingParameters.TABLE_NAME,
                    projection,
                    VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_VOICE_SETTING_ID + "=" + voiceSettingId +
                            " AND " + VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_TYPE_ID + "=" + paramType,
                    null,
                    null,
                    null,
                    null
            );

            if (cursor.moveToNext()) {
                Long longValue = cursor.getLong(cursor.getColumnIndexOrThrow(VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_LONG_VALUE));
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

