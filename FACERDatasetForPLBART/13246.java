        /**
         * {@inheritDoc}
         */
        @Override
        public void onAsyncEnd(boolean cancelled) {
            if (this.mRef != null) {
                this.mRef.onAsyncEnd(cancelled);
            }
        }

