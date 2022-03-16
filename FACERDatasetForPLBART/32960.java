    public synchronized void addVoiceSetting(View view) {
        long newVoiceSettingId;
        if ((voiceSettingsAdapter.voiceSettingIds == null) || voiceSettingsAdapter.voiceSettingIds.isEmpty()) {
            newVoiceSettingId = 1;
        } else {
            newVoiceSettingId = Collections.max(voiceSettingsAdapter.voiceSettingIds) + 1;
        }
        voiceSettingParametersDbHelper.saveLongParam(
                newVoiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_TRIGGER_TYPE.getVoiceSettingParamTypeId(),
                0);
        voiceSettingParametersDbHelper.saveBooleanParam(
                newVoiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_LOCATIONS.getVoiceSettingParamTypeId(),
                true);
        voiceSettingParametersDbHelper.saveLongParam(
                newVoiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_ENABLED_VOICE_DEVICES.getVoiceSettingParamTypeId(),
                7);
        voiceSettingParametersDbHelper.saveBooleanParam(
                newVoiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_ENABLED_WHEN_BT_DEVICES.getVoiceSettingParamTypeId(),
                true);
        voiceSettingParametersDbHelper.saveLongParam(
                newVoiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_PARTS_TO_SAY.getVoiceSettingParamTypeId(),
                325);
        voiceSettingParametersDbHelper.saveLongParam(
                newVoiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_TRIGGER_DAY_IN_WEEK.getVoiceSettingParamTypeId(),
                127);
        voiceSettingParametersDbHelper.saveBooleanParam(
                newVoiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_TRIGGER_ENABLED_BT_DEVICES.getVoiceSettingParamTypeId(),
                true);
        moveToAddVoiceSettingsActivity(newVoiceSettingId);
    }

