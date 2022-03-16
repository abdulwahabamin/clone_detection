    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.main:
                SongContent.ITEMS = new ArrayList<>(SongContent.ALL_SONGS);
                Intent menuIntent = new Intent(PlaylistActivity.this, ItemListActivity.class);
                startActivity(menuIntent);
                break;
            case R.id.playlists:
                break;

        }

        return super.onOptionsItemSelected(item);
    }

