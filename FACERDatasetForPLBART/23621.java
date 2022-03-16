    private void setSaveButton() {
        String typedname = mPlaylist.getText().toString(); 
        if (idForplaylist(typedname) >= 0
                && ! mOriginalName.equals(typedname)) {
            mSaveButton.setText(R.string.create_playlist_overwrite_text);
        } else {
            mSaveButton.setText(R.string.create_playlist_create_text);
        }
    }

