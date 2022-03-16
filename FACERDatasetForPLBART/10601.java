    /**
     * Method that retrieves the first element in the queue. This method doesn't remove the item
     * from queue.
     *
     * @return The item retrieved
     * @throws EmptyQueueException If the queue hasn't element
     */
    public T peek() throws EmptyQueueException {
        synchronized (this.mQueue) {
            T o = (T)this.mQueue[this.mTail];
            if (o == null) throw new EmptyQueueException();
            return o;
        }

    }

