	private void getMimeTypes() {
		Context ctx = getContext();
		MimeTypeParser mtp = null;
		try {
			mtp = new MimeTypeParser(ctx, ctx.getPackageName());
		} catch (NameNotFoundException e) {
			//Should never get here
		}
		XmlResourceParser in = 
			getContext().getResources().getXml(R.xml.mimetypes);

		try {
			mMimeTypes = mtp.fromXmlResource(in);
		} catch (XmlPullParserException e) {
			Log.e(TAG, "PreselectedChannelsActivity: XmlPullParserException", e);
			throw new RuntimeException(
					"PreselectedChannelsActivity: XmlPullParserException");
		} catch (IOException e) {
			Log.e(TAG, "PreselectedChannelsActivity: IOException", e);
			throw new RuntimeException(
					"PreselectedChannelsActivity: IOException");
		}
	}

