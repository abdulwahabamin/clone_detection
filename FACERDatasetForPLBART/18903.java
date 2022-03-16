	@Override
	public WebClientSongsSchema fromJsonObject(JSONObject jsonObject) {
		
		if(jsonObject != null) {
			mTotalTracks = jsonObject.optInt("totalTracks");
			mSubjectToCuration = jsonObject.optBoolean("subjectToCuration");
			mName = jsonObject.optString("name", null);
			mTotalDiscs = jsonObject.optInt("totalDiscs");
			mTitleNorm = jsonObject.optString("titleNorm", null);
			mAlbumNorm = jsonObject.optString("albumNorm", null);
			mTrack = jsonObject.optInt("track");
			mAlbumArtUrl = jsonObject.optString("albumArtUrl", null);
			mUrl = jsonObject.optString("url", null);
			mCreationDate = jsonObject.optLong("creationDate");
			mAlbumArtistNorm = jsonObject.optString("albumArtistNorm", null);
			mArtistNorm = jsonObject.optString("artistNorm", null);
			mLastPlayed = jsonObject.optLong("lastPlayed");
			mMatchedId = jsonObject.optString("matchedId", null);
			mType = jsonObject.optInt("type");
			mDisc = jsonObject.optInt("disc");
			mGenre = jsonObject.optString("genre", null);
			mBeatsPerMinute = jsonObject.optInt("beatsPerMinute");
			mAlbum = jsonObject.optString("album", null);
			mId = jsonObject.optString("id", null);
			mComposer = jsonObject.optString("composer", null);
			mTitle = jsonObject.optString("title", null);
			mAlbumArtist = jsonObject.optString("albumArtist", null);
			mYear = jsonObject.optInt("year");
			mArtist = jsonObject.optString("artist", null);
			mDurationMillis = jsonObject.optLong("durationMillis");
			mIsDeleted = jsonObject.optBoolean("deleted");
			mPlayCount = jsonObject.optInt("playCount");
			mRating = jsonObject.optString("rating", null);
			mComment = jsonObject.optString("comment", null);
			mPlaylistEntryId = jsonObject.optString("playlistEntryId");
		}

		//This method returns itself to support chaining.
		return this;
	}

