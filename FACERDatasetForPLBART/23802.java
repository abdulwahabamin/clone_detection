        @Override
        public void onReceive(Context context, Intent intent) {
            String mAction = intent.getAction();
            Log.d(TAG, "servicePlayingUpdateReceiver.onReceive(" + mAction + ")");

            if (mAction != null) {
                switch (mAction) {
                    case MusicService.SERVICE_NOW_PLAYING:
                    case MusicService.SERVICE_PAUSED:
                        playingInfo.trackId = intent.getIntExtra("songIndex", 0);
                        if (displayInfo.genreName.equals(playingInfo.genreName)) {
                            displayInfo.trackId = playingInfo.trackId;
                            selectDisplayAlbum(playingInfo.trackId);
                            songView.setSelection(playingInfo.trackId);
                            updateControls();
                        }
                        break;

                    default:
                        Log.d(TAG, "servicePlayingUpdateReceiver.onReceive() Unknown action");
                }
            }
        }

