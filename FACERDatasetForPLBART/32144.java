    private void writeCurrentSetting() {
        StringBuilder selectedBtDevices = new StringBuilder();
        for (int i = 0; i < selection.length; i++) {
            if (selection[i]) {
                selectedBtDevices.append(items.get(i).getId());
                selectedBtDevices.append(",");
            }
        }
        VoiceSettingParametersDbHelper voiceSettingParametersDbHelper = VoiceSettingParametersDbHelper.getInstance(getContext());
        voiceSettingParametersDbHelper.saveStringParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_LOCATIONS.getVoiceSettingParamTypeId(),
                selectedBtDevices.toString());
    }

