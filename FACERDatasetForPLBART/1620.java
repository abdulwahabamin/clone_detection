	    public void onReceive(Context context, Intent intent) {
	        String action = intent.getAction();
	        if(BluetoothDevice.ACTION_FOUND.equals(action)){
	        	BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
	        	pairedDevices.add(device);
	        	allDevices.add(device.getName());
	        	ListView devicesList = (ListView)findViewById(R.id.devicesList);
	    		ArrayAdapter<String> list = new ArrayAdapter<String>(BluetoothClientConnection.this,android.R.layout.simple_list_item_1,allDevices);
	    		devicesList.setAdapter(list);
	    		devicesList.setOnItemClickListener(setupClient);
	    		ProgressBar progress = (ProgressBar) findViewById(R.id.searching);
	    		progress.setVisibility(View.GONE);
	        }
	    }

