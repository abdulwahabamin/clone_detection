        @Override
        public void onClick(View v) {

            Intent serverIntent = new Intent(context, DeviceListActivity.class);
            startActivityForResult(serverIntent, REQUEST_CONNECT_DEVICE_SECURE);

        }

