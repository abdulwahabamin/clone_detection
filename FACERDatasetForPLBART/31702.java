    private void populateTtsSeySetting() {
        Long partsToSay = voiceSettingParametersDbHelper.getLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_PARTS_TO_SAY.getVoiceSettingParamTypeId());
        if (partsToSay == null) {
            return;
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 0)) {
            ((CheckBox) findViewById(R.id.tts_say_greeting_enabled)).setChecked(true);
            findViewById(R.id.tts_say_greeting_custom_panel).setVisibility(View.VISIBLE);
            findViewById(R.id.tts_say_greeting_custom).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.tts_say_greeting_custom_panel).setVisibility(View.GONE);
            findViewById(R.id.tts_say_greeting_custom).setVisibility(View.GONE);
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 1)) {
            ((CheckBox) findViewById(R.id.tts_say_greeting_custom)).setChecked(true);
            EditText customText = findViewById(R.id.tts_say_greeting_custom_text_morning);
            customText.setVisibility(View.VISIBLE);
            if (TextUtils.isEmpty(customText.getText())) {
                customText.setText(getString(R.string.tts_say_greeting_morning));
            }
            customText = findViewById(R.id.tts_say_greeting_custom_text_day);
            customText.setVisibility(View.VISIBLE);
            if (TextUtils.isEmpty(customText.getText())) {
                customText.setText(getString(R.string.tts_say_greeting_day));
            }
            customText = findViewById(R.id.tts_say_greeting_custom_text_evening);
            customText.setVisibility(View.VISIBLE);
            if (TextUtils.isEmpty(customText.getText())) {
                customText.setText(getString(R.string.tts_say_greeting_evening));
            }
        } else {
            findViewById(R.id.tts_say_greeting_custom_text_morning).setVisibility(View.GONE);
            findViewById(R.id.tts_say_greeting_custom_text_day).setVisibility(View.GONE);
            findViewById(R.id.tts_say_greeting_custom_text_evening).setVisibility(View.GONE);
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 2)) {
            ((CheckBox) findViewById(R.id.tts_say_location_enabled)).setChecked(true);
            findViewById(R.id.tts_say_location_custom_panel).setVisibility(View.VISIBLE);
            findViewById(R.id.tts_say_location_custom).setVisibility(View.VISIBLE);
            findViewById(R.id.tts_say_weather_description_panel).setVisibility(View.GONE);
            findViewById(R.id.tts_say_weather_description_custom_panel).setVisibility(View.GONE);
        } else {
            findViewById(R.id.tts_say_location_custom_panel).setVisibility(View.GONE);
            findViewById(R.id.tts_say_location_custom).setVisibility(View.GONE);
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 3)) {
            ((CheckBox) findViewById(R.id.tts_say_location_custom)).setChecked(true);
            EditText customText = findViewById(R.id.tts_say_location_custom_text);
            customText.setVisibility(View.VISIBLE);
            if (TextUtils.isEmpty(customText.getText())) {
                customText.setText(getString(R.string.tts_say_current_weather_with_location));
            }
        } else {
            findViewById(R.id.tts_say_location_custom_text).setVisibility(View.GONE);
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 4)) {
            ((CheckBox) findViewById(R.id.tts_say_weather_description_enabled)).setChecked(true);
            findViewById(R.id.tts_say_weather_description_custom_panel).setVisibility(View.VISIBLE);
            findViewById(R.id.tts_say_weather_description_custom).setVisibility(View.VISIBLE);
            findViewById(R.id.tts_say_location_enabled_panel).setVisibility(View.GONE);
            findViewById(R.id.tts_say_location_custom_panel).setVisibility(View.GONE);
        } else {
            findViewById(R.id.tts_say_weather_description_custom_panel).setVisibility(View.GONE);
            findViewById(R.id.tts_say_weather_description_custom).setVisibility(View.GONE);
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 5)) {
            ((CheckBox) findViewById(R.id.tts_say_weather_description_custom)).setChecked(true);
            EditText customText = findViewById(R.id.tts_say_weather_description_custom_text);
            customText.setVisibility(View.VISIBLE);
            if (TextUtils.isEmpty(customText.getText())) {
                customText.setText(getString(R.string.tts_say_current_weather));
            }
        } else {
            findViewById(R.id.tts_say_weather_description_custom_text).setVisibility(View.GONE);
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 6)) {
            ((CheckBox) findViewById(R.id.tts_say_temperature_enabled)).setChecked(true);
            findViewById(R.id.tts_say_temperature_custom_panel).setVisibility(View.VISIBLE);
            findViewById(R.id.tts_say_temperature_custom).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.tts_say_temperature_custom_panel).setVisibility(View.GONE);
            findViewById(R.id.tts_say_temperature_custom).setVisibility(View.GONE);
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 7)) {
            ((CheckBox) findViewById(R.id.tts_say_temperature_custom)).setChecked(true);
            EditText customText = findViewById(R.id.tts_say_temperature_custom_text);
            customText.setVisibility(View.VISIBLE);
            if (TextUtils.isEmpty(customText.getText())) {
                customText.setText(getString(R.string.tty_say_temperature));
            }
        } else {
            findViewById(R.id.tts_say_temperature_custom_text).setVisibility(View.GONE);
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 8)) {
            ((CheckBox) findViewById(R.id.tts_say_wind_enabled)).setChecked(true);
            findViewById(R.id.tts_say_wind_custom_panel).setVisibility(View.VISIBLE);
            findViewById(R.id.tts_say_wind_custom).setVisibility(View.VISIBLE);
        } else {
            findViewById(R.id.tts_say_wind_custom_panel).setVisibility(View.GONE);
            findViewById(R.id.tts_say_wind_custom).setVisibility(View.GONE);
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 9)) {
            ((CheckBox) findViewById(R.id.tts_say_wind_custom)).setChecked(true);
            EditText customText = findViewById(R.id.tts_say_wind_custom_text);
            customText.setVisibility(View.VISIBLE);
            if (TextUtils.isEmpty(customText.getText())) {
                customText.setText(getString(R.string.tty_say_wind));
            }
        } else {
            findViewById(R.id.tts_say_wind_custom_text).setVisibility(View.GONE);
        }
        if (TimeUtils.isCurrentSettingIndex(partsToSay, 10)) {
            ((CheckBox) findViewById(R.id.tts_say_forecast_enabled)).setChecked(true);
        }
    }

