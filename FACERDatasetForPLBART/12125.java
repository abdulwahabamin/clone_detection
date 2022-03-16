        /**
         * Checks whether {@code controlBytes} exists inside of {@code bytes} and returns the start
         * and end indices if it does. Returns null otherwise.
         *
         * @param bytes where to look for the pattern
         * @param controlBytes the pattern to search for
         * @return if {@code controlBytes} was found inside of {@code bytes} then this method will
         * return an int[] array of length 2:
         * <ul>
         * <li>[0] the starting index of the control pattern
         * <li>[1] the ending index of the control pattern + 1 (like {{@link java.lang.String#substring(int, int)})
         * </ul>
         */
        private int[] findControlPattern(byte[] bytes, byte[] controlBytes) {
            if (bytes.length >= controlBytes.length) {
                for (int i = 0; i < bytes.length; i++) {
                    boolean foundControlBytePattern = true;
                    int patternEnd = -1;
                    if (bytes[i] == controlBytes[0]) {
                        int start = i;
                        for (int j = start; j < controlBytes.length + start; j++) {
                            if (j > bytes.length - 1) {
                                foundControlBytePattern = false;
                                break;
                            }
                            if (bytes[j] != controlBytes[j - start]) {
                                foundControlBytePattern = false;
                                break;
                            } else {
                                patternEnd = j;
                            }
                        }
                        if (foundControlBytePattern) {
                            return new int[]{start, patternEnd+1};
                        }
                    }
                }
            }
            return null;
        }

