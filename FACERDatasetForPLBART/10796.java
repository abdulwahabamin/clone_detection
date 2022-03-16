    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean accept(File file) {
        if (file == null) return false;
        return file.getName().toLowerCase().endsWith(EXT_PROP) ||
               file.getName().toLowerCase().endsWith(EXT_PROPERTIES);
    }

