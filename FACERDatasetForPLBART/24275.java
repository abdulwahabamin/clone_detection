    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.genre_play_all_now:
                playAllNow();
                return true;

            case R.id.genre_play_all_next:
                playAllNext();
                return true;

            case R.id.genre_queue_all:
                queueAll();
                return true;

            case R.id.genre_interleave_all:
                interleaveAll(item);
                return true;

            case R.id.genre_new_playlist:
                newPlaylist();
                return true;

            case R.id.genre_selected_playlist:
                selectedPlaylist(item);
                return true;

            case R.id.genre_delete_all:
                deleteAll();
                return true;

            case R.id.genre_search_for_category:
                searchForCategory();
                return true;
        }
        return super.onContextItemSelected(item);
    }

