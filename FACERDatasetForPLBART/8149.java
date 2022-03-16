        /**
         * {@inheritDoc}
         */
        @Override
        public void onPartialResult(Object result) {
            try {
                if (result == null) return;
                byte[] partial = (byte[]) result;
                if (mDetectEncoding) {
                    mDetector.handleData(partial, 0, partial.length);
                }
                this.mByteBuffer.write(partial, 0, partial.length);
                this.mSize += partial.length;
                if (this.mListener != null && this.mReadFso != null) {
                    int progress = 0;
                    if (this.mReadFso.getSize() != 0) {
                        progress = (int)((this.mSize*100) / this.mReadFso.getSize());
                    }
                    this.mListener.onProgress(progress);
                }
            } catch (Exception e) {
                this.mCause = e;
            }
        }

