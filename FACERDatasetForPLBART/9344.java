        /**
         * Find the start control pattern indices
         * @param bytes to check against
         * @return See {@link #findControlPattern(byte[], byte[])}
         */
        public int[] getStartControlMatch(byte[] bytes) {
            return findControlPattern(bytes, getStartControlPatternBytes());
        }

