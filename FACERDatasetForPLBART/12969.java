    /**
     * Method that initializes the view. This method loads all the necessary
     * information and create an appropriate layout for the view
     */
    private void init() {
        //Sets last parent
        this.mLastParent = ""; //$NON-NLS-1$

        //Set the listener
        setOnTextChangedListener(this);
        setCompletionString(File.separator);
    }

