    public List<Long> getAllSettingIds() {

        List<Long> result = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_VOICE_SETTING_ID
        };

        Cursor cursor = null;
        try {
            cursor = db.query(
                    VoiceSettingParameterContract.VoiceSettingParameters.TABLE_NAME,
                    projection,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            while (cursor.moveToNext()) {
                long voiceSettingId = cursor.getInt(cursor.getColumnIndexOrThrow(VoiceSettingParameterContract.VoiceSettingParameters.COLUMN_NAME_VOICE_SETTING_ID));
                if ((voiceSettingId == 0) || result.contains(voiceSettingId)) {
                    continue;
                }
                result.add(voiceSettingId);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return result;
    }

