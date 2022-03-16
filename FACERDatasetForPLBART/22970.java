    public boolean dispatchKeyEvent(@NonNull KeyEvent ke) {
        try {
            if (ke.getAction() == KeyEvent.ACTION_DOWN) {
                int currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
                if (ke.getKeyCode() == KeyEvent.KEYCODE_VOLUME_UP) {
                    if (currentVolume < am.getStreamMaxVolume(AudioManager.STREAM_MUSIC)) {
                        am.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume + 1, 0);
                    }
                } else if (ke.getKeyCode() == KeyEvent.KEYCODE_VOLUME_DOWN) {
                    if (currentVolume > 0) {
                        am.setStreamVolume(AudioManager.STREAM_MUSIC, currentVolume - 1, 0);
                    }
                } else if (ke.getKeyCode() == KeyEvent.KEYCODE_SEARCH) {
                    showPlayList();
                } else if (ke.getKeyCode() == KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE) {
                    playpause();
                } else if (ke.getKeyCode() == KeyEvent.KEYCODE_MEDIA_PLAY) {
                    play();
                } else if (ke.getKeyCode() == KeyEvent.KEYCODE_MEDIA_PAUSE) {
                    pause();
                } else if (ke.getKeyCode() == KeyEvent.KEYCODE_MEDIA_STOP) {
                    stop();
                } else if (ke.getKeyCode() == KeyEvent.KEYCODE_MEDIA_NEXT) {
                    next();
                } else if (ke.getKeyCode() == KeyEvent.KEYCODE_MEDIA_PREVIOUS) {
                    previous();
                } else if (ke.getKeyCode() == KeyEvent.KEYCODE_MEDIA_FAST_FORWARD) {
                    forward();
                } else if (ke.getKeyCode() == KeyEvent.KEYCODE_MEDIA_REWIND) {
                    backward();
                }
            }
        } catch (Exception e) {
            // Toast.makeText(getApplicationContext(), getString(R.string.exception) + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        } catch (Error e) {
            // Toast.makeText(getApplicationContext(), getString(R.string.exception) + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
        return super.dispatchKeyEvent(ke);
    }

