        /**
         * Method that return the mode from his compression mode
         *
         * @param mode The compression mode
         * @return Mode The mode
         */
        public static Mode fromCompressionMode(CompressionMode mode) {
            Mode[] modes = Mode.values();
            int cc = modes.length;
            for (int i = 0; i < cc; i++) {
                if (modes[i].mMode.compareTo(mode) == 0) {
                    return modes[i];
                }
            }
            return null;
        }

