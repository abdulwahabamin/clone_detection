    /**
     * Requeries the database to update the current
     * service cursor.
     */
    public void updateServiceCursor() {
        new AsyncBuildCursorTask(true).execute();

    }

