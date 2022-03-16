    /**
     * Method that returns the secure console instance
     *
     * @return SecureConsole The secure console
     */
    private SecureConsole getSecureConsole() {
        int bufferSize = getActivity().getResources().getInteger(R.integer.buffer_size);
        return SecureConsole.getInstance(getActivity(), bufferSize);
    }

