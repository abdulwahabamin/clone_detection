    /**
     * Method that creates an executable for send a signal to the current process.
     *
     * @param process The process which to send the signal
     * @param signal The signal to send
     * @return SendSignalExecutable A {@link SendSignalExecutable} executable implementation reference
     * @throws CommandNotFoundException If the executable can't be created
     * @throws NoSuchFileOrDirectory If the file or directory was not found
     * @throws InsufficientPermissionsException If an operation requires elevated permissions
     */
    SendSignalExecutable createSendSignalExecutable(
            int process, SIGNAL signal) throws CommandNotFoundException,
            NoSuchFileOrDirectory, InsufficientPermissionsException;

