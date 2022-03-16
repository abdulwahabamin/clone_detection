        /**
         * Constructor of <code>AsyncReader</code>. For enclosing access.
         */
        public AsyncReader(boolean detectEncoding) {
            super();
            mDetectEncoding = detectEncoding;
            if (mDetectEncoding) {
                mDetector = new UniversalDetector(null);
            }
        }

