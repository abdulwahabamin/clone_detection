    private void updateItemsFromDb() {
        voiceSettingId = getIntent().getLongExtra("voiceSettingId", 0);
        setTextTime();
        populateDayOfWeeks();
        populateTtsDeviceEnabled();
        populateTtsSeySetting();
        populateTextes();
        populateTriggerBtDevices(R.id.trigger_bt_when_devices, R.id.trigger_bt_all_devices, VoiceSettingParamType.VOICE_SETTING_TRIGGER_ENABLED_BT_DEVICES);
        populateBtDevices(R.id.bt_when_devices, R.id.bt_all_devices, VoiceSettingParamType.VOICE_SETTING_ENABLED_WHEN_BT_DEVICES);
        populateLocations();
    }

