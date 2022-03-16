    /**
     * Method that extracts the message from the queue
     *
     * @param String The message
     * @throws EmptyQueueException If there are not message in the queue
     * @hide
     */
    String extractMsg() throws EmptyQueueException {
        // Extract all items from the queue
        List<String> l = this.mQueue.peekAll();
        StringBuilder sb = new StringBuilder();
        for (String s : l) {
            sb.append(s);
            sb.append("\n"); //$NON-NLS-1$
        }
        return sb.toString();
    }

