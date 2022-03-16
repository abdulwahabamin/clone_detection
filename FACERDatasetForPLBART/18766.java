	public final JSONForm close() {
		if(!isClosed) {
			mForm.append(CRLF + TWO_HYPHENS + mBoundary + TWO_HYPHENS + CRLF);
			isClosed = true;
		}
		return this;
	}

