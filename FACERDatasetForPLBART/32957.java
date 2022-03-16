    @Override
    public void onResume(){
        super.onResume();
        checkLanguageCompatibility();
        voiceSettingsAdapter = new VoiceSettingsAdapter(voiceSettingParametersDbHelper.getAllSettingIds());
        recyclerView.setAdapter(voiceSettingsAdapter);
    }

