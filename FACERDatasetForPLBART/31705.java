    public void onRadioButtonClicked(View view) {
        Long daysOfWeek = voiceSettingParametersDbHelper.getLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_TRIGGER_DAY_IN_WEEK.getVoiceSettingParamTypeId());
        if (daysOfWeek == null) {
            daysOfWeek = 0l;
        }
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()) {
            case R.id.voice_trigger_mon:
                if (checked) {
                    daysOfWeek += TimeUtils.getTwoPower(6);
                } else {
                    daysOfWeek += TimeUtils.getTwoPower(6);
                }
                break;
            case R.id.voice_trigger_tue:
                if (checked) {
                    daysOfWeek += TimeUtils.getTwoPower(5);
                } else {
                    daysOfWeek -= TimeUtils.getTwoPower(5);
                }
                break;
            case R.id.voice_trigger_wed:
                if (checked) {
                    daysOfWeek += TimeUtils.getTwoPower(4);
                } else {
                    daysOfWeek -= TimeUtils.getTwoPower(4);
                }                break;
            case R.id.voice_trigger_thu:
                if (checked) {
                    daysOfWeek += TimeUtils.getTwoPower(3);
                } else {
                    daysOfWeek -= TimeUtils.getTwoPower(3);
                }
                break;
            case R.id.voice_trigger_fri:
                if (checked) {
                    daysOfWeek += TimeUtils.getTwoPower(2);
                } else {
                    daysOfWeek -= TimeUtils.getTwoPower(2);
                }
                break;
            case R.id.voice_trigger_sat:
                if (checked) {
                    daysOfWeek += TimeUtils.getTwoPower(1);
                } else {
                    daysOfWeek -= TimeUtils.getTwoPower(1);
                }
                break;
            case R.id.voice_trigger_sun:
                if (checked) {
                    daysOfWeek += TimeUtils.getTwoPower(0);
                } else {
                    daysOfWeek -= TimeUtils.getTwoPower(0);
                }
                break;
        }
        voiceSettingParametersDbHelper.saveLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_TRIGGER_DAY_IN_WEEK.getVoiceSettingParamTypeId(),
                daysOfWeek);
        prepareNextTime(this, voiceSettingId, applicationLocale, voiceSettingParametersDbHelper);
    }

