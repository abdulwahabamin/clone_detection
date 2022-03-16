    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.artist_play_all_now:
                playAllNow();
                return true;

            case R.id.artist_play_all_next:
                playAllNext();
                return true;

            case R.id.artist_queue_all:
                queueAll();
                return true;

            case R.id.artist_interleave_all:
                interleaveAll(item);
                return true;

            case R.id.artist_new_playlist:
                newPlaylist();
                return true;

            case R.id.artist_selected_playlist:
                selectedPlaylist(item);
                return true;

            case R.id.artist_delete_all:
                deleteAll();
                return true;

            case R.id.artist_search_for_category:
                searchForCategory();
                return true;
        }
        return super.onContextItemSelected(item);
    }

