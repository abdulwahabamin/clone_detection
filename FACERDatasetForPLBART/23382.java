    /**
     * Starts playback of a previously opened file.
     */
    public void play() {
        if (mPlayer.isInitialized()) {
            // if we are at the end of the song, go to the next song first
            long duration = mPlayer.duration();
            if (mRepeatMode != REPEAT_CURRENT && duration > 2000 &&
                mPlayer.position() >= duration - 2000) {
                next(true);
            }

            mPlayer.start();

            RemoteViews views = new RemoteViews(getPackageName(), R.layout.statusbar);
            views.setImageViewResource(R.id.icon, R.drawable.stat_notify_musicplayer);
            if (getAudioId() < 0) {
                // streaming
                views.setTextViewText(R.id.trackname, getPath());
                views.setTextViewText(R.id.artistalbum, null);
            } else {
                String artist = getArtistName();
                views.setTextViewText(R.id.trackname, getTrackName());
                if (artist == null || artist.equals(MediaFile.UNKNOWN_STRING)) {
                    artist = getString(R.string.unknown_artist_name);
                }
                String album = getAlbumName();
                if (album == null || album.equals(MediaFile.UNKNOWN_STRING)) {
                    album = getString(R.string.unknown_album_name);
                }
                
                views.setTextViewText(R.id.artistalbum,
                        getString(R.string.notification_artist_album, artist, album)
                        );
            }
            
            Notification status = new Notification();
            status.contentView = views;
            status.flags |= Notification.FLAG_ONGOING_EVENT;
            status.icon = R.drawable.stat_notify_musicplayer;
            status.contentIntent = PendingIntent.getActivity(this, 0,
                    new Intent("com.android.music.PLAYBACK_VIEWER"), 0);
            startForeground(PLAYBACKSERVICE_STATUS, status);
            if (!mIsSupposedToBePlaying) {
                mIsSupposedToBePlaying = true;
                notifyChange(PLAYSTATE_CHANGED);
            }

        } else if (mPlayListLen <= 0) {
            // This is mostly so that if you press 'play' on a bluetooth headset
            // without every having played anything before, it will still play
            // something.
            setShuffleMode(SHUFFLE_AUTO);
        }
    }

