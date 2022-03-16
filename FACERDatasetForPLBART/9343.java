        /**
         * Find end control pattern indices
         * @param bytes byte array to check against
         * @param getExitIndices if true, this method will return the indices of the values
         *                       in between the end control pattern (e.g. exit code), otherwise
         *                       it will return the start and end indices of the whole end pattern
         * @return if {@code getExitIndices} is false, See {@link #findControlPattern(byte[], byte[])}
         *         otherwise it will return values as described in {@code getExitIndices}
         */
        public int[] getEndControlMatch(byte[] bytes, boolean getExitIndices) {
            // in the end control pattern, we check for endId1, 1-3 chars for exit code, endId2
            int start, end;

            final int[] end1PatternResult = findControlPattern(bytes, mEndId1.getBytes());
            if (end1PatternResult != null) {
                start = end1PatternResult[0];

                final int[] end2PatternResult = findControlPattern(bytes, mEndId2.getBytes());
                if (end2PatternResult != null) {
                    if (getExitIndices) {
                        return new int[]{end1PatternResult[1], end2PatternResult[0]};
                    }

                    end = end2PatternResult[1];
                    return new int[]{start, end};
                }
            }
            return null;
        }

