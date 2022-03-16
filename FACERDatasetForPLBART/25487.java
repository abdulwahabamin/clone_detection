		@Override
		public void onReceive(Context context, Intent intent) {
			if(!active){
				return;
			}
			SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
			if (Intent.ACTION_HEADSET_PLUG.equals(intent.getAction())) {
				Log.i(TAG, "Got headset plug action");
				String disconnectBehavior = sharedPref.getString("pref_disconnect_behavior", context.getString(R.string.pause_after_one_sec));
				/*
				 * state - 0 for unplugged, 1 for plugged. name - Headset type,
				 * human readable string microphone - 1 if headset has a microphone,
				 * 0 otherwise
				 */
				if(disconnectBehavior.equals(context.getString(R.string.resume_on_quick_reconnect))){
					if (intent.getIntExtra("state", -1) == 0) {
						Log.i(TAG, "headphones disconnected, pausing");
						Intent msgIntent = new Intent(context, MusicPlaybackService.class);
						msgIntent.putExtra("Message", MusicPlaybackService.MSG_PAUSE);
						context.startService(msgIntent);
						resumeOnQuickReconnectDisconnectTime = System.currentTimeMillis();
					} else if (intent.getIntExtra("state", -1) == 1) {
						long currentTime = System.currentTimeMillis();
						if(currentTime - resumeOnQuickReconnectDisconnectTime < 1000){
							// Resume
							Log.i(TAG, "headphones plugged back in within 1000ms, resuming");
							Intent msgIntent = new Intent(context, MusicPlaybackService.class);
							msgIntent.putExtra("Message", MusicPlaybackService.MSG_PLAY);
							context.startService(msgIntent);
						}
					}
				} else if(disconnectBehavior.equals(context.getString(R.string.resume_on_reconnect))){
					if (intent.getIntExtra("state", -1) == 0) {
						Log.i(TAG, "headphones disconnected, pausing");
						Intent msgIntent = new Intent(context, MusicPlaybackService.class);
						msgIntent.putExtra("Message", MusicPlaybackService.MSG_PAUSE);
						context.startService(msgIntent);
						resumeOnQuickReconnectDisconnectTime = System.currentTimeMillis();
					} else if (intent.getIntExtra("state", -1) == 1) {
						// check to make sure we were playing at one point.
						if(resumeOnQuickReconnectDisconnectTime > 0){
							// Resume
							Log.i(TAG, "headphones plugged back in, resuming");
							Intent msgIntent = new Intent(context, MusicPlaybackService.class);
							msgIntent.putExtra("Message", MusicPlaybackService.MSG_PLAY);
							context.startService(msgIntent);
						}
					}
				} else if(disconnectBehavior.equals(context.getString(R.string.pause_after_one_sec))){
					if (intent.getIntExtra("state", -1) == 0) {
						Log.i(TAG, "headphones disconnected, pausing in 1 seconds");
						Intent msgIntent = new Intent(context, MusicPlaybackService.class);
						msgIntent.putExtra("Message", MusicPlaybackService.MSG_PAUSE_IN_ONE_SEC);
						context.startService(msgIntent);
						// If the headphone is plugged back in quickly after being
						// unplugged, keep playing
					} else if (intent.getIntExtra("state", -1) == 1) {
						Log.i(TAG, "headphones plugged back in, cancelling disconnect");
						Intent msgIntent = new Intent(context, MusicPlaybackService.class);
						msgIntent.putExtra("Message", MusicPlaybackService.MSG_CANCEL_PAUSE_IN_ONE_SEC);
						context.startService(msgIntent);
					}
				} else {
					// Pause immediately
					Log.i(TAG, "headphones disconnected, pausing");
					Intent msgIntent = new Intent(context, MusicPlaybackService.class);
					msgIntent.putExtra("Message", MusicPlaybackService.MSG_PAUSE);
					context.startService(msgIntent);
				}
			} 
		}

