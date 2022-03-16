    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        int cc = this.mQUERIES.length;
        dest.writeInt(cc);
        for (int i = 0; i < cc; i++) {
            dest.writeString(mQUERIES[i] != null ? mQUERIES[i] : "");
        }
    }

