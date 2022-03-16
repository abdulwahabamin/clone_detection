        void bindVoiceSetting(Long voiceSettingId) {
            this.voiceSettingId = voiceSettingId;
            if (voiceSettingId == null) {
                return;
            }
            Long triggerType = voiceSettingParametersDbHelper.getLongParam(
                    voiceSettingId,
                    VoiceSettingParamType.VOICE_SETTING_TRIGGER_TYPE.getVoiceSettingParamTypeId());
            voiceSettingIdView.setText(getString(R.string.pref_title_tts_trigger_type_label));
            if (triggerType != null) {
                String triggerTypeName = "";
                String addInfo1 = "";
                String addInfo2 = "";
                BluetoothAdapter bluetoothAdapter = Utils.getBluetoothAdapter(getBaseContext());
                Set<BluetoothDevice> bluetoothDeviceSet;
                if (bluetoothAdapter != null) {
                    bluetoothDeviceSet = bluetoothAdapter.getBondedDevices();
                } else {
                    bluetoothDeviceSet = new HashSet<>();
                }
                if (triggerType == 0) {
                    triggerTypeName = getString(R.string.voice_setting_trigger_on_weather_update);

                    StringBuilder addInfo1Builder = new StringBuilder();
                    Long enabledVoiceDevices = voiceSettingParametersDbHelper.getLongParam(
                            voiceSettingId,
                            VoiceSettingParamType.VOICE_SETTING_ENABLED_VOICE_DEVICES.getVoiceSettingParamTypeId());
                    boolean isNotFirst = false;
                    if (enabledVoiceDevices != null) {
                        if (TimeUtils.isCurrentSettingIndex(enabledVoiceDevices, 2)) {
                            addInfo1Builder.append(getString(R.string.pref_title_tts_speaker_label));
                            isNotFirst = true;
                        }
                        if (TimeUtils.isCurrentSettingIndex(enabledVoiceDevices, 1)) {
                            if (isNotFirst) {
                                addInfo1Builder.append(", ");
                            }
                            addInfo1Builder.append(getString(R.string.pref_title_tts_wired_headset_label));
                            isNotFirst = true;
                        }
                        if (TimeUtils.isCurrentSettingIndex(enabledVoiceDevices, 0)) {
                            if (isNotFirst) {
                                addInfo1Builder.append(", ");
                            }
                            addInfo1Builder.append(getString(R.string.pref_title_tts_bt_label));
                            addInfo1Builder.append(": ");
                        }

                        Boolean enabledBtVoiceDevices = voiceSettingParametersDbHelper.getBooleanParam(
                                voiceSettingId,
                                VoiceSettingParamType.VOICE_SETTING_ENABLED_WHEN_BT_DEVICES.getVoiceSettingParamTypeId());
                        if ((enabledBtVoiceDevices != null) && enabledBtVoiceDevices) {
                            addInfo1Builder.append(getString(R.string.pref_title_tts_bt_all));
                        } else {
                            String btDevices = voiceSettingParametersDbHelper.getStringParam(
                                    voiceSettingId,
                                    VoiceSettingParamType.VOICE_SETTING_ENABLED_WHEN_BT_DEVICES.getVoiceSettingParamTypeId());
                            boolean notFirst = false;
                            for(BluetoothDevice bluetoothDevice: bluetoothDeviceSet) {
                                String currentDeviceName = bluetoothDevice.getName();
                                String currentDeviceAddress = bluetoothDevice.getAddress();
                                if (btDevices.contains(currentDeviceAddress)) {
                                    if (notFirst) {
                                        addInfo1Builder.append(", ");
                                    }
                                    addInfo1Builder.append(currentDeviceName);
                                    notFirst = true;
                                }
                            }
                        }
                        addInfo1 = addInfo1Builder.toString();
                    }
                } else if (triggerType == 1) {
                    triggerTypeName = getString(R.string.voice_setting_trigger_when_bt_connected);

                    Boolean enabledVoiceDevices = voiceSettingParametersDbHelper.getBooleanParam(
                            voiceSettingId,
                            VoiceSettingParamType.VOICE_SETTING_TRIGGER_ENABLED_BT_DEVICES.getVoiceSettingParamTypeId());
                    if ((enabledVoiceDevices != null) && enabledVoiceDevices) {
                        addInfo1 = getString(R.string.pref_title_tts_bt_all);
                    } else {
                        String btDevices = voiceSettingParametersDbHelper.getStringParam(
                                voiceSettingId,
                                VoiceSettingParamType.VOICE_SETTING_TRIGGER_ENABLED_BT_DEVICES.getVoiceSettingParamTypeId());
                        StringBuilder addInfo1Builder = new StringBuilder();
                        boolean notFirst = false;
                        for(BluetoothDevice bluetoothDevice: bluetoothDeviceSet) {
                            String currentDeviceName = bluetoothDevice.getName();
                            String currentDeviceAddress = bluetoothDevice.getAddress();
                            if (btDevices.contains(currentDeviceAddress)) {
                                if (notFirst) {
                                    addInfo1Builder.append(", ");
                                }
                                addInfo1Builder.append(currentDeviceName);
                                notFirst = true;
                            }
                        }
                        addInfo1 = addInfo1Builder.toString();
                    }
                } else if (triggerType == 2) {
                    triggerTypeName = getString(R.string.voice_setting_trigger_at_time);
                    Long storedHourMinute = voiceSettingParametersDbHelper.getLongParam(
                            voiceSettingId,
                            VoiceSettingParamType.VOICE_SETTING_TIME_TO_START.getVoiceSettingParamTypeId());

                    int hour;
                    int minute;
                    if (storedHourMinute != null) {
                        int hourMinute = storedHourMinute.intValue();
                        hour = hourMinute / 100;
                        minute = hourMinute - (hour * 100);
                        final Calendar c = Calendar.getInstance();
                        c.set(Calendar.HOUR_OF_DAY, hour);
                        c.set(Calendar.MINUTE, minute);
                        addInfo1 = AppPreference.getLocalizedTime(getBaseContext(), c.getTime(), applicationLocale);

                        /*Long nextTimeDate = TimeUtils.setupAlarmForVoiceForVoiceSetting(getBaseContext(), voiceSettingId, voiceSettingParametersDbHelper);
                        if (nextTimeDate != null) {
                            c.setTimeInMillis(nextTimeDate);
                            addInfo1 += " (next " + AppPreference.getLocalizedDateTime(getBaseContext(), c.getTime(), false, applicationLocale) + ")";
                        }*/
                    }
                    Calendar calendar = Calendar.getInstance();
                    Long daysOfWeek = voiceSettingParametersDbHelper.getLongParam(
                            voiceSettingId,
                            VoiceSettingParamType.VOICE_SETTING_TRIGGER_DAY_IN_WEEK.getVoiceSettingParamTypeId());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", applicationLocale);
                    if (daysOfWeek != null) {
                        StringBuilder enabledDays = new StringBuilder();
                        boolean isFirst = false;
                        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 6)) {
                            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                            enabledDays.append(simpleDateFormat.format(calendar.getTime()));
                            isFirst = true;
                        }
                        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 5)) {
                            if (isFirst) {
                                enabledDays.append(", ");
                            }
                            calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                            enabledDays.append(simpleDateFormat.format(calendar.getTime()));
                            isFirst = true;
                        }
                        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 4)) {
                            if (isFirst) {
                                enabledDays.append(", ");
                            }
                            calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                            enabledDays.append(simpleDateFormat.format(calendar.getTime()));
                            isFirst = true;
                        }
                        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 3)) {
                            if (isFirst) {
                                enabledDays.append(", ");
                            }
                            calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                            enabledDays.append(simpleDateFormat.format(calendar.getTime()));
                            isFirst = true;
                        }
                        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 2)) {
                            if (isFirst) {
                                enabledDays.append(", ");
                            }
                            calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                            enabledDays.append(simpleDateFormat.format(calendar.getTime()));
                            isFirst = true;
                        }
                        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 1)) {
                            if (isFirst) {
                                enabledDays.append(", ");
                            }
                            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                            enabledDays.append(simpleDateFormat.format(calendar.getTime()));
                            isFirst = true;
                        }
                        if (TimeUtils.isCurrentSettingIndex(daysOfWeek, 0)) {
                            if (isFirst) {
                                enabledDays.append(", ");
                            }
                            calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                            enabledDays.append(simpleDateFormat.format(calendar.getTime()));
                        }
                        addInfo2 = enabledDays.toString();
                    }
                }
                voiceSettingTypeView.setText(triggerTypeName);
                voiceSettingAddInfo1View.setText(addInfo1);
                voiceSettingAddInfo2View.setText(addInfo2);
            }

        }

