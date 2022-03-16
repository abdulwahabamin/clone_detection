    public Map<Long, Boolean> getBooleanParam(int paramType) {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_VOICE_SETTING_ID,
                VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_LONG_VALUE
        };

        Map<Long, Boolean> result = new HashMap<>();

        Cursor cursor = null;
        try {
            cursor = db.query(
                    VoiceSettingParameterContract.VoiceSettingParameters.TABLE_NAME,
                    projection,
                    VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_TYPE_ID + "=" + paramType,
                    null,
                    null,
                    null,
                    null
            );

            while (cursor.moveToNext()) {
                long voiceSettingId = cursor.getLong(cursor.getColumnIndexOrThrow(VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_VOICE_SETTING_ID));
                Long longValue = cursor.getLong(cursor.getColumnIndexOrThrow(VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_LONG_VALUE));
                if (longValue == null) {
                    result.put(voiceSettingId, null);
                } else if (longValue > 0) {
                    result.put(voiceSettingId, true);
                } else {
                    result.put(voiceSettingId, false);
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return result;
    }

