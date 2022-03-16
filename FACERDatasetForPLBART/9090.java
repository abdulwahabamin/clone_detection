        /**
         * Invoked when a request the program need to write in the shell program.
         *
         * @param data The data to write to the shell console
         * @param offset The initial position in buffer to store the bytes read from this stream
         * @param byteCount The maximum number of bytes to store in b
         * @return boolean If the write was transmitted successfully
         * @throws ExecutionException If the console is not ready
         */
        boolean onRequestWrite(byte[] data, int offset, int byteCount) throws ExecutionException;

