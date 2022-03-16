	private void stopChatService(){
        //TODO fix rotation bug
		System.out.println("Closing chat Service");
        if (BluetoothChatService.isSetup())
        	BluetoothChatService.getIns().stop();
	}

