    /**
     * Creates a {@link android.media.RemoteControlClient.MetadataEditor}.
     * @param startEmpty Set to false if you want the MetadataEditor to contain the metadata that
     *     was previously applied to the RemoteControlClient, or true if it is to be created empty.
     * @return a new MetadataEditor instance.
     */
    public MetadataEditorCompat editMetadata(boolean startEmpty) {
        Object metadataEditor;
        if (sHasRemoteControlAPIs) {
            try {
                metadataEditor = sRCCEditMetadataMethod.invoke(mActualRemoteControlClient,
                        startEmpty);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            metadataEditor = null;
        }
        return new MetadataEditorCompat(metadataEditor);
    }

