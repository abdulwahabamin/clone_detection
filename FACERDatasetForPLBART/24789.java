    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.gotocurrentsong)
        {
            if (PlayerConstants.SONG_NUMBER>-1 && PlayerConstants.SONG_NUMBER+1<=PlayerConstants.SONGS_LIST.size())
                mRecyclerView.smoothScrollToPosition(PlayerConstants.SONG_NUMBER);

            return true;
        }
        else if (item.getItemId()==R.id.openmusicplayer){
            if (!isUp()) {
                goUp();
            }
        }
        return false;
    }

