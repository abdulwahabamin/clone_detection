    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);

        if (PlaylistActivity.currentPlaylist.length() == 0) {
            MenuItem item = menu.findItem(R.id.delete_playlist);
            item.setVisible(false);
        }
        return true;
    }

