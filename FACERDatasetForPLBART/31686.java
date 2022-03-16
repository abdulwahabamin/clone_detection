    public void onAllLocationsButtonClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        voiceSettingParametersDbHelper.saveBooleanParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_LOCATIONS.getVoiceSettingParamTypeId(),
                checked);
        if (checked) {
            findViewById(R.id.tts_setting_locations).setVisibility(View.GONE);
        } else {
            findViewById(R.id.tts_setting_locations).setVisibility(View.VISIBLE);
        }
    }

