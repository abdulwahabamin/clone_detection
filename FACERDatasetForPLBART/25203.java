    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.artistName);
        dest.writeTypedList(this.albumDTOList);
        dest.writeString(this.coverPath);
    }

