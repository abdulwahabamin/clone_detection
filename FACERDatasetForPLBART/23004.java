	private Album(Parcel in) {
		this.title = in.readString();
		this.key = in.readString();
		this.artist = in.readString();
		this.numSongs = in.readInt();
	}

