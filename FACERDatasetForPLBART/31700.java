    private void populateLocations() {
        LocationsDbHelper locationsDbHelper = LocationsDbHelper.getInstance(this);
        List<Location> currentLocations = locationsDbHelper.getAllRows();
        MultiSelectionLocationSpinner btDevicesSpinner = findViewById(R.id.tts_setting_locations);
        btDevicesSpinner.setVoiceSettingId(voiceSettingId);

        ArrayList<MultiselectionLocationItem> items = new ArrayList<>();
        ArrayList<MultiselectionLocationItem> selection = new ArrayList<>();
        ArrayList<String> selectedItems = new ArrayList<>();

        String enabledBtDevices = voiceSettingParametersDbHelper.getStringParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_LOCATIONS.getVoiceSettingParamTypeId());
        Boolean enabledVoiceDevices = voiceSettingParametersDbHelper.getBooleanParam(
                voiceSettingId,
                VoiceSettingParamType.VOICE_SETTING_LOCATIONS.getVoiceSettingParamTypeId());
        if ((enabledVoiceDevices != null) && enabledVoiceDevices) {
            ((CheckBox) findViewById(R.id.tts_setting_all_locations)).setChecked(true);
            findViewById(R.id.tts_setting_locations).setVisibility(View.GONE);
        } else {
            findViewById(R.id.tts_setting_locations).setVisibility(View.VISIBLE);
        }

        if (enabledBtDevices != null) {
            for (String btDeviceName: enabledBtDevices.split(",")) {
                selectedItems.add(btDeviceName);
            }
        }

        for(Location location: currentLocations) {
            String locationCityForVoice = Utils.getLocationForVoiceFromAddress(location.getAddress());
            MultiselectionLocationItem multiselectionItem;
            if (selectedItems.contains(location.getId().toString())) {
                multiselectionItem = new MultiselectionLocationItem(location.getId(), locationCityForVoice, true);
                selection.add(multiselectionItem);
            } else {
                multiselectionItem = new MultiselectionLocationItem(location.getId(), locationCityForVoice, false);
            }
            items.add(multiselectionItem);
        }
        btDevicesSpinner.setItems(items);
        btDevicesSpinner.setSelection(selection);
    }

