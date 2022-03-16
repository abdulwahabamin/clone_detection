        public void onItemClick(AdapterView<?> av, View v, int arg2, long arg3) {
            mBleChat.stopScan();

            String name = ((TextView) v).getText().toString().split("@")[0];
            // Get the device MAC address, which is the last 17 chars in the View
            String info = ((TextView) v).getText().toString();
            String address = info.substring(info.length() - 17);

            // Create the result Intent and include the MAC address
            Intent intent = new Intent();
            intent.putExtra(EXTRA_DEVICE_ADDRESS, address);
            intent.putExtra(EXTRA_DEVICE_NAME, name);
            // Set result and finish this Activity
            setResult(Activity.RESULT_OK, intent);
            finish();
        }

