    private List<BaseVisitable> getVisitableList(List<MediaSessionCompat.QueueItem> queue) {
        List<BaseVisitable> visitableList = new ArrayList<>();
        int index = 0;
        for (MediaSessionCompat.QueueItem item : queue) {
            QueueItemVisitable visitable = new QueueItemVisitable(item);
            visitable.setOnClickListener(mQueueItemOnClickListener);
            visitable.setIndexToDisplay(index);
            visitableList.add(visitable);
            index++;
        }

        return visitableList;
    }

