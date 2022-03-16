    /**Get the instance of the bluetooth service
    * @param Context, the application context
    * @param Handler the handler to interact with the activity
    * @throws IllegalStateException if trying to get the instance without setting up first
    * @return the BluetoothChatService's Singleton*/
    public static BluetoothChatService getIns(){
    	if(!isSetup())
    		throw new IllegalStateException(
    				"You should setup the BluetoothChatService before accesing its members");
    	
    	return _instance;
    }

