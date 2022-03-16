	    public AcceptThread() {
	        // Use a temporary object that is later assigned to mmServerSocket,
	        // because mmServerSocket is final
	        BluetoothServerSocket tmp = null;
	        try {
	            // MY_UUID is the app's UUID string, also used by the client code
	            tmp = mBluetoothAdapter.listenUsingRfcommWithServiceRecord("Bluetooth Chat", UUID.nameUUIDFromBytes(username.getBytes()));
	        } catch (IOException e) { }
	        mmServerSocket = tmp;
	    }

