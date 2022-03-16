    public void onTtsDeviceEnabledButtonClicked(View view) {

        Long enabledVoiceDevices = voiceSettingParametersDbHelper.getLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_ENABLED_VOICE_DEVICES.getVoiceSettingParamTypeId());
        if (enabledVoiceDevices == null) {
            enabledVoiceDevices = 0l;
        }
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.tts_to_speaker_enabled:
                if (checked) {
                    enabledVoiceDevices += TimeUtils.getTwoPower(2);
                } else {
                    enabledVoiceDevices -= TimeUtils.getTwoPower(2);
                }
                break;
            case R.id.tts_when_wired_enabled:
                if (checked) {
                    enabledVoiceDevices += TimeUtils.getTwoPower(1);
                } else {
                    enabledVoiceDevices -= TimeUtils.getTwoPower(1);
                }
                break;
            case R.id.tts_when_bt_enabled:
                if (checked) {
                    enabledVoiceDevices += TimeUtils.getTwoPower(0);
                    findViewById(R.id.tts_when_bt_enabled_panel).setVisibility(View.VISIBLE);
                    findViewById(R.id.bt_all_devices).setVisibility(View.VISIBLE);
                } else {
                    enabledVoiceDevices -= TimeUtils.getTwoPower(0);
                    findViewById(R.id.tts_when_bt_enabled_panel).setVisibility(View.GONE);
                    findViewById(R.id.bt_all_devices).setVisibility(View.GONE);
                }
                break;
        }
        voiceSettingParametersDbHelper.saveLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_ENABLED_VOICE_DEVICES.getVoiceSettingParamTypeId(),
                enabledVoiceDevices);
    }

