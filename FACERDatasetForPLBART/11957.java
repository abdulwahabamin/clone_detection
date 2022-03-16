        /**
         * Constructor of <code>Mode</code>
         *
         * @param id The command identifier
         * @param flag The tar compression flag
         * @param mode The uncompressed mode
         */
        private Mode(String id, String flag, UncompressionMode mode) {
            this.mId = id;
            this.mFlag = flag;
            this.mMode = mode;
        }

