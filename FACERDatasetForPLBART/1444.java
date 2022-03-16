        /**
         * Releases the semaphore, so we can send the next message. It's only used when sending
         * messages via events.
         */
        public void nextMessage(){
            mSemaphore.release();
        }

