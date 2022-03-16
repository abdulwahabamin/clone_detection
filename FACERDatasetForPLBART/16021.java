    @Override
    public void closeCursors() {
        if(albumAdapter != null) {
            albumAdapter.closeCursor();
        }
    }

