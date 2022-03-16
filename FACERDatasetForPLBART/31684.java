    public void onAllBtDevicesButtonClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        voiceSettingParametersDbHelper.saveBooleanParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_ENABLED_WHEN_BT_DEVICES.getVoiceSettingParamTypeId(),
                checked);
        if (checked) {
            findViewById(R.id.bt_when_devices).setVisibility(View.GONE);
        } else {
            findViewById(R.id.bt_when_devices).setVisibility(View.VISIBLE);
        }
    }

