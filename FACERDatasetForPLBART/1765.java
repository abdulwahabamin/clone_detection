    public static BluetoothHandler setup(Context ctx){
    	if(isSetup())
    		throw new IllegalStateException(
    				"You should setup the BluetoothHandler just ONCE");
    	
    	return (_instance = new BluetoothHandler(ctx));
    }

