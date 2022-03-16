        /**
         * Associates all the metadata that has been set since the MetadataEditor instance was
         * created with {@link android.media.RemoteControlClient#editMetadata(boolean)}, or since
         * {@link #clear()} was called, with the RemoteControlClient. Once "applied", this
         * MetadataEditor cannot be reused to edit the RemoteControlClient's metadata.
         */
        public void apply() {
            if (sHasRemoteControlAPIs) {
                try {
                    mApplyMethod.invoke(mActualMetadataEditor, (Object[]) null);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
        }

