    /**
     * Displays the network connection error message.
     */
    private void displayErrorMessage() {
        if (activity != null) {
            Toast.makeText(activity, R.string.error_message_no_connection, Toast.LENGTH_SHORT)
                    .show();
        }
    }

