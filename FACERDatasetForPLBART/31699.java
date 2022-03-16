    private void triggerTypeChanged(int currentTriggerId) {
        if (currentTriggerId != 2) {
            findViewById(R.id.button_voice_setting_time).setVisibility(View.GONE);
            findViewById(R.id.pref_title_tts_trigger_days_panel).setVisibility(View.GONE);
        } else {
            findViewById(R.id.button_voice_setting_time).setVisibility(View.VISIBLE);
            findViewById(R.id.pref_title_tts_trigger_days_panel).setVisibility(View.VISIBLE);
        }
        if (currentTriggerId != 1) {
            findViewById(R.id.pref_title_tts_bt_trigger_panel).setVisibility(View.GONE);
            findViewById(R.id.enabled_devices_panel).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.pref_title_tts_bt_trigger_panel).setVisibility(View.VISIBLE);
            findViewById(R.id.enabled_devices_panel).setVisibility(View.GONE);
        }
        prepareNextTime(this, voiceSettingId, applicationLocale, voiceSettingParametersDbHelper);
    }

