    private void deleteVoiceSetting(int position) {
        Long voiceSettingId = voiceSettingsAdapter.voiceSettingIds.get(position);
        voiceSettingParametersDbHelper.deleteAllSettings(voiceSettingId);
        voiceSettingsAdapter.voiceSettingIds.remove(position);
        voiceSettingsAdapter.notifyItemRemoved(position);
        voiceSettingsAdapter.notifyItemRangeChanged(position, voiceSettingsAdapter.getItemCount());
        List<Long> voiceSettingIds = voiceSettingParametersDbHelper.getAllSettingIds();
        voiceSettingsAdapter = new VoiceSettingsAdapter(voiceSettingIds);
        recyclerView.setAdapter(voiceSettingsAdapter);
        TimeUtils.setupAlarmForVoice(getBaseContext());
    }

