        @Override
        public void onCommand(String command, Bundle extras, ResultReceiver cb) {
            switch (command) {
                case CMD_FAVOURITES:
                    String mediaId = extras.getString(KEY_MEDIA_ID);
                    if (mPlaylistsManager.isSongInFavourites(mediaId)) {
                        mPlaylistsManager.removeFromFavorites(mediaId);
                    } else {
                        mPlaylistsManager.addToFavorites(mediaId);
                    }
                    break;
            }
        }

