    private boolean isBtDeviceEnabled(Long voiceSettingId) {
        VoiceSettingParametersDbHelper voiceSettingParametersDbHelper = VoiceSettingParametersDbHelper.getInstance(getBaseContext());
        Boolean allBtDevices = voiceSettingParametersDbHelper.getBooleanParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_ENABLED_WHEN_BT_DEVICES.getVoiceSettingParamTypeId());
        appendLog(getBaseContext(), TAG, "isBtDeviceEnabled:allBtDevices:", allBtDevices);
        if ((allBtDevices != null) && allBtDevices) {
            return true;
        }
        String enabledBtDevices = voiceSettingParametersDbHelper.getStringParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_ENABLED_WHEN_BT_DEVICES.getVoiceSettingParamTypeId());
        appendLog(getBaseContext(), TAG, "isBtDeviceEnabled:enabledBtDevices:", enabledBtDevices);
        Set<String> bluetoothDevices = Utils.getAllConnectedBtDevices(getBaseContext());
        if (bluetoothDevices.isEmpty()) {
            appendLog(getBaseContext(), TAG, "isBtDeviceEnabled:enabledBtDevices is empty");
            return false;
        }
        appendLog(getBaseContext(), TAG, "isBtDeviceEnabled:bluetoothDevices:" + bluetoothDevices);
        for (String bluetoothDevice: bluetoothDevices) {
            appendLog(getBaseContext(), TAG, "isBtDeviceEnabled:bluetoothDevice.getName():", bluetoothDevice);
            if (enabledBtDevices.contains(bluetoothDevice)) {
                return true;
            }
        }
        return false;
    }

