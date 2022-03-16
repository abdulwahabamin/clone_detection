    public void enableBlu(){
    	// enable device discovery - this will automatically enable Bluetooth
    	Intent discoveryIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
    	 
    	discoveryIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,
    	                            DISCOVER_DURATION );
    	 
    	startActivityForResult(discoveryIntent, REQUEST_BLU);
    }

