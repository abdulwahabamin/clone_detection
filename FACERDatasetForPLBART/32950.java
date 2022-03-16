    private void populateLanguageOptionsSpinner() {

        String localeForVoiceId = voiceSettingParametersDbHelper.getGeneralStringParam(VoiceSettingParamType.VOICE_SETTING_VOICE_LANG.getVoiceSettingParamTypeId());
        Spinner ttsLanguageOptionsSpinner = findViewById(R.id.tts_languages);
        Integer selection = 0;
        String[] spinnerArray =  new String[ttsAvailableLanguages.size() + 1];
        final Map<Integer,String> spinnerMap = new HashMap<>();
        spinnerMap.put(0, "Default");
        spinnerArray[0] = getString(R.string.pref_title_tts_lang_app_default);
        if (localeForVoiceId == null) {
           selection = 0;
        }
        int i = 1;
        boolean supportedLanguage = false;
        for(Locale locale: ttsAvailableLanguages) {
            if (locale.getLanguage().equals(localeForVoiceId)) {
                selection = i;
            }
            if (locale.getISO3Language().equals(applicationLocale.getISO3Language())) {
                supportedLanguage = true;
            }
            spinnerMap.put(i, locale.getLanguage());
            spinnerArray[i] = locale.getDisplayName();
            i++;
        }

        if (!supportedLanguage) {
            TextView langNotSupported = findViewById(R.id.voice_language_options_tts_does_not_support_lang);
            langNotSupported.setVisibility(View.VISIBLE);
            langNotSupported.setText(getString(R.string.pref_title_tts_presence));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ttsLanguageOptionsSpinner.setAdapter(adapter);
        if (selection != null) {
            ttsLanguageOptionsSpinner.setSelection(selection);
        }
        ttsLanguageOptionsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                voiceSettingParametersDbHelper.saveGeneralStringParam(
                        VoiceSettingParamType.VOICE_SETTING_VOICE_LANG.getVoiceSettingParamTypeId(),
                        spinnerMap.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

