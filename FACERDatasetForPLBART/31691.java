    public void showTimePickerDialog(View v) {
        TimePickerFragment newFragment = new TimePickerFragment();
        newFragment.setVoiceSettingId(voiceSettingId);
        newFragment.setVoiceSettingParametersDbHelper(voiceSettingParametersDbHelper);
        newFragment.setApplicationLocale(applicationLocale);
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

