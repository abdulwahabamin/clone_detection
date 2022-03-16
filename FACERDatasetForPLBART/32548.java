    private Locale getLocaleForVoice() {
        VoiceSettingParametersDbHelper voiceSettingParametersDbHelper = VoiceSettingParametersDbHelper.getInstance(getBaseContext());
        String localeForVoiceId = voiceSettingParametersDbHelper.getGeneralStringParam(VoiceSettingParamType.VOICE_SETTING_VOICE_LANG.getVoiceSettingParamTypeId());
        if ((localeForVoiceId == null) || ("Default".equals(localeForVoiceId))) {
            return new Locale(PreferenceUtil.getLanguage(this));
        } else {
            return new Locale(localeForVoiceId);
        }
    }

