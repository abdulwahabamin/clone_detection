    @Override
    public Cursor swapCursor(Cursor c) {
        Cursor res = super.swapCursor(c);
        getIndexer(c);
        return res;
    }

