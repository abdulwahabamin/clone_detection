    private String getCustomGreeting(VoiceSettingParametersDbHelper voiceSettingParametersDbHelper, Long voiceSettingId) {
        int hours = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if ((hours >= 3) && (hours < 10)) {
            return voiceSettingParametersDbHelper.getStringParam(
                    voiceSettingId,
                    VoiceSettingParamType.VOICE_SETTING_GREETING_CUSTOM_MORNING.getVoiceSettingParamTypeId());
        } else if ((hours >= 10) && (hours < 18)) {
            return voiceSettingParametersDbHelper.getStringParam(
                    voiceSettingId,
                    VoiceSettingParamType.VOICE_SETTING_GREETING_CUSTOM_DAY.getVoiceSettingParamTypeId());
        } else if (hours >= 18) {
            return voiceSettingParametersDbHelper.getStringParam(
                    voiceSettingId,
                    VoiceSettingParamType.VOICE_SETTING_GREETING_CUSTOM_EVENING.getVoiceSettingParamTypeId());
        } else {
            return voiceSettingParametersDbHelper.getStringParam(
                    voiceSettingId,
                    VoiceSettingParamType.VOICE_SETTING_GREETING_CUSTOM_DAY.getVoiceSettingParamTypeId());
        }
    }

