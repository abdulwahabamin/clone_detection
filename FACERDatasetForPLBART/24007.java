    @Override
    public synchronized long[] getQueue() {
        int len = mPlayListLen;
        long[] list = new long[len];
        System.arraycopy(mPlayList, 0, list, 0, len);
        return list;
    }

