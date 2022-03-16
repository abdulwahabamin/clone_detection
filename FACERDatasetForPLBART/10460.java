        /**
         * {@inheritDoc}
         */
        @Override
        public void onPartialResult(Object result) {
            if (this.mRef != null) {
                this.mRef.onPartialResult(result);
            }
        }

