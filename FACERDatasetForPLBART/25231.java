    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.mainTitle);
        dest.writeString(this.subTitle);
        dest.writeString(String.valueOf(this.resultType));
    }

