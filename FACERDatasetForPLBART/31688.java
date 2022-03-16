    private void populateDayOfWeeks() {
        Long daysOfWeek = voiceSettingParametersDbHelper.getLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_TRIGGER_DAY_IN_WEEK.getVoiceSettingParamTypeId());
        if (daysOfWeek == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", applicationLocale);
        CheckBox triggerCheckBox = findViewById(R.id.voice_trigger_mon);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        triggerCheckBox.setText(simpleDateFormat.format(calendar.getTime()));
        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 6)) {
            triggerCheckBox.setChecked(true);
        }
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        triggerCheckBox = findViewById(R.id.voice_trigger_tue);
        triggerCheckBox.setText(simpleDateFormat.format(calendar.getTime()));
        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 5)) {
            triggerCheckBox.setChecked(true);
        }
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        triggerCheckBox = findViewById(R.id.voice_trigger_wed);
        triggerCheckBox.setText(simpleDateFormat.format(calendar.getTime()));
        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 4)) {
            triggerCheckBox.setChecked(true);
        }
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
        triggerCheckBox = findViewById(R.id.voice_trigger_thu);
        triggerCheckBox.setText(simpleDateFormat.format(calendar.getTime()));
        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 3)) {
            triggerCheckBox.setChecked(true);
        }
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
        triggerCheckBox = findViewById(R.id.voice_trigger_fri);
        triggerCheckBox.setText(simpleDateFormat.format(calendar.getTime()));
        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 2)) {
            triggerCheckBox.setChecked(true);
        }
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        triggerCheckBox = findViewById(R.id.voice_trigger_sat);
        triggerCheckBox.setText(simpleDateFormat.format(calendar.getTime()));
        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 1)) {
            triggerCheckBox.setChecked(true);
        }
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        triggerCheckBox = findViewById(R.id.voice_trigger_sun);
        triggerCheckBox.setText(simpleDateFormat.format(calendar.getTime()));
        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 0)) {
            triggerCheckBox.setChecked(true);
        }
    }

