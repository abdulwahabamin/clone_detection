        @Override
        public void onClick(DialogInterface dialog, int which) {

            String name = mPlaylist.getText().toString();
            if (name != null && name.length() > 0) {
                int id = idForplaylist(name);
                if (id >= 0) {
                    MusicUtils.clearPlaylist(PlaylistDialog.this, id);
                    MusicUtils.addToPlaylist(PlaylistDialog.this, mList, id);
                } else {
                    long new_id = MusicUtils.createPlaylist(PlaylistDialog.this, name);
                    if (new_id >= 0) {
                        MusicUtils.addToPlaylist(PlaylistDialog.this, mList, new_id);
                    }
                }
                finish();
            }
        }

