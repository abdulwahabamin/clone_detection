    @Override
    public void onSaveInstanceState(Bundle outcicle) {
        // need to store the selected item so we don't lose it in case
        // of an orientation switch. Otherwise we could lose it while
        // in the middle of specifying a playlist to add the item to.
        outcicle.putLong(CURRENT_PLAYLIST, currentId);
        outcicle.putString(CURRENT_PLAYLIST_NAME, playlistName);
        super.onSaveInstanceState(outcicle);
    }

