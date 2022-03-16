    @Override
    public void playlistChosen(int position) {
        List<Playlist> playlists = MusicDataUtility.getPlayists(this);
        Playlist playlistSelected = playlists.get(position);

        List<Song> songs = MusicDataUtility.getSongsFromList(musicContent, this);
        if (songs != null) {
            Realm realm = Realm.getInstance(PlaylistActivity.this);
            realm.beginTransaction();
            List<Integer> selectedSongs = songListAdapter.getSelectedItems();
            for (int j = 0; j < selectedSongs.size(); j++) {
                Song song = songs.get(selectedSongs.get(j));
                byte[] imageData = MusicDataUtility.getImageData(song.getSongLocation());
                if (imageData != null) {
                    playlistSelected.setCoverPath(song.getSongLocation());
                }
                playlistSelected.getSongs().add(song);
            }
            realm.commitTransaction();
            realm.close();
        }
        songListAdapter.clearSelection();
        actionMode.finish();
    }

