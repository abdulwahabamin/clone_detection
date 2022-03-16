        @Override
        public void onReceive(final Context context, final Intent intent) {
            final String action = intent.getAction();
            BaseActivity baseActivity = mReference.get();
            if (baseActivity != null) {
                switch (action) {
                    case MusicService.META_CHANGED:
                        baseActivity.onMetaChanged();
                        break;
                    case MusicService.PLAYSTATE_CHANGED:
//                    baseActivity.mPlayPauseProgressButton.getPlayPauseButton().updateState();
                        break;
                    case MusicService.REFRESH:
                        baseActivity.restartLoader();
                        break;
                    case MusicService.PLAYLIST_CHANGED:
                        baseActivity.onPlaylistChanged();
                        break;
                    case MusicService.TRACK_ERROR:
                        final String errorMsg = context.getString(R.string.error_playing_track,
                                intent.getStringExtra(MusicService.TrackErrorExtra.TRACK_NAME));
                        Toast.makeText(baseActivity, errorMsg, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }

