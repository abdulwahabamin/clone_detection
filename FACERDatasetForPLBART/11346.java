    /**
     * Method that creates an executable for write data to disk.
     *
     * @param file The file where to write the data
     * @param asyncResultListener The listener where to return partial results
     * @return WriteExecutable A {@link WriteExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    WriteExecutable createWriteExecutable(
            String file, AsyncResultListener asyncResultListener)
            throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

