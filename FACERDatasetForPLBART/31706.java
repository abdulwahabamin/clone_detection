    private static void prepareNextTime(Activity context, Long voiceSettingId, Locale applicationLocale, VoiceSettingParametersDbHelper voiceSettingParametersDbHelper) {
        TimeUtils.setupAlarmForVoice(context);
        Calendar c  = Calendar.getInstance();
        Long nextTimeDate = TimeUtils.setupAlarmForVoiceForVoiceSetting(context, voiceSettingId, voiceSettingParametersDbHelper);
        if (nextTimeDate != null) {
            TextView nextTimeView = context.findViewById(R.id.voice_setting_next_time);
            c.setTimeInMillis(nextTimeDate);
            nextTimeView.setText(" (-> " + AppPreference.getLocalizedDateTime(context, c.getTime(), false, applicationLocale) + ")");
        }
    }

