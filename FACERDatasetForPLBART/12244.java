    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
        dest.writeString(this.mType.toString());
        dest.writeString(this.mName);
        dest.writeString(this.mPath);
    }

