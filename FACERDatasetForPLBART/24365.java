    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        updatePlaylistItems(menu);

        updateSoundEffectItem(menu);

        updateRepeatItem(menu);

        updatePlayingItems(menu);

        return true;
    }

