        /**
         * This method is called from a background thread by the list view
         * when the user has typed a letter that should result in a filtering
         * of the displayed items.  It returns a Cursor, when will then be
         * handed to changeCursor.
         */
        @Override
        public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
            if (DBG) Log.v(TAG, "Getting new cursor...");
            return doQuery(true, constraint.toString());
        }

