        /**
         * {@inheritDoc}
         */
        @Override
        public void onAsyncStart() {
            this.mByteBuffer = new ByteArrayOutputStream((int)this.mReadFso.getSize());
            this.mSize = 0;
        }

