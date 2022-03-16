    public SortingCursorWrapper(Cursor cursor, int sortOrder) {
        mCursor = cursor;

        final int count = cursor.getCount();
        mPosition = new int[count];
        switch (sortOrder) {
            case SORT_ORDER_DISPLAY_NAME:
                mValueString = new String[count];
                mValueLong = null;
                break;
            case SORT_ORDER_LAST_MODIFIED:
            case SORT_ORDER_SIZE:
                mValueString = null;
                mValueLong = new long[count];
                break;
            default:
                throw new IllegalArgumentException();
        }

        cursor.moveToPosition(-1);
        for (int i = 0; i < count; i++) {
            cursor.moveToNext();
            mPosition[i] = i;

            switch (sortOrder) {
                case SORT_ORDER_DISPLAY_NAME:
                    final String mimeType = getCursorString(cursor, Document.COLUMN_MIME_TYPE);
                    final String displayName = getCursorString(
                            cursor, Document.COLUMN_DISPLAY_NAME);
                    if (Document.MIME_TYPE_DIR.equals(mimeType)) {
                        mValueString[i] = '\001' + displayName;
                    } else {
                        mValueString[i] = displayName;
                    }
                    break;
                case SORT_ORDER_LAST_MODIFIED:
                    mValueLong[i] = getCursorLong(cursor, Document.COLUMN_LAST_MODIFIED);
                    break;
                case SORT_ORDER_SIZE:
                    mValueLong[i] = getCursorLong(cursor, Document.COLUMN_SIZE);
                    break;
            }
        }

        switch (sortOrder) {
            case SORT_ORDER_DISPLAY_NAME:
                synchronized (SortingCursorWrapper.class) {

                    binarySort(mPosition, mValueString);
                }
                break;
            case SORT_ORDER_LAST_MODIFIED:
            case SORT_ORDER_SIZE:
                binarySort(mPosition, mValueLong);
                break;
        }
    }

