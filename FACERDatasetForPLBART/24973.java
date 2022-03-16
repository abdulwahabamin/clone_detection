    private void deletePlaylist() {
        final List<Integer> selectedPlaylists = playlistGridAdapter.getSelectedItems();
        for (int j = selectedPlaylists.size() - 1; j >= 0; j--) {
            MusicDataUtility.deletePlaylist(playlistGridAdapter
                    .getItem(selectedPlaylists.get(j)).getId(), PlaylistGridActivity.this);
        }
        playlistGridAdapter.notifyDataSetChanged();
        if(playlistGridAdapter.getItemCount() == 0){
            noPlaylists.setVisibility(View.VISIBLE);
        }
    }

