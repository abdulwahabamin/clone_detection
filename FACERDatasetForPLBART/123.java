	private View createViewFromResource(int position, View convertView, ViewGroup parent) {
		ItemRenderer renderer = mData.get(position);

		if (renderer == null || renderer.getLayoutId() == -1)
			return null;

		View layoutView;
		boolean reused = false;
		if (convertView == null) {
			layoutView = mInflater.inflate(renderer.getLayoutId(), parent, false);
		} else {
			reused = true;
			layoutView = convertView;
		}
		decorateView(position, layoutView, renderer, reused);
		return layoutView;
	}

