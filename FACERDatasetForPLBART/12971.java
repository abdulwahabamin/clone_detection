    /**
     * {@inheritDoc}
     */
    @Override
    public void onTextChanged(String newValue, List<String> currentFilterData) {
        String value = newValue;

        //Check if directory is valid
        if (value.length() == 0) {
            if (this.mOnValidationListener != null) {
                this.mOnValidationListener.onVoidValue();
            }
        } else {
            boolean relative = FileHelper.isRelativePath(value);
            if (relative) {
                if (this.mOnValidationListener != null) {
                    this.mOnValidationListener.onInvalidValue();
                }
            } else {
                if (this.mOnValidationListener != null) {
                    this.mOnValidationListener.onValidValue();
                }
            }
        }

        //Ensure data
        if (!value.startsWith(File.separator)) {
            currentFilterData.clear();
            this.mLastParent = ""; //$NON-NLS-1$
            return;
        }

        //Get the new parent
        String newParent = FileHelper.getParentDir(new File(value));
        if (newParent == null) {
            newParent = FileHelper.ROOT_DIRECTORY;
        }
        if (!newParent.endsWith(File.separator)) {
            newParent += File.separator;
        }
        if (value.compareTo(File.separator) == 0) {
            newParent = File.separator;
            currentFilterData.clear();
        } else if (value.endsWith(File.separator)) {
            //Force the change of parent
            newParent = new File(value, "a").getParent(); //$NON-NLS-1$
            if (!newParent.endsWith(File.separator)) {
                newParent += File.separator;
            }
            currentFilterData.clear();
        } else {
            value = newParent;
        }

        //If a new path is detected, then load the new data
        if (newParent.compareTo(this.mLastParent) != 0 || currentFilterData.isEmpty()) {
            this.mLastParent = newParent;
            currentFilterData.clear();
            try {
                List<String> newData =
                        CommandHelper.quickFolderSearch(getContext(), value, null);
                currentFilterData.addAll(newData);
            } catch (Throwable ex) {
                Log.e(TAG, "Quick folder search failed", ex); //$NON-NLS-1$
                currentFilterData.clear();
            }
        }
    }

