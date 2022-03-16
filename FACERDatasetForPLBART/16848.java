        @Override
        public void onClick(View v) {
            MediaControllerCompat.TransportControls controls = MediaControllerCompat
                    .getMediaController(NowPlayingActivity.this).getTransportControls();
            switch (v.getId()) {

                case R.id.previous:
                    controls.skipToPrevious();
                    break;
                case R.id.playPause:
                    PlaybackStateCompat state = MediaControllerCompat
                            .getMediaController(NowPlayingActivity.this).getPlaybackState();
                    if (state != null) {

                        switch (state.getState()) {
                            case PlaybackStateCompat.STATE_PLAYING: // fall through
                            case PlaybackStateCompat.STATE_BUFFERING:
                                controls.pause();
                                stopSeekbarUpdate();
                                break;
                            case PlaybackStateCompat.STATE_PAUSED:
                            case PlaybackStateCompat.STATE_STOPPED:
                                controls.play();
                                scheduleSeekbarUpdate();
                                break;
                            default:
                                FireLog.d(TAG, "onClick with state " + state.getState());
                        }
                    }
                    break;
                case R.id.next:
                    controls.skipToNext();
                    break;
            }

        }

