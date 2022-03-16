        @Override
        public void handleMessage(Message msg) {
            getTrackCursor(mAdapter.getQueryHandler(), null);
            // if the query results in a null cursor, onQueryComplete() will
            // call init(), which will post a delayed message to this handler
            // in order to try again.
        }

