        /**
         * {@inheritDoc}
         */
        @Override
        public void onConcurrentException(Exception cause) {
            //Capture the exception
            ExceptionUtil.translateException(SearchActivity.this, cause);
        }

