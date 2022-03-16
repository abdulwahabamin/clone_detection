	public static void setEditorFields(boolean allElementsSame, ArrayList<String> list, EditText editText) {
		
		if (allElementsSame==true) {
			editText.setText(list.get(0));
		} else {
			editText.setText(R.string.varies_by_song);
		}
		
	}

