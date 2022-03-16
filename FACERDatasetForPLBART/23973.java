    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void createMediaSession() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mSession = new MediaSession(this, getString(R.string.applabel));
            mSession.setFlags(MediaSession.FLAG_HANDLES_MEDIA_BUTTONS |
                    MediaSession.FLAG_HANDLES_TRANSPORT_CONTROLS);
        }
    }

