    /**
     * Constructor of <code>FixedQueue</code>
     *
     * @param size The size of the queue. The limit of objects in queue. Beyond this limits
     * the older objects are recycled.
     */
    public FixedQueue(int size) {
        super();
        this.mQueue = new Object[size];
        this.mSize = size;
        this.mHead = 0;
        this.mTail = 0;
    }

