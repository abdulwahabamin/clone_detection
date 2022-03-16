    public void onTriggerAllBtDevicesButtonClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        voiceSettingParametersDbHelper.saveBooleanParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_TRIGGER_ENABLED_BT_DEVICES.getVoiceSettingParamTypeId(),
                checked);
        if (checked) {
            findViewById(R.id.trigger_bt_when_devices).setVisibility(View.GONE);
        } else {
            findViewById(R.id.trigger_bt_when_devices).setVisibility(View.VISIBLE);
        }
    }

