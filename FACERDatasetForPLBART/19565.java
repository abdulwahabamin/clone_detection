        @Override
        public void onServiceCursorUpdated(Cursor cursor) {
            //Make sure the new cursor and the old cursor are the same size.
            if (getCursor().getCount()==cursor.getCount()) {
                setCursor(cursor);
            }

        }

