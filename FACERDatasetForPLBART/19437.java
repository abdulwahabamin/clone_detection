        /**
         * Adds numerical information to be displayed.
         * Note that none of the information added after {@link #apply()} has been called,
         * will be displayed.
         * @param key the identifier of a the metadata field to set. Valid values are
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_CD_TRACK_NUMBER},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DISC_NUMBER},
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_DURATION} (with a value
         *      expressed in milliseconds),
         *      {@link android.media.MediaMetadataRetriever#METADATA_KEY_YEAR}.
         * @param value The long value for the given key
         * @return Returns a reference to the same MetadataEditor object, so you can chain put
         *      calls together.
         * @throws IllegalArgumentException
         */
        public MetadataEditorCompat putLong(int key, long value) {
            if (sHasRemoteControlAPIs) {
                try {
                    mPutLongMethod.invoke(mActualMetadataEditor, key, value);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
            return this;
        }

