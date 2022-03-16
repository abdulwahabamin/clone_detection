    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        FireLog.d(TAG, "Received intent with action " + action);
        switch (action) {
            case ACTION_PAUSE:
                transportControls.pause();
                break;
            case ACTION_PLAY:
                transportControls.play();
                break;
            case ACTION_NEXT:
                transportControls.skipToNext();
                break;
            case ACTION_PREV:
                transportControls.skipToPrevious();
                break;
            default:
                FireLog.w(TAG, "Unknown intent ignored. Action=" + action);
        }
    }

