    private void removeSongs() {
        Realm realm = Realm.getInstance(PlaylistActivity.this);
        realm.beginTransaction();
        Playlist playlist = realm.where(Playlist.class)
                .contains("id", musicContent.getId())
                .findFirst();
        List<Integer> selectedSongs = songListAdapter.getSelectedItems();
        RealmList<Song> remainingSongs = playlist.getSongs();
        for (int i = selectedSongs.size() - 1; i >= 0; i--) {
            remainingSongs.remove(remainingSongs.get(selectedSongs.get(i)));
        }
        realm.commitTransaction();
        realm.close();
        songListAdapter.clearSelection();
        populateSongs();
        actionMode.finish();

    }

