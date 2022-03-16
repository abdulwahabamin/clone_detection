    @Override
    protected Void doInBackground(Object... params) {
        Random random = new Random();
        long playlistId = (Long)params[0];
        long[] songs = (long[])params[1];
        for (int i=0; i < songs.length; i++) {
            int randomPosition = random.nextInt(songs.length);
            MediaStore.Audio.Playlists.Members.moveItem(context.getContentResolver(), playlistId, i, randomPosition);
        }

        return null;
    }

