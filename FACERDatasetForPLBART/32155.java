    private void writeCurrentSetting() {
        StringBuilder selectedBtDevices = new StringBuilder();
        for (int i = 0; i < selection.length; i++) {
            if (selection[i]) {
                selectedBtDevices.append(items.get(i).getAddress());
                selectedBtDevices.append(",");
            }
        }
        String selectedBtDevicesString = selectedBtDevices.toString();
        appendLog(getContext(), TAG, "writeCurrentSetting: voiceSettingId=", voiceSettingId, ", selectedBtDevicesString=", selectedBtDevicesString);
        VoiceSettingParametersDbHelper voiceSettingParametersDbHelper = VoiceSettingParametersDbHelper.getInstance(getContext());
        voiceSettingParametersDbHelper.saveStringParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_ENABLED_WHEN_BT_DEVICES.getVoiceSettingParamTypeId(),
                selectedBtDevicesString);
        appendLog(getContext(), TAG, "writeCurrentSetting saved");
    }

