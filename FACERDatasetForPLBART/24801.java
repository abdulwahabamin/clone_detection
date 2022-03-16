	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(Intent.ACTION_MEDIA_BUTTON)) {
            KeyEvent keyEvent = (KeyEvent) intent.getExtras().get(Intent.EXTRA_KEY_EVENT);
            if (keyEvent.getAction() != KeyEvent.ACTION_DOWN)
                return;

            switch (keyEvent.getKeyCode()) {
                case KeyEvent.KEYCODE_HEADSETHOOK:
                case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
                	if(PlayerConstants.mSongPlayback.isPlay){
						PlayerConstants.mSongPlayback.pausePlayback();
                	}else{
						PlayerConstants.mSongPlayback.startPlayback();
                	}
                	break;
                case KeyEvent.KEYCODE_MEDIA_PLAY:
                	break;
                case KeyEvent.KEYCODE_MEDIA_PAUSE:
                	break;
                case KeyEvent.KEYCODE_MEDIA_STOP:
                	break;
                case KeyEvent.KEYCODE_MEDIA_NEXT:
					PlayerConstants.mSongPlayback.skipToNextTrack();
                	break;
                case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
					PlayerConstants.mSongPlayback.skipToPreviousTrack(false);
                	break;
            }
		}  else{
            	if (intent.getAction().equals(SongPlayback.NOTIFY_PLAY)) {
    				PlayerConstants.mSongPlayback.startPlayback();
        		} else if (intent.getAction().equals(SongPlayback.NOTIFY_PAUSE)) {
					PlayerConstants.mSongPlayback.pausePlayback();
        		} else if (intent.getAction().equals(SongPlayback.NOTIFY_NEXT)) {
					PlayerConstants.mSongPlayback.skipToNextTrack();
        		} else if (intent.getAction().equals(SongPlayback.NOTIFY_Close)) {
					PlayerConstants.mSongPlayback.stopServiceManually();
        		}else if (intent.getAction().equals(SongPlayback.NOTIFY_PREVIOUS)) {
					PlayerConstants.mSongPlayback.skipToPreviousTrack(false);
        		}
		}
	}

