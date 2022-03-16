        /**
         * {@inheritDoc}
         */
        @Override
        public void onException(Exception cause) {
            if (this.mRef != null) {
                this.mRef.onException(cause);
            }
        }

