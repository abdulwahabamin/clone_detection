	private void setTextView() {
		String strJSON = "";
		String strTime = "";
		String strJSONExt = "";
		String strTimeExt = "";

		String[] s1 = Func.GetJSON(0);
		String[] s2 = Func.GetJSON(1);

		strJSON = s1[0];
		strTime = s1[1];
		strJSONExt = s2[0];
		strTimeExt = s2[1];

		tvArea.setText(strTime + "\n" + strJSON + "\n\n" + strTimeExt + "\n" + strJSONExt + "\n\n\n\n");
	}

