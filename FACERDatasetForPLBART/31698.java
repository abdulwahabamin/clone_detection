    public void populateTriggerType() {
        Spinner spinner = findViewById(R.id.trigger_type);
        final BluetoothAdapter bluetoothAdapter = Utils.getBluetoothAdapter(getBaseContext());

        ArrayAdapter<CharSequence> adapter;
        if (bluetoothAdapter == null) {
            adapter = ArrayAdapter.createFromResource(this,
                    R.array.voice_trigger_type_wo_bt, android.R.layout.simple_spinner_item);
        } else {
            adapter = ArrayAdapter.createFromResource(this,
                    R.array.voice_trigger_type, android.R.layout.simple_spinner_item);
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Long currentTriggerId = voiceSettingParametersDbHelper.getLongParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_TRIGGER_TYPE.getVoiceSettingParamTypeId());
        if (currentTriggerId != null) {
            int currentTriggerIdInt = currentTriggerId.intValue();
            if ((bluetoothAdapter == null) && (currentTriggerIdInt == 2)) {
                currentTriggerIdInt = 1;
            }
            spinner.setSelection(currentTriggerIdInt);
            triggerTypeChanged(currentTriggerIdInt);
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int positionToSave = position;
                if ((bluetoothAdapter == null) && (position == 1)) {
                    positionToSave++;
                }
                voiceSettingParametersDbHelper.saveLongParam(
                        voiceSettingId,
                        VoiceSettingParamType.VOICE_SETTING_TRIGGER_TYPE.getVoiceSettingParamTypeId(),
                        positionToSave);

                triggerTypeChanged(positionToSave);
                if (positionToSave == 2) {
                    prepareNextTime(AddVoiceSettingActivity.this, voiceSettingId, applicationLocale, voiceSettingParametersDbHelper);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

