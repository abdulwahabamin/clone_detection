    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onSendSignal(SIGNAL signal) {
        //Send a signal to the current command on end request
        return sendSignalToCurrentCommand(signal);
    }

