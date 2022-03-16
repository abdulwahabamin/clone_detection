        public AsyncReader(ParcelFileDescriptor fdIn, ParcelFileDescriptor fdOut,
                CancellationSignal signal) throws IOException {
            super();
            mFdIn = fdIn;
            mFdOut = fdOut;
            mOut = new ParcelFileDescriptor.AutoCloseOutputStream(fdOut);
            mSignal = signal;
        }

