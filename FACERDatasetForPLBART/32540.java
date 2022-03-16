    private void sayWeatherByTime(Intent intent) {
        Long voiceSettingId = intent.getLongExtra("voiceSettingId", Long.MAX_VALUE);
        appendLog(getBaseContext(), TAG, "sayWeatherByTime:" + voiceSettingId);

        if (voiceSettingId == Long.MAX_VALUE) {
            return;
        }
        TimeUtils.setupAlarmForVoice(getBaseContext());
        sayForLocation(voiceSettingId, false);
    }

