	@Override
	protected void onResume() {
		super.onResume();
		receiver=new LrcMessageBroadcastReceiver();   
		registerReceiver(receiver, getIntentFilter());		//register a receiver for lrc broadcast 
	}

