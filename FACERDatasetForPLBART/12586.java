    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        // Retrieve the authorization
        AuthorizationResource authResource = getAuthorizacionResourceForUri(uri);
        if (authResource == null) {
            throw new SecurityException("Authorization not exists");
        }

        // Create an in-memory cursor
        String[] cols = new String[COLUMN_PROJECTION.length];
        Object[] values = new Object[COLUMN_PROJECTION.length];
        for (int i = 0; i < COLUMN_PROJECTION.length; i++) {
            cols[i] = COLUMN_PROJECTION[i];
            switch (i) {
                case 0:
                    values[i] = uri.getLastPathSegment();
                    break;
                case 1:
                    values[i] = authResource.mFile.getName();
                    break;
                case 2:
                    values[i] = authResource.mFile.getSize();
                    break;

                default:
                    break;
            }
        }

        final MatrixCursor cursor = new MatrixCursor(cols, 1);
        cursor.addRow(values);
        return cursor;
    }

