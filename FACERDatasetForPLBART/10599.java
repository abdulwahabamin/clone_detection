    /**
     * Method that extract the first element in the queue
     *
     * @return The item extracted
     * @throws EmptyQueueException If the queue hasn't element
     */
    public T remove() throws EmptyQueueException {
        synchronized (this.mQueue) {
            return noSynchronizedRemove();
        }
    }

