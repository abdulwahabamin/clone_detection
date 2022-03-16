        /**
         * Method that replace a key char
         *
         * @param value The string in which search
         * @param key The key char to search
         * @param removeAfter If true the string will truncate after the first key char found
         * @return String The replaced string
         */
        private String replaceKeyEvent(String value, char key, boolean removeAfter) {
            String text = value;
            int pos = text.indexOf(key);
            while (pos != -1) {
                if (removeAfter) {
                    text = text.substring(0, pos);
                } else {
                    text = text.replaceAll(String.valueOf(key), ""); //$NON-NLS-1$
                }
                pos = text.indexOf(key);
            }
            return text;
        }

