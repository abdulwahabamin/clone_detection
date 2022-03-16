    @Override
    public void onSaveInstanceState(Bundle outcicle) {

        if (INTENT_RENAME_PLAYLIST.equals(action)) {
            outcicle.putString(INTENT_KEY_DEFAULT_NAME, mPlaylist.getText().toString());
            outcicle.putLong(INTENT_KEY_RENAME, mRenameId);
        } else if (INTENT_CREATE_PLAYLIST.equals(action)) {
            outcicle.putString(INTENT_KEY_DEFAULT_NAME, mPlaylist.getText().toString());
        }
    }

