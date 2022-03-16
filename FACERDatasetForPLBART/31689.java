    private void setTextTime() {
        Long storedHourMinute = voiceSettingParametersDbHelper.getLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_TIME_TO_START.getVoiceSettingParamTypeId());

        Button voiceSettingButton = (Button) findViewById(R.id.button_voice_setting_time);

        if (storedHourMinute == null) {
            voiceSettingButton.setText(getString(R.string.pref_title_tts_time));
            return;
        }

        int hourMinute = storedHourMinute.intValue();
        int hour = hourMinute / 100;
        int minute = hourMinute - (hour * 100);

        final Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);

        voiceSettingButton.setText(AppPreference.getLocalizedTime(this, c.getTime(), applicationLocale));
    }

