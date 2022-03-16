    /**
     * Method that forces the view to scroll to the file system object passed.
     *
     * @param fso The file system object
     */
    public void scrollTo(final FileSystemObject fso) {

        this.mAdapterView.post(new Runnable() {

            @Override
            public void run() {
                if (fso != null) {
                    try {
                        int position = mAdapter.getPosition(fso);
                        mAdapterView.setSelection(position);

                        // Make the scrollbar appear
                        if (position > 0) {
                            mAdapterView.scrollBy(0, 1);
                            mAdapterView.scrollBy(0, -1);
                        }

                    } catch (Exception e) {
                        mAdapterView.setSelection(0);
                    }
                } else {
                    mAdapterView.setSelection(0);
                }
            }
        });

    }

