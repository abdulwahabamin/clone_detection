    @Override
    public synchronized void interleave(long[] newList, int currentCount, int newCount) {
        long[] destList = new long[mPlayListLen + newList.length];

        int destI = 0;
        int currentI = 0;
        int newI = 0;
        while (destI < destList.length) {
            for (int i = 0; i < currentCount; i++) {
                if (currentI >= mPlayListLen) break;
                destList[destI++] = mPlayList[currentI++];
            }
            for (int i = 0; i < newCount; i++) {
                if (newI >= newList.length) break;
                destList[destI++] = newList[newI++];
            }
        }

        mPlayList = destList;
        mPlayListLen = mPlayList.length;
        updatePlaylist();
    }

