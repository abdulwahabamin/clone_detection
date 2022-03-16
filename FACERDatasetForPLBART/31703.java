    public void onTtsSeySettingButtonClicked(View view) {
        Long partsToSay = voiceSettingParametersDbHelper.getLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_PARTS_TO_SAY.getVoiceSettingParamTypeId());
        if (partsToSay == null) {
            partsToSay = 0l;
        }
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.tts_say_greeting_enabled:
                if (checked) {
                    partsToSay += TimeUtils.getTwoPower(0);
                    findViewById(R.id.tts_say_greeting_custom_panel).setVisibility(View.VISIBLE);
                    findViewById(R.id.tts_say_greeting_custom).setVisibility(View.VISIBLE);
                } else {
                    partsToSay -= TimeUtils.getTwoPower(0);
                    findViewById(R.id.tts_say_greeting_custom_panel).setVisibility(View.GONE);
                    findViewById(R.id.tts_say_greeting_custom).setVisibility(View.GONE);
                }
                break;
            case R.id.tts_say_greeting_custom:
                if (checked) {
                    partsToSay += TimeUtils.getTwoPower(1);
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
                    TextView originalText = findViewById(R.id.tts_say_greeting_morning_original_text);
                    originalText.setTextColor(Color.GRAY);
                    originalText = findViewById(R.id.tts_say_greeting_day_original_text);
                    originalText.setTextColor(Color.GRAY);
                    originalText = findViewById(R.id.tts_say_greeting_evening_original_text);
                    originalText.setTextColor(Color.GRAY);
                } else {
                    partsToSay -= TimeUtils.getTwoPower(1);
                    findViewById(R.id.tts_say_greeting_custom_text_morning).setVisibility(View.GONE);
                    findViewById(R.id.tts_say_greeting_custom_text_day).setVisibility(View.GONE);
                    findViewById(R.id.tts_say_greeting_custom_text_evening).setVisibility(View.GONE);
                    TextView originalText = findViewById(R.id.tts_say_greeting_morning_original_text);
                    originalText.setTextColor(Color.BLACK);
                    originalText = findViewById(R.id.tts_say_greeting_day_original_text);
                    originalText.setTextColor(Color.BLACK);
                    originalText = findViewById(R.id.tts_say_greeting_evening_original_text);
                    originalText.setTextColor(Color.BLACK);
                }
                break;
            case R.id.tts_say_location_enabled:
                if (checked) {
                    partsToSay += TimeUtils.getTwoPower(2);
                    findViewById(R.id.tts_say_location_custom_panel).setVisibility(View.VISIBLE);
                    findViewById(R.id.tts_say_location_custom).setVisibility(View.VISIBLE);
                    findViewById(R.id.tts_say_weather_description_panel).setVisibility(View.GONE);
                    findViewById(R.id.tts_say_weather_description_custom_panel).setVisibility(View.GONE);
                } else {
                    partsToSay -= TimeUtils.getTwoPower(2);
                    findViewById(R.id.tts_say_location_custom_panel).setVisibility(View.GONE);
                    findViewById(R.id.tts_say_location_custom).setVisibility(View.GONE);
                    findViewById(R.id.tts_say_weather_description_panel).setVisibility(View.VISIBLE);
                    //findViewById(R.id.tts_say_weather_description_custom_panel).setVisibility(View.VISIBLE);
                }
                break;
            case R.id.tts_say_location_custom:
                partsToSay = enableAndFillCustomText(
                        3,
                        checked,
                        partsToSay,
                        R.id.tts_say_location_custom_text,
                        R.string.tts_say_current_weather_with_location,
                        R.id.tts_say_location_original_text);
                break;
            case R.id.tts_say_weather_description_enabled:
                if (checked) {
                    partsToSay += TimeUtils.getTwoPower(4);
                    findViewById(R.id.tts_say_weather_description_custom_panel).setVisibility(View.VISIBLE);
                    findViewById(R.id.tts_say_weather_description_custom).setVisibility(View.VISIBLE);
                    findViewById(R.id.tts_say_location_enabled_panel).setVisibility(View.GONE);
                    findViewById(R.id.tts_say_location_custom_panel).setVisibility(View.GONE);
                } else {
                    partsToSay -= TimeUtils.getTwoPower(4);
                    findViewById(R.id.tts_say_weather_description_custom_panel).setVisibility(View.GONE);
                    findViewById(R.id.tts_say_weather_description_custom).setVisibility(View.GONE);
                    findViewById(R.id.tts_say_location_enabled_panel).setVisibility(View.VISIBLE);
                    //findViewById(R.id.tts_say_location_custom_panel).setVisibility(View.VISIBLE);
                }
                break;
            case R.id.tts_say_weather_description_custom:
                partsToSay = enableAndFillCustomText(
                        5,
                        checked,
                        partsToSay,
                        R.id.tts_say_weather_description_custom_text,
                        R.string.tts_say_current_weather,
                        R.id.tts_say_weather_description_original_text);
                break;
            case R.id.tts_say_temperature_enabled:
                if (checked) {
                    partsToSay += TimeUtils.getTwoPower(6);
                    findViewById(R.id.tts_say_temperature_custom_panel).setVisibility(View.VISIBLE);
                    findViewById(R.id.tts_say_temperature_custom).setVisibility(View.VISIBLE);
                } else {
                    partsToSay -= TimeUtils.getTwoPower(6);
                    findViewById(R.id.tts_say_temperature_custom_panel).setVisibility(View.GONE);
                    findViewById(R.id.tts_say_temperature_custom).setVisibility(View.GONE);
                }
                break;
            case R.id.tts_say_temperature_custom:
                partsToSay = enableAndFillCustomText(
                        7,
                        checked,
                        partsToSay,
                        R.id.tts_say_temperature_custom_text,
                        R.string.tty_say_temperature,
                        R.id.tts_say_temperature_original_text);
                break;
            case R.id.tts_say_wind_enabled:
                if (checked) {
                    partsToSay += TimeUtils.getTwoPower(8);
                    findViewById(R.id.tts_say_wind_custom_panel).setVisibility(View.VISIBLE);
                    findViewById(R.id.tts_say_wind_custom).setVisibility(View.VISIBLE);
                } else {
                    partsToSay -= TimeUtils.getTwoPower(8);
                    findViewById(R.id.tts_say_wind_custom_panel).setVisibility(View.GONE);
                    findViewById(R.id.tts_say_wind_custom).setVisibility(View.GONE);
                }
                break;
            case R.id.tts_say_wind_custom:
                partsToSay = enableAndFillCustomText(
                        9,
                        checked,
                        partsToSay,
                        R.id.tts_say_wind_custom_text,
                        R.string.tty_say_wind,
                        R.id.tts_say_wind_original_text);
                break;
            case R.id.tts_say_forecast_enabled:
                if (checked) {
                    partsToSay += TimeUtils.getTwoPower(10);
                } else {
                    partsToSay -= TimeUtils.getTwoPower(10);
                }
                break;
        }
        voiceSettingParametersDbHelper.saveLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_PARTS_TO_SAY.getVoiceSettingParamTypeId(),
                partsToSay);
    }

