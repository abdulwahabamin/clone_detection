    @Override
    public synchronized void doShuffle() {
        Random random = new Random();
        for (int i = 0; i < mPlayListLen; i++) {
            if (i != mPlayPos) {
                int randomPosition = random.nextInt(mPlayListLen);
                while (randomPosition == mPlayPos) randomPosition = random.nextInt(mPlayListLen);
                long temp = mPlayList[i];
                mPlayList[i] = mPlayList[randomPosition];
                mPlayList[randomPosition] = temp;
            }
        }
        notifyChange(QUEUE_CHANGED);
    }

