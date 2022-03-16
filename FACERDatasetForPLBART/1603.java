    private void DiscoveringDeviices(){

        if(discoverDevicesReceiver == null){
            discoverDevicesReceiver = new BroadcastReceiver() {
                //Se inicia cuando se encuentra un nuevo dispositivo. //
                @Override
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();

                    // Se encuentra un dispositivo. //
                    if(BluetoothDevice.ACTION_FOUND.equals(action)){
                        //se obtiene el objeto BluetoothDevice del Intent //
                        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                        // Añade el nombre y la dirección a un array
                        // de adaptadores para mostrarlos en una vista ListView
                        // sólo añadirá el dispositivo si no se encontrase previamente en la lista.
                        if(!discoveredDevicesnames.contains(device)){
                            // Añade el dispositivo //
                            discoveredDevices.add(device);

                            // añade el nombre del dispositivo para utilizarlo con ListView.
                            discoveredDevicesnames.add(device.getName());

                            // muestra los elementos de ListView
                            setListAdapter(new ArrayAdapter<String>(getBaseContext(),
                                    android.R.layout.simple_list_item_1,
                                    discoveredDevicesnames));
                        }
                    }
                }
            };
        }

        if(discoveryFinishedReceiver == null){
            discoveryFinishedReceiver = new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    // activar listview cuando finalice la búsqueda.
                    // unos 12 segundos.
                    getListView().setEnabled(true);
                    Toast.makeText(getBaseContext(),
                            "Bísqueda finalizada. Seleccione un dispositivo para comenzar a conversar",
                            Toast.LENGTH_LONG).show();
                    unregisterReceiver(discoveryFinishedReceiver);
                }
            };
        }

        // registro de receptores de difusión //
        IntentFilter filter1 = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        IntentFilter filter2 = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);

        registerReceiver(discoverDevicesReceiver, filter1);
        registerReceiver(discoveryFinishedReceiver, filter2);

        // desactivar ListView cuando la búsqueda está en proceso.
        getListView().setEnabled(false);
        Toast.makeText(getBaseContext(),
                "Búsqueda en proceso... por favor, espere...",
                Toast.LENGTH_LONG).show();
        bluetoothAdapter.startDiscovery();
    }

