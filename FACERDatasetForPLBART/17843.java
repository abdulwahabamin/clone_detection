    @Override
    public boolean updateQueueIndex(int index) {
        if (mQueueAdapter != null) {
            mCurrentQueueIndex = index;
            mQueueAdapter.updateQueueIndex(index);
            mQueueLayoutManager.scrollToPositionWithOffset(index, 0);
            return true;
        } else {
            mCurrentQueueIndex = index;
            return false;
        }
    }

