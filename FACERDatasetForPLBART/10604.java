    /**
     * Method that returns the number of items in the queue
     *
     * @return int The number of items
     */
    public int items() {
        int cc = 0;
        int head = this.mHead;
        int tail = this.mTail;
        do {
            cc++;
            tail++;
            if (tail >= this.mSize) {
                tail = 0;
            }
        } while (head != tail);
        return cc;
    }

