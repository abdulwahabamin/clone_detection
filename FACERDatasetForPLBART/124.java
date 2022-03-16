	private void decorateView(int position, View layoutView, ItemRenderer renderer, boolean reused) {
		if (renderer.getMessageViewId() == -1)
			return;

		View view = layoutView.findViewById(renderer.getMessageViewId());
		if (view instanceof TextView) {
			((TextView) view).setText(renderer.getMessage() /*+ (reused ? "~" : "")*/);
			
		} else if (view instanceof RelativeLayout && renderer.getAdsView() != null) {// for ads,把ads放到listview中行�?通
			/*((RelativeLayout)view).removeAllViews();
			((RelativeLayout)view).addView(renderer.getAdsView());*/
		}
	}

