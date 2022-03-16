    /** Setup and initialize the BluetoothChatService
     * @param Context, the application context
     * @param Handler the handler to interact with the activity
     * @throws IllegalStateException if trying to setup more than once*/
    public static void setup(Context context, Handler handler){
    	if(isSetup())
    		throw new IllegalStateException(
    				"You should setup the BluetoothChatService just ONCE");
    	
    	_instance = new BluetoothChatService(context, handler);
    }

