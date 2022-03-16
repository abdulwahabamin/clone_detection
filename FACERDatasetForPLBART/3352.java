	/**
	 * change height of emoticons keyboard according to height of actual
	 * keyboard
	 * 
	 * @param height
	 *            minimum height by which we can make sure actual keyboard is
	 *            open or not
	 */
	public static void changeKeyboardHeight(int height, LinearLayout emoticonsCover) {

		if (height > 100) {
			D.keyboardHeight = height;
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, D.keyboardHeight);
			emoticonsCover.setLayoutParams(params);
		}

	}

