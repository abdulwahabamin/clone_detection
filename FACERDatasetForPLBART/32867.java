    public static void setupAlarmForVoice(Context context) {
        VoiceSettingParametersDbHelper voiceSettingParametersDbHelper = VoiceSettingParametersDbHelper.getInstance(context);
        Map<Long, Long> voiceTimeSettings = voiceSettingParametersDbHelper.getLongParam(
                VoiceSettingParamType.VOICE_SETTING_TRIGGER_TYPE.getVoiceSettingParamTypeId());

        Map<Long, Long> nextAlarms = new HashMap<>();

        appendLog(context,
                TAG,
                "voiceTimeSettings.size = ", voiceTimeSettings.size());

        for (Long voiceSettingId: voiceTimeSettings.keySet()) {
            appendLog(context,
                    TAG,
                    "voiceSettingId = ", voiceSettingId);
            appendLog(context,
                    TAG,
                    "voiceSettingId.triggerType = ", voiceTimeSettings.get(voiceSettingId));
            if (voiceTimeSettings.get(voiceSettingId) != 2) {
                continue;
            }
            Long nextAlarmForVoiceSetting = setupAlarmForVoiceForVoiceSetting(context, voiceSettingId, voiceSettingParametersDbHelper);
            if (nextAlarmForVoiceSetting == null) {
                continue;
            }
            appendLog(context,
                    TAG,
                    "nextAlarmForVoiceSetting = ", nextAlarmForVoiceSetting);
            nextAlarms.put(nextAlarmForVoiceSetting, voiceSettingId);
        }

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (nextAlarms.isEmpty()) {
            alarmManager.cancel(TimeUtils.getPendingIntentForVoice(context, 0l));
            return;
        }

        Set<Long> nextAlarmsList = new TreeSet<>(nextAlarms.keySet());
        long nextTime = nextAlarmsList.iterator().next();

        appendLog(context,
                TAG,
                "nextTime = ", nextTime, ", settingsId = ", nextAlarms.get(nextTime));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,
                    nextTime,
                    getPendingIntentForVoice(context, nextAlarms.get(nextTime)));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP,
                    nextTime,
                    getPendingIntentForVoice(context, nextAlarms.get(nextTime)));
        } else {
            alarmManager.set(AlarmManager.RTC_WAKEUP,
                    nextTime,
                    getPendingIntentForVoice(context, nextAlarms.get(nextTime)));
        }
    }

