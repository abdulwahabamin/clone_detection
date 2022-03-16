    @Override
    public void onSongClicked(Cursor songCursor, int position) {
        songCursor.moveToPosition(position);

        playQueue = new PlayQueue(songCursor);

        Intent intent = new Intent(getContext(), PlayerActivity.class);
        intent.putExtra(PlayerActivity.EXTRA_PLAY_QUEUE, playQueue);
        getActivity().startActivity(intent);
    }

