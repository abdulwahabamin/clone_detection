    /**
     * Constructs a new JSONException with the specified cause.
     */
    public JSONException(Throwable cause) {
        super(cause.getMessage());
        this.cause = cause;
    }

