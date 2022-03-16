	public final JSONForm addField(String key, String value) {
		if(!isClosed) {
			mForm.append(CRLF + TWO_HYPHENS + mBoundary + CRLF);
			mForm.append("Content-Disposition: form-data; name=\"");
			mForm.append(key);
			mForm.append("\"" + CRLF + CRLF);
			mForm.append(value);
		} else {
			throw new IllegalArgumentException("New fields cannot be added to the form after close() has been called.");
		}
			
		return this;
	}

