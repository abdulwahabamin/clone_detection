    private Long isAnySettingValidToTellWeather(Long voiceSettingId, boolean initiatedFromBtDevice) {
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        if (isActiveCall(audioManager)) {
            appendLog(getBaseContext(), TAG, "There is active phone call, not going to say anything");
            return null;
        }

        if (initiatedFromBtDevice) {
            appendLog(getBaseContext(), TAG, "Initiated from BT device, ommitin the rest of the settings");
            return voiceSettingId;
        }

        boolean isHeadsetConnected = audioManager.isWiredHeadsetOn();
        boolean isBluetoothConnected = Utils.isBluetoothHeadsetEnabledConnected(getBaseContext());

        VoiceSettingParametersDbHelper voiceSettingParametersDbHelper = VoiceSettingParametersDbHelper.getInstance(getBaseContext());
        Map<Long, Long> enabledVoiceDevices = voiceSettingParametersDbHelper.getLongParam(
                VoiceSettingParamType.VOICE_SETTING_ENABLED_VOICE_DEVICES.getVoiceSettingParamTypeId());
        appendLog(getBaseContext(), TAG, "isAnySettingValidToTellWeather enabledVoiceDevices: " + enabledVoiceDevices);
        if (enabledVoiceDevices == null) {
            appendLog(getBaseContext(), TAG, "Bluetooth or wired headset is not enabled or connected");
            return null;
        }
        appendLog(getBaseContext(), TAG, "isAnySettingValidToTellWeather voiceSettingId: " + voiceSettingId);
        if (voiceSettingId != null) {
            if (TimeUtils.isCurrentSettingIndex(enabledVoiceDevices.get(voiceSettingId), 2)) {
                appendLog(getBaseContext(), TAG, "speaker_enabled");
                return !(isBluetoothConnected || isHeadsetConnected)? voiceSettingId : null;
            }
            if (TimeUtils.isCurrentSettingIndex(enabledVoiceDevices.get(voiceSettingId), 1)) {
                appendLog(getBaseContext(), TAG, "wired_enabled");
                return isHeadsetConnected ? voiceSettingId : null;
            }
            if (TimeUtils.isCurrentSettingIndex(enabledVoiceDevices.get(voiceSettingId), 0)) {
                appendLog(getBaseContext(), TAG, "bt_enabled");
                return (isBluetoothConnected && isBtDeviceEnabled(voiceSettingId)) ? voiceSettingId : null;
            }
        } else {
            for (Long currentVoiceSettingId : enabledVoiceDevices.keySet()) {
                Long enabledVoiceDevice = enabledVoiceDevices.get(currentVoiceSettingId);
                appendLog(getBaseContext(), TAG, "isAnySettingValidToTellWeather enabledVoiceDevice: " + enabledVoiceDevice);
                if (TimeUtils.isCurrentSettingIndex(enabledVoiceDevice, 2)) {
                    appendLog(getBaseContext(), TAG, "speaker_enabled");
                    return !(isBluetoothConnected || isHeadsetConnected)? currentVoiceSettingId : null;
                }
                if (TimeUtils.isCurrentSettingIndex(enabledVoiceDevice, 1)) {
                    appendLog(getBaseContext(), TAG, "wired_enabled");
                    return isHeadsetConnected ? currentVoiceSettingId : null;
                }
                if (TimeUtils.isCurrentSettingIndex(enabledVoiceDevice, 0)) {
                    appendLog(getBaseContext(), TAG, "bt_enabled");
                    return (isBluetoothConnected && isBtDeviceEnabled(currentVoiceSettingId)) ? currentVoiceSettingId : null;
                }
            }
        }
        return null;
    }

