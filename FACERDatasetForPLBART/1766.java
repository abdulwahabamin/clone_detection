    public static BluetoothHandler getIns(){
    	if(!isSetup())
    		throw new IllegalStateException(
    				"You should setup the BluetoothChatService before accesing its members");
    	
    	return _instance;
    }

