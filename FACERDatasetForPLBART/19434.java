        private MetadataEditorCompat(Object actualMetadataEditor) {
            if (sHasRemoteControlAPIs && actualMetadataEditor == null) {
                throw new IllegalArgumentException("Remote Control API's exist, " +
                        "should not be given a null MetadataEditor");
            }
            if (sHasRemoteControlAPIs) {
                Class metadataEditorClass = actualMetadataEditor.getClass();

                try {
                    mPutStringMethod = metadataEditorClass.getMethod("putString",
                            int.class, String.class);
                    mPutBitmapMethod = metadataEditorClass.getMethod("putBitmap",
                            int.class, Bitmap.class);
                    mPutLongMethod = metadataEditorClass.getMethod("putLong",
                            int.class, long.class);
                    mClearMethod = metadataEditorClass.getMethod("clear", new Class[]{});
                    mApplyMethod = metadataEditorClass.getMethod("apply", new Class[]{});
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            }
            mActualMetadataEditor = actualMetadataEditor;
        }

