    private boolean dbRecordExists(int paramType) {
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                VoiceSettingParameterContract.VoiceSettingParameters._ID
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

            return cursor.moveToNext();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

