    @Override
    public void onItemClicked(int position) {
        MusicContent musicContent = new MusicContent();
        musicContent.setContentType(ContentType.ALBUM);
        musicContent.setPlaylistName(((AlbumGridAdapter) albumGrid.getAdapter()).getItem(position).getAlbumTitle());
        musicContent.setId(((AlbumGridAdapter) albumGrid.getAdapter()).getItem(position).getId());

        Intent intent = new Intent(ArtistActivity.this, PlaylistActivity.class);
        intent.putExtra("musicContent", musicContent);
        startActivity(intent);
    }

