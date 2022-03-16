	public static void copyToClipboardFlashView(Activity activity, View view, String text) {
		if(view!=null)
			Functions.copyToClipFlashView(activity, view);
		copyToClipboard(activity, text);

	}

