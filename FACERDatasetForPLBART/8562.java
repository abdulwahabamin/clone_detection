    /**
     * Method that creates an executable for read data from disk.
     *
     * @param file The file where to read the data
     * @param asyncResultListener The listener where to return partial results
     * @return ReadExecutable A {@link ReadExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    ReadExecutable createReadExecutable(
            String file, AsyncResultListener asyncResultListener)
            throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

