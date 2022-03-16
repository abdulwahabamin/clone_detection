    public static Long setupAlarmForVoiceForVoiceSetting(Context context, Long voiceSettingId, VoiceSettingParametersDbHelper voiceSettingParametersDbHelper) {
        Long storedHourMinute = voiceSettingParametersDbHelper.getLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_TIME_TO_START.getVoiceSettingParamTypeId());

        if (storedHourMinute == null) {
            return null;
        }

        int hourMinute = storedHourMinute.intValue();
        int hour = hourMinute / 100;
        int minute = hourMinute - (hour * 100);

        final Calendar now = Calendar.getInstance();
        now.set(Calendar.SECOND, 0);
        now.set(Calendar.MILLISECOND, 0);
        now.add(Calendar.MINUTE, 1);

        final Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        if (now.after(c)) {
            c.add(Calendar.DAY_OF_YEAR, 1);
        }

        Long enabledDaysOfWeek = voiceSettingParametersDbHelper.getLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_TRIGGER_DAY_IN_WEEK.getVoiceSettingParamTypeId());

        if (enabledDaysOfWeek == null) {
            return null;
        }

        for (int dayOfWeek = 0; dayOfWeek < 7; dayOfWeek++) {
            int currentDayOfWeek = c.get(Calendar.DAY_OF_WEEK);

            if (currentDayOfWeek == Calendar.MONDAY) {
                if (isCurrentSettingIndex(enabledDaysOfWeek, 6)) {
                    break;
                } else {
                    c.add(Calendar.DAY_OF_YEAR, 1);
                    continue;
                }
            }
            if (currentDayOfWeek == Calendar.TUESDAY) {
                if (isCurrentSettingIndex(enabledDaysOfWeek, 5)) {
                    break;
                } else {
                    c.add(Calendar.DAY_OF_YEAR, 1);
                    continue;
                }
            }
            if (currentDayOfWeek == Calendar.WEDNESDAY) {
                if (isCurrentSettingIndex(enabledDaysOfWeek, 4)) {
                    break;
                } else {
                    c.add(Calendar.DAY_OF_YEAR, 1);
                    continue;
                }
            }
            if (currentDayOfWeek == Calendar.THURSDAY) {
                if (isCurrentSettingIndex(enabledDaysOfWeek, 3)) {
                    break;
                } else {
                    c.add(Calendar.DAY_OF_YEAR, 1);
                    continue;
                }
            }
            if (currentDayOfWeek == Calendar.FRIDAY) {
                if (isCurrentSettingIndex(enabledDaysOfWeek, 2)) {
                    break;
                } else {
                    c.add(Calendar.DAY_OF_YEAR, 1);
                    continue;
                }
            }
            if (currentDayOfWeek == Calendar.SATURDAY) {
                if (isCurrentSettingIndex(enabledDaysOfWeek, 1)) {
                    break;
                } else {
                    c.add(Calendar.DAY_OF_YEAR, 1);
                    continue;
                }
            }
            if (currentDayOfWeek == Calendar.SUNDAY) {
                if (isCurrentSettingIndex(enabledDaysOfWeek, 0)) {
                    break;
                } else {
                    c.add(Calendar.DAY_OF_YEAR, 1);
                    continue;
                }
            }
        }
        return c.getTimeInMillis();
    }

