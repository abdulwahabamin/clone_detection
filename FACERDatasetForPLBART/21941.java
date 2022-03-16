    public static void shuffleAll(final Context context) {
        Cursor cursor = SongLoader.makeSongCursor(context, null, null);
        final long[] trackList = SongLoader.getSongListForCursor(cursor);
        if (trackList.length == 0 || mService == null) {
            return;
        }
        try {
            mService.setShuffleMode(MusicService.SHUFFLE_NORMAL);
            if (getQueuePosition() == 0 && mService.getAudioId() == trackList[0] && Arrays.equals(trackList, getQueue())) {
                mService.play();
                return;
            }
            mService.open(trackList, -1, -1, IdType.NA.mId);
            mService.play();
            cursor.close();
        } catch (final RemoteException ignored) {
        }
    }

