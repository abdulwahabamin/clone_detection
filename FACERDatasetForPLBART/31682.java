    private void populateTriggerBtDevices(int spinnerViewId, int checkBoxViewId, VoiceSettingParamType voiceSettingParamType) {
        MultiSelectionTriggerSpinner btDevicesSpinner = findViewById(spinnerViewId);
        CheckBox allBtCheckbox = findViewById(checkBoxViewId);
        btDevicesSpinner.setVoiceSettingId(voiceSettingId);

        BluetoothAdapter bluetoothAdapter = Utils.getBluetoothAdapter(getBaseContext());

        if (bluetoothAdapter == null) {
            btDevicesSpinner.setVisibility(View.GONE);
            allBtCheckbox.setVisibility(View.GONE);
            return;
        } else {
            btDevicesSpinner.setVisibility(View.VISIBLE);
            allBtCheckbox.setVisibility(View.VISIBLE);
        }

        Set<BluetoothDevice> bluetoothDeviceSet = bluetoothAdapter.getBondedDevices();

        ArrayList<MultiselectionItem> items = new ArrayList<>();
        ArrayList<MultiselectionItem> selection = new ArrayList<>();
        ArrayList<String> selectedItems = new ArrayList<>();

        String enabledBtDevices = voiceSettingParametersDbHelper.getStringParam(
                voiceSettingId,
                voiceSettingParamType.getVoiceSettingParamTypeId());
        Boolean enabledVoiceDevices = voiceSettingParametersDbHelper.getBooleanParam(
                voiceSettingId,
                voiceSettingParamType.getVoiceSettingParamTypeId());
        if ((enabledVoiceDevices != null) && enabledVoiceDevices) {
            allBtCheckbox.setChecked(true);
            findViewById(R.id.trigger_bt_when_devices).setVisibility(View.GONE);
        } else {
            findViewById(R.id.trigger_bt_when_devices).setVisibility(View.VISIBLE);
        }

        if (enabledBtDevices != null) {
            for (String btDeviceAddress: enabledBtDevices.split(",")) {
                selectedItems.add(btDeviceAddress);
            }
        }

        for(BluetoothDevice bluetoothDevice: bluetoothDeviceSet) {
            String currentDeviceName = bluetoothDevice.getName();
            String currentDeviceAddress = bluetoothDevice.getAddress();
            MultiselectionItem multiselectionItem;
            if (selectedItems.contains(currentDeviceAddress)) {
                multiselectionItem = new MultiselectionItem(currentDeviceName, currentDeviceAddress, true);
                selection.add(multiselectionItem);
            } else {
                multiselectionItem = new MultiselectionItem(currentDeviceName, currentDeviceAddress,false);
            }
            items.add(multiselectionItem);
        }
        btDevicesSpinner.setItems(items);
        btDevicesSpinner.setSelection(selection);
    }

