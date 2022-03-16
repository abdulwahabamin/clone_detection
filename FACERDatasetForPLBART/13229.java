        @Override
        public String getMimeType(String absolutePath, String extension) {
            MediaMetadataRetriever retriever = new MediaMetadataRetriever();
            try {
                retriever.setDataSource(absolutePath);
                boolean hasVideo =
                        retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_HAS_VIDEO) !=
                        null;
                if (is3GPP(extension)) {
                    return hasVideo ? VIDEO_3GPP_MIME_TYPE : AUDIO_3GPP_MIME_TYPE;
                } else if (is3GPP2(extension)) {
                    return hasVideo ? VIDEO_3GPP2_MIME_TYPE : AUDIO_3GPP2_MIME_TYPE;
                }
            } catch (RuntimeException e) {
                Log.e(TAG, "Unable to open 3GP file to determine mimetype");
            } finally {
                retriever.release();
            }
            // Default to video 3gp if the file is unreadable as this was the default before
            // ambiguous resolution support was added.
            return VIDEO_3GPP_MIME_TYPE;
        }

