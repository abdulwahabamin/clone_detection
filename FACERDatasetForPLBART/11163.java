    /**
     * {@inheritDoc}
     */
    @Override
    public void onNavigateTo(Object o) {
        if (o instanceof FileSystemObject) {
            back(false, (FileSystemObject) o, true);
        }
    }

