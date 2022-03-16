    public void updateQueueIndex(int index) {
        int i = 0;
        for (BaseVisitable visitable : getElements()) {
            ((QueueItemVisitable) visitable).setIndexToDisplay(i - index);
            i++;
        }
        notifyDataSetChanged();
    }

