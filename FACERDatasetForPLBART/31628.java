	public static String Check_position_no() {
		String areano = "";
		DB db = DB.GetDB();
		Cursor cursor = db.rawQuery("select setvalue from settings where setkey = 'position_no'");
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			byte bytes[] = cursor.getBlob(0);

			try {
				areano = new String(bytes, "utf-8").trim();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cursor.close();
		db.close();
		return areano;
	}

