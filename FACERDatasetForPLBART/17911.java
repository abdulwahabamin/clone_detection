    private void updateQueue(List<MediaSessionCompat.QueueItem> queue) {
        if (queue == null) {
            return;
        }

        mMvpView.displayQueue(queue);
    }

