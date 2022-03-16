    /**
     * Fill the object from the parcel information.
     *
     * @param in The parcel information to recreate the object
     */
    private void readFromParcel(Parcel in) {
        int len = mQUERIES.length;
        int cc = in.readInt();
        for (int i = 0; i < cc; i++) {
            String query = in.readString();
            if (i >= len) {
                continue;
            }
            if (!TextUtils.isEmpty(query)) {
                mQUERIES[i] = query;
            }
        }
    }

