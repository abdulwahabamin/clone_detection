    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.main:
                SongContent.ITEMS = new ArrayList<>(SongContent.ALL_SONGS);
                mAdapter.notifyDataSetChanged();
                Intent reloadIntent = new Intent(ItemListActivity.this, ItemListActivity.class);
                startActivity(reloadIntent);
                break;
            case R.id.playlists:
                Intent menuIntent = new Intent(ItemListActivity.this, PlaylistActivity.class);
                startActivity(menuIntent);
                break;
            case R.id.delete_playlist:
                ItemListActivity.mydatabase.delete("Playlists", "name = ?", new String[] {PlaylistActivity.currentPlaylist});
                PlaylistActivity.playlistNames.remove(PlaylistActivity.currentPlaylist);
                PlaylistActivity.currentPlaylist = "";
                SongContent.ITEMS = new ArrayList<>(SongContent.ALL_SONGS);
                Intent deleteIntent = new Intent(ItemListActivity.this, ItemListActivity.class);
                startActivity(deleteIntent);
        }

        return super.onOptionsItemSelected(item);
    }

