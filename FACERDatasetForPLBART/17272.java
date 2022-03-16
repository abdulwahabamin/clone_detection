    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        Log.d(TAG, "Received intent with action " + action);
        switch (action) {
            case ACTION_PAUSE:
                mTransportControls.pause();
                break;
            case ACTION_PLAY:
                mTransportControls.play();
                break;
            case ACTION_NEXT:
                mTransportControls.skipToNext();
                break;
            case ACTION_PREV:
                mTransportControls.skipToPrevious();
                break;
            case ACTION_DELETE:
                // todo implement
                break;
            case ACTION_ADD_TO_PLAYLIST:
                Bundle b = new Bundle();
                b.putString(MusicService.KEY_MEDIA_ID, mMetadata.getDescription().getMediaId());
                mController.sendCommand(MusicService.CMD_FAVOURITES, b, null);
                break;
            default:
                Log.w(TAG, "Unknown intent ignored. Action="+action);
        }
    }

