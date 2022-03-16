        /**
         * When a new line is ready
         *
         * @param newline The newline detected
         * @param start The start position of the new line within the input text
         * @param end The end position of the new line within the input text
         * @param sep The line separator detected
         * @return boolean If processor must continue with the next line
         */
        boolean onNewLine(CharSequence newline, int start, int end, CharSequence sep);

