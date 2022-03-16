        @Override
        public void onClick(DialogInterface dialog, int which) {

            String name = mPlaylist.getText().toString();
            MusicUtils.renamePlaylist(PlaylistDialog.this, mRenameId, name);
            finish();
        }

