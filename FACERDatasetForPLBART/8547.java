    /**
     * Method that creates an executable for make searches over the filesystem.
     *
     * @param directory The directory where to search
     * @param query The term of the query
     * @param asyncResultListener The listener where to return partial results
     * @return FindExecutable A {@link FindExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    FindExecutable createFindExecutable(
            String directory, Query query, ConcurrentAsyncResultListener asyncResultListener)
            throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

