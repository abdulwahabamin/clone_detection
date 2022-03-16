    /**
     * Procedure completion notification. 
     * @param Message object with the following fields:
     *          .obj  - the message string
     *          .what - the event type (see above the OPERATION_... constants)
     *          .arg1 - main progress value (0-100)
     *          .arg2 - secondary progress value (0-100)
     *          .getData() - a bundle with a string NOTIFY_COOKIE 
     * @return true if it's fine to destroy the working thread 
     */
    public boolean notifyMe( Message m );

