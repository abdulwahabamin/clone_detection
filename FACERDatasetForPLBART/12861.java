        public AsyncDocumentReader(Context ctx) throws IOException {
            super();

            ParcelFileDescriptor[] fds = ParcelFileDescriptor.createReliablePipe();
            mFdIn = fds[0];
            mFdOut = fds[1];
            mIn = new ParcelFileDescriptor.AutoCloseInputStream(mFdIn);
            mOut = new ParcelFileDescriptor.AutoCloseOutputStream(mFdOut);
            mCause = null;
        }

