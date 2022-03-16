    /**
     * Method that returns if the queue is empty
     *
     * @return boolean If the queue is empty
     */
    public boolean isEmpty() {
        synchronized (this.mQueue) {
            return this.mQueue[this.mTail] == null;
        }
    }

