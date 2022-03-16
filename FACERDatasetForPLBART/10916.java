        /**
         * {@inheritDoc}
         */
        @Override
        public void onAsyncEnd(boolean cancelled) {
            if (!cancelled && StringHelper.isBinaryData(mByteBuffer.toByteArray())) {
                EditorActivity.this.mBinary = true;
                EditorActivity.this.mReadOnly = true;
            } else if (mDetector != null) {
                mDetector.dataEnd();
                mDetectedEncoding = mDetector.getDetectedCharset();
            }
        }

