    @Override
    public void closeCursors() {
        if(songAdapter != null) {
            songAdapter.closeCursor();
        }
    }

