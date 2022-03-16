        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            Long storedHourMinute = voiceSettingParametersDbHelper.getLongParam(
                    voiceSettingId,
                    VoiceSettingParamType.VOICE_SETTING_TIME_TO_START.getVoiceSettingParamTypeId());

            int hour;
            int minute;
            if (storedHourMinute == null) {
                final Calendar c = Calendar.getInstance();
                hour = c.get(Calendar.HOUR_OF_DAY);
                minute = c.get(Calendar.MINUTE);
            } else {
                int hourMinute = storedHourMinute.intValue();
                hour = hourMinute / 100;
                minute = hourMinute - (hour * 100);
            }
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

