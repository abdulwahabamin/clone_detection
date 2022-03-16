    /**
     * Method that remove one item without synchronization (for be called from
     * synchronized method).
     *
     * @return The item extracted
     * @throws EmptyQueueException If the queue hasn't element
     */
    private T noSynchronizedRemove() throws EmptyQueueException {
        T o = (T)this.mQueue[this.mTail];
        if (o == null) throw new EmptyQueueException();
        this.mQueue[this.mTail] = null;
        this.mTail++;
        if (this.mTail >= this.mSize) {
            this.mTail = 0;
        }
        return o;
    }

