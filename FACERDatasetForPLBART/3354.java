	public static void copyToClipboard(Activity activity, String text) {
	    ClipboardManager clipboard = (android.content.ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
	    ClipData clip = ClipData.newPlainText(B.NAME, text);
	    clipboard.setPrimaryClip(clip);
	    
	}

