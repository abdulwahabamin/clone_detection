    /**
     * Method that loads the AIDs in background
     */
    private void loadAIDs() {
        // Load owners and groups AIDs in background
        AsyncTask<Void, Void, SparseArray<AID>> aidsTask =
                        new AsyncTask<Void, Void, SparseArray<AID>>() {
            @Override
            protected SparseArray<AID> doInBackground(Void...params) {
                return AIDHelper.getAIDs(FsoPropertiesDialog.this.mContext, true);
            }

            @Override
            protected void onPostExecute(SparseArray<AID> aids) {
                if (!isCancelled()) {
                    // Ensure that at least one AID was loaded
                    if (aids == null) {
                        String errorMsg =
                                FsoPropertiesDialog.this.mContext.getString(R.string.error_message);
                        setSpinnerMsg(
                                FsoPropertiesDialog.this.mContext,
                                FsoPropertiesDialog.this.mSpnOwner, errorMsg);
                        setSpinnerMsg(
                                FsoPropertiesDialog.this.mContext,
                                FsoPropertiesDialog.this.mSpnGroup, errorMsg);
                        return;
                    }

                    // Position of the owner and group
                    int owner = FsoPropertiesDialog.this.mFso.getUser().getId();
                    int group = FsoPropertiesDialog.this.mFso.getGroup().getId();
                    int ownerPosition = 0;
                    int groupPosition = 0;

                    // Convert the SparseArray in an array of string of "uid - name"
                    int len = aids.size();
                    final String[] data = new String[len];
                    for (int i = 0; i < len; i++) {
                        AID aid = aids.valueAt(i);
                        data[i] = String.format(AID_FORMAT,
                                        Integer.valueOf(aid.getId()), aid.getName());
                        if (owner == aid.getId()) ownerPosition = i;
                        if (group == aid.getId()) groupPosition = i;
                    }

                    // Change the adapter of the spinners
                    setSpinnerData(
                            FsoPropertiesDialog.this.mContext,
                            FsoPropertiesDialog.this.mSpnOwner, data, ownerPosition);
                    setSpinnerData(
                            FsoPropertiesDialog.this.mContext,
                            FsoPropertiesDialog.this.mSpnGroup, data, groupPosition);
                }
            }
        };
        aidsTask.execute();
    }

