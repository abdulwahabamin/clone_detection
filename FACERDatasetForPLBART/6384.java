    public void updateFromCursor(Cursor cursor, String authority) {
        this.authority = authority;
        this.documentId = getCursorString(cursor, Document.COLUMN_DOCUMENT_ID);
        this.mimeType = getCursorString(cursor, Document.COLUMN_MIME_TYPE);
        this.documentId = getCursorString(cursor, Document.COLUMN_DOCUMENT_ID);
        this.mimeType = getCursorString(cursor, Document.COLUMN_MIME_TYPE);
        this.displayName = getCursorString(cursor, Document.COLUMN_DISPLAY_NAME);
        this.lastModified = getCursorLong(cursor, Document.COLUMN_LAST_MODIFIED);
        this.flags = getCursorInt(cursor, Document.COLUMN_FLAGS);
        this.summary = getCursorString(cursor, Document.COLUMN_SUMMARY);
        this.size = getCursorLong(cursor, Document.COLUMN_SIZE);
        this.icon = getCursorInt(cursor, Document.COLUMN_ICON);
        this.deriveFields();
    }

