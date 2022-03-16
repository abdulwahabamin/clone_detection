    @Override
    public void displayQueue(List<MediaSessionCompat.QueueItem> queue) {
        mQueueAdapter = new QueueRecyclerViewAdapter(getVisitableList(queue),
                new MediaListTypeFactory());
        playingQueueRv.setAdapter(mQueueAdapter);
        playingQueueRv.invalidate();

        updateQueueIndex(mCurrentQueueIndex);
    }

