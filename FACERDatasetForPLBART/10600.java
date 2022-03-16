    /**
     * Method that extract all the items from the queue
     *
     * @return The items extracted
     * @throws EmptyQueueException If the queue hasn't element
     */
    public List<T> removeAll() throws EmptyQueueException {
        synchronized (this.mQueue) {
            if (isEmpty()) throw new EmptyQueueException();
            List<T> l = new ArrayList<T>();
            while (!isEmpty()) {
                l.add(noSynchronizedRemove());
            }
            return l;
        }
    }

