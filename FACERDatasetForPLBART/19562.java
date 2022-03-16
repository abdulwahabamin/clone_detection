	/**
	 * (non-Javadoc)
	 * @see android.app.Service#onDestroy()
	 */
	@Override
	public void onDestroy() {

		//Notify the UI that the service is about to stop.
		mApp.broadcastUpdateUICommand(new String[] { Common.SERVICE_STOPPING }, 
									  new String[] { "" });
		
		//Fire a broadcast message to the widget(s) to update them.
		updateWidgets();
		
		//Send service stop event to GAnalytics.
		try {
			if (mApp.isGoogleAnalyticsEnabled()) {
				mTracker.set(Fields.SESSION_CONTROL, "end");
				mTracker.send(MapBuilder.createTiming("ACE Service",
													  System.currentTimeMillis() - mServiceStartTime, 
													  "Service duration.", 
													  "User stopped music playback.")
						.build());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Save the last track's info within the current queue.
		try {
			mApp.getSharedPreferences().edit().putLong("LAST_SONG_TRACK_POSITION", getCurrentMediaPlayer().getCurrentPosition());
		} catch (Exception e) {
			e.printStackTrace();
			mApp.getSharedPreferences().edit().putLong("LAST_SONG_TRACK_POSITION", 0);
		}
		
		//If the current song is repeating a specific range, reset the repeat option.
		if (getRepeatMode()==Common.REPEAT_SONG) {
			setRepeatMode(Common.REPEAT_OFF);
		}
		
		mFadeInVolume = 0.0f;
		mFadeOutVolume = 1.0f;
		
		//Unregister the headset plug receiver and RemoteControlClient.
		try {
			RemoteControlHelper.unregisterRemoteControlClient(mAudioManager, mRemoteControlClientCompat);
			unregisterReceiver(mHeadsetPlugReceiver);
		} catch (Exception e) {
			//Just null out the receiver if it hasn't been registered yet.
			mHeadsetPlugReceiver = null;
		}
		
		//Remove the notification.
		NotificationManager notificationManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
		notificationManager.cancel(mNotificationId);
		
		try {
			mEqualizerHelper.releaseEQObjects();
			mEqualizerHelper = null;
		} catch (Exception e1) {
			e1.printStackTrace();
			mEqualizerHelper = null;
		}

		if (mMediaPlayer!=null)
			mMediaPlayer.release();
		
		if (mMediaPlayer2!=null)
			getMediaPlayer2().release();
		
		mMediaPlayer = null;
		mMediaPlayer2 = null;
		
		//Close the cursor(s).
		try {
			getCursor().close();
			setCursor(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Final scrobbling.
		scrobbleTrack(SimpleLastFMHelper.PAUSE);

        /*
         * If A-B repeat is enabled, disable it to prevent the
         * next service instance from repeating the same section
         * over and over on the new track.
         */
        if (getRepeatMode()==Common.A_B_REPEAT)
            setRepeatMode(Common.REPEAT_OFF);

		//Remove audio focus and unregister the audio buttons receiver.
		mAudioManagerHelper.setHasAudioFocus(false);
		mAudioManager.abandonAudioFocus(audioFocusChangeListener);
		mAudioManager.unregisterMediaButtonEventReceiver(new ComponentName(getPackageName(), HeadsetButtonsReceiver.class.getName()));
		mAudioManager = null;
		mMediaButtonReceiverComponent = null;
		mRemoteControlClientCompat = null;
		
		//Nullify the service object.
		mApp.setService(null);
		mApp.setIsServiceRunning(false);
		mApp = null;
		
	}

