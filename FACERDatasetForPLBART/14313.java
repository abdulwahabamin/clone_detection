    private void setSaveButton() {

        String typedname = mPlaylist.getText().toString();
        Button button = mPlaylistDialog.getButton(Dialog.BUTTON_POSITIVE);
        if (button == null)
            return;
        if (typedname.trim().length() == 0 || PLAYLIST_NAME_FAVORITES.equals(typedname)) {
            button.setEnabled(false);
        } else {
            button.setEnabled(true);
            if (idForplaylist(typedname) >= 0 && !mOriginalName.equals(typedname)) {
                button.setText(R.string.overwrite);
            } else {
                button.setText(R.string.save);
            }
        }
        button.invalidate();
    }

