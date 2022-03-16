    @Override
    public void onItemClicked(int position) {
        if (actionMode != null) {
            toggleSelection(position);
        } else {
            Intent playerActivity = new Intent(this, SwipePlayerActivity.class);
            playerActivity.putParcelableArrayListExtra(SwipePlayerActivity.SONGS_PARAM, (ArrayList<? extends Parcelable>) songs);
            playerActivity.putExtra(SwipePlayerActivity.SONG_POSITION_PARAM, position);
            startActivity(playerActivity);
        }
    }

