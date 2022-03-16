	public int getDestScrollX(int page) {
		switch (page) {
		case 0:
		case 2:
			return mViewBehind.getMenuLeft(mContent, page);
		case 1:
			return mContent.getLeft();
		}
		return 0;
	}

