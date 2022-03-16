        /**
         * Constructor of <code>CompressListener</code>
         */
        public CompressListener() {
            super();
            this.mEnd = false;
            this.mQueue = new FixedQueue<String>(2); //Holds only one item
            this.mCause = null;
        }

