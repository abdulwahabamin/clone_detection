    /**
     * {@inheritDoc}
     */
    @Override
    public void onRequestRefresh(Object o, boolean clearSelection) {
        if (o instanceof FileSystemObject) {
            refresh((FileSystemObject)o);
        } else if (o == null) {
            refresh();
        }
        if (clearSelection) {
            onDeselectAll();
        }
    }

