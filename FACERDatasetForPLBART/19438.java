        /**
         * Clears all the metadata that has been set since the MetadataEditor instance was
         * created with {@link android.media.RemoteControlClient#editMetadata(boolean)}.
         */
        public void clear() {
            if (sHasRemoteControlAPIs) {
                try {
                    mClearMethod.invoke(mActualMetadataEditor, (Object[]) null);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
        }

