    private void playerNotification(String action) {
        Intent intent = new Intent(getContext().getApplicationContext(), MediaPlayerService.class);
        intent.setAction(action);
        intent.putExtra(SONG_PARAM, rhythmSong);
        intent.putExtra(SONG_POSITION_PARAM, songPosition);
        getActivity().startService(intent);
    }

