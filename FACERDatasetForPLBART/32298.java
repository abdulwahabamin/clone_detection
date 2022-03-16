    private boolean isBtTriggerEnabled(BluetoothDevice bluetoothDevice) {
        VoiceSettingParametersDbHelper voiceSettingParametersDbHelper = VoiceSettingParametersDbHelper.getInstance(context);
        Map<Long, Long> voiceTriggetType = voiceSettingParametersDbHelper.getLongParam(
                VoiceSettingParamType.VOICE_SETTING_TRIGGER_TYPE.getVoiceSettingParamTypeId());
        appendLog(context, TAG, "isBtTriggerEnabled: " + voiceTriggetType);
        for (Long currentVoiceSettingId: voiceTriggetType.keySet()) {
            Long value = voiceTriggetType.get(currentVoiceSettingId);
            appendLog(context, TAG, "isBtTriggerEnabled:value: " + value);
            if (value == null) {
                continue;
            }
            if (value == 1) {
                Boolean allBtDevices = voiceSettingParametersDbHelper.getBooleanParam(
                        currentVoiceSettingId,
                        VoiceSettingParamType.VOICE_SETTING_TRIGGER_ENABLED_BT_DEVICES.getVoiceSettingParamTypeId());
                appendLog(context, TAG, "isBtTriggerEnabled:allBtDevices: " + allBtDevices);
                if ((allBtDevices != null) && allBtDevices) {
                    voiceSettingId = currentVoiceSettingId;
                    return true;
                }
                String enabledBtDevices = voiceSettingParametersDbHelper.getStringParam(
                        currentVoiceSettingId,
                        VoiceSettingParamType.VOICE_SETTING_TRIGGER_ENABLED_BT_DEVICES.getVoiceSettingParamTypeId());
                if (bluetoothDevice == null) {
                    return false;
                }
                if ((enabledBtDevices != null) && enabledBtDevices.contains(bluetoothDevice.getAddress())) {
                    voiceSettingId = currentVoiceSettingId;
                    return true;
                }
            }
        }
        return false;
    }

