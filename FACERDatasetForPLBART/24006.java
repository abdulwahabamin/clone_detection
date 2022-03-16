    @Override
    public synchronized void moveQueueItem(int index1, int index2) {
        if (index1 >= mPlayListLen) {
            index1 = mPlayListLen - 1;
        }
        if (index2 >= mPlayListLen) {
            index2 = mPlayListLen - 1;
        }
        if (index1 < index2) {
            long tmp = mPlayList[index1];
            System.arraycopy(mPlayList, index1 + 1, mPlayList, index1, index2 - index1);
            mPlayList[index2] = tmp;
            if (mPlayPos == index1) {
                mPlayPos = index2;
            } else if (mPlayPos >= index1 && mPlayPos <= index2) {
                mPlayPos--;
            }
        } else if (index2 < index1) {
            long tmp = mPlayList[index1];
            System.arraycopy(mPlayList, index2, mPlayList, index2 + 1, index1 - index2);
            mPlayList[index2] = tmp;
            if (mPlayPos == index1) {
                mPlayPos = index2;
            } else if (mPlayPos >= index2 && mPlayPos <= index1) {
                mPlayPos++;
            }
        }
        notifyChange(QUEUE_CHANGED);
    }

