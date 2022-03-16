	/**
	 * Updates all remote control clients (including the lockscreen controls).
	 */
	public void updateRemoteControlClients(SongHelper songHelper) {
		try {
            //Update the remote controls

            mRemoteControlClientCompat.editMetadata(true)
                    .putString(MediaMetadataRetriever.METADATA_KEY_ARTIST, getCurrentSong().getArtist())
                    .putString(MediaMetadataRetriever.METADATA_KEY_TITLE, getCurrentSong().getTitle())
                    .putString(MediaMetadataRetriever.METADATA_KEY_ALBUM, getCurrentSong().getAlbum())
                    .putLong(MediaMetadataRetriever.METADATA_KEY_DURATION, getCurrentMediaPlayer().getDuration())
                    .putBitmap(RemoteControlClientCompat.MetadataEditorCompat.METADATA_KEY_ARTWORK, getCurrentSong().getAlbumArt())

                    .apply();

            if (mRemoteControlClientCompat!=null) {

                if (getCurrentMediaPlayer().isPlaying())
                    mRemoteControlClientCompat.setPlaybackState(RemoteControlClient.PLAYSTATE_PLAYING);
                else
                    mRemoteControlClientCompat.setPlaybackState(RemoteControlClient.PLAYSTATE_PAUSED);

            }

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

