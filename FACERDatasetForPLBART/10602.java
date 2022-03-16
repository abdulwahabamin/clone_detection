    /**
     * Method that retrieves all the items from the queue. This method doesn't remove any item
     * from queue.
     *
     * @return The items retrieved
     * @throws EmptyQueueException If the queue hasn't element
     */
    public List<T> peekAll() throws EmptyQueueException {
        synchronized (this.mQueue) {
            if (isEmpty()) throw new EmptyQueueException();
            List<T> l = new ArrayList<T>();
            int head = this.mHead;
            int tail = this.mTail;
            do {
                l.add((T)this.mQueue[tail]);
                tail++;
                if (tail >= this.mSize) {
                    tail = 0;
                }
            } while (head != tail);
            return l;
        }
    }

