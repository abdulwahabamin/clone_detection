        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // RealmManager.saveData(new User(device.getName(),device.getAddress()));
               /* fragment.getList().add(new User(device.getName(),device.getAddress()));
                fragment.getAdapter().notifyItemInserted(fragment.getList().size());*/

               try {
                   if (device.getBluetoothClass().getDeviceClass() != BluetoothClass.Device.PHONE_SMART) {
                       return;
                   }
               }catch (Exception e)
               {
                   e.printStackTrace();
               }

               if (!devices.contains(device)) {
                   devices.add(device);
                   states.add(true);
                   sAdapter.notifyItemInserted(devices.size() - 1);
               }else {
                   int index=devices.indexOf(device);
                   states.set(index,true);
                   sAdapter.notifyItemChanged(index);

               }

                Utils.log("found devices",device.getName()+" / "+device.getAddress());
            }
        }

