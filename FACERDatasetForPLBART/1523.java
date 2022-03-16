    public void onToggleClicked(View view) {
        adapter.clear();

        ToggleButton toggleButton = (ToggleButton) view;

        if (bluetoothAdapter == null) {
            // Device does not support Bluetooth
            Toast.makeText(getApplicationContext(), "Oops! Your device does not support Bluetooth",
                    Toast.LENGTH_SHORT).show();
            toggleButton.setChecked(false);
        }
        else{
            toggleButton.setChecked(!bluetoothAdapter.isEnabled());
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
                Toast.makeText(BluetoothActivity.this, "Bluetooth disabled", Toast.LENGTH_SHORT).show();
            }
            else{
                ///bluetoothAdapter.enable(); //This does not ask for user to permit connection
                Intent enableBluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBluetoothIntent, ENABLE_BT_REQUEST_CODE);
            }
        }
    }

