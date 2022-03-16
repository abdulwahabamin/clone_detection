    @Override
    public void onItemClicked(int position) {
        if (actionMode != null) {
            toggleSelection(position);
        } else {
            MusicContent musicContent = new MusicContent();
            musicContent.setContentType(ContentType.PLAYLIST);
            musicContent.setPlaylistName(playlistGridAdapter.getItem(position).getPlaylistName());
            musicContent.setId(playlistGridAdapter.getItem(position).getId());

            Intent intent = new Intent(PlaylistGridActivity.this, PlaylistActivity.class);
            intent.putExtra("musicContent", musicContent);
            startActivity(intent);
        }
    }

