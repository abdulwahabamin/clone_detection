    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        if (oldPosition == newPosition)
            return true;

        if (playQueue == null || mCursorIdxs == null || newPosition >= playQueue.length) {
            return false;
        }

        // The cursor doesn't have any duplicates in it, and is not ordered
        // in queue-order, so we need to figure out where in the cursor we should be.

        long newid = playQueue[newPosition];
        int crsridx = Arrays.binarySearch(mCursorIdxs, newid);
        mCurrentPlaylistCursor.moveToPosition(crsridx);
        mCurPos = newPosition;

        return true;
    }

