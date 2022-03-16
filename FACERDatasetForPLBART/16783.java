    private void onPlaybackStateChanged(PlaybackStateCompat state) {
        FireLog.d(TAG, "(++) onPlaybackStateChanged " + state);
        if (getActivity() == null) {
            FireLog.w(TAG, "onPlaybackStateChanged called when getActivity null," +
                    "this should not happen if the callback was properly unregistered. Ignoring.");
            return;
        }
        if (state == null) {
            return;
        }
        boolean enablePlay = false;
        switch (state.getState()) {
            case PlaybackStateCompat.STATE_PAUSED:
            case PlaybackStateCompat.STATE_STOPPED:
                enablePlay = true;
                break;
            case PlaybackStateCompat.STATE_ERROR:
                FireLog.e(TAG, "error playbackstate: " + state.getErrorMessage());
                Toast.makeText(getActivity(), state.getErrorMessage(), Toast.LENGTH_LONG).show();
                break;
        }

        if (enablePlay) {
            playPause.setImageDrawable(
                    ContextCompat.getDrawable(getActivity(), R.drawable.ic_media_play));
        } else {
            playPause.setImageDrawable(
                    ContextCompat.getDrawable(getActivity(), R.drawable.ic_media_pause));
        }

    }

