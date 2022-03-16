	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("MyService", "Received start id " + startId + ": " + intent);
		if (intent == null) {
			// intent can be null if this is called by the OS due to
			// "START STICKY"
			// Start, but don't do anything until we get a message from the
			// user.
			return START_STICKY;
		}
		int command = intent.getIntExtra("Message", -1);
		if (command != -1) {
			Log.i(TAG, "I got a message! " + command);
			if (command == MSG_PLAYPAUSE) {
				Log.i(TAG, "I got a playpause message");
				playPause();
			} else if (command == MSG_PAUSE) {
				Log.i(TAG, "I got a pause message");
				pause();
			} else if (command == MSG_PLAY) {
				Log.i(TAG, "I got a play message");
				play();
			} else if (command == MSG_NEXT) {
				Log.i(TAG, "I got a next message");
				next();
			} else if (command == MSG_PREVIOUS) {
				Log.i(TAG, "I got a previous message");
				previous();
			} else if (command == MSG_JUMPBACK) {
				Log.i(TAG, "I got a jumpback message");
				jumpback();
			} else if (command == MSG_STOP_SERVICE) {
				Log.i(TAG, "I got a stop message");
				headphoneReceiver.active = false;
				timer.cancel();
				stopForeground(true);
				stopSelf();
			} else if (command == MSG_PAUSE_IN_ONE_SEC) {
				pauseTime = System.currentTimeMillis() + 1000;
			} else if (command == MSG_CANCEL_PAUSE_IN_ONE_SEC) {
				pauseTime = Long.MAX_VALUE;
			}
			return START_STICKY;
		}

		Message msg = mServiceHandler.obtainMessage();
		msg.arg1 = startId;
		mServiceHandler.sendMessage(msg);
		// If we get killed, after returning from here, restart
		return START_STICKY;
	}

