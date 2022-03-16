    public VoiceSettingParameter(PersistableBundle persistentBundle) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            id = persistentBundle.getLong("id");
            voiceSettingId = persistentBundle.getLong("voiceSettingId");
            paramTypeId = persistentBundle.getInt("paramTypeId");
            paramBooleanValue = mapIntToBoolean(persistentBundle.getInt("paramBooleanValue"));
            paramLongValue = persistentBundle.getLong("paramLongValue");
            paramStringValue = persistentBundle.getString("paramStringValue");
        }
    }

