    protected SearchResult(Parcel in) {
        this.id = in.readString();
        this.mainTitle = in.readString();
        this.subTitle = in.readString();
        this.resultType = ResultType.valueOf(in.readString());
    }

