    private void populateTtsDeviceEnabled() {
        Long enabledVoiceDevices = voiceSettingParametersDbHelper.getLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_ENABLED_VOICE_DEVICES.getVoiceSettingParamTypeId());
        if (enabledVoiceDevices == null) {
            return;
        }
        if (TimeUtils.isCurrentSettingIndex(enabledVoiceDevices, 2)) {
            ((CheckBox) findViewById(R.id.tts_to_speaker_enabled)).setChecked(true);
        }
        if (TimeUtils.isCurrentSettingIndex(enabledVoiceDevices, 1)) {
            ((CheckBox) findViewById(R.id.tts_when_wired_enabled)).setChecked(true);
        }
        if (TimeUtils.isCurrentSettingIndex(enabledVoiceDevices, 0)) {
            ((CheckBox) findViewById(R.id.tts_when_bt_enabled)).setChecked(true);
        }
    }

