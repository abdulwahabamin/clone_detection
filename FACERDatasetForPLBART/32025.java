    public Map<Long, Long> getLongParam(int paramType) {
        SQLiteDatabase db = getReadableDatabase();

        Map<Long, Long> result = new HashMap<>();

        String[] projection = {
                VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_VOICE_SETTING_ID,
                VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_LONG_VALUE
        };

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
                result.put(cursor.getLong(cursor.getColumnIndexOrThrow(VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_VOICE_SETTING_ID)),
                        cursor.getLong(cursor.getColumnIndexOrThrow(VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_PARAM_LONG_VALUE)));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return result;
    }

