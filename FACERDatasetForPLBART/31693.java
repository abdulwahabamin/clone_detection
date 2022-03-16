        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            long storedHourMinute = hourOfDay*100+minute;
            voiceSettingParametersDbHelper.saveLongParam(
                    voiceSettingId,
                    VoiceSettingParamType.VOICE_SETTING_TIME_TO_START.getVoiceSettingParamTypeId(),
                    storedHourMinute);
            setNewTextTime(hourOfDay, minute);
        }

