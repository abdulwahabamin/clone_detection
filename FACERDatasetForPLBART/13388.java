    /**
     * Method that inserts a new object to the queue.
     *
     * @param o The object to insert
     * @return The object inserted (for concatenation purpose)
     */
    public T insert(T o) {
        synchronized (this.mQueue) {
            if (o == null) throw new NullPointerException();
            if (this.mQueue[this.mHead] != null) {
                try {
                    noSynchronizedRemove();
                } catch (Throwable ex) {/**NON BLOCK**/}
            }
            this.mQueue[this.mHead] = o;
            this.mHead++;
            if (this.mHead >= this.mSize) {
                this.mHead = 0;
            }
            return o;
        }
    }

