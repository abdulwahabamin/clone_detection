	public static String[] GetJSON(Integer type) {
		String[] Ret = { "", "" };
		String strSQL = "select json, datetime from weatherinfo where type = " + type;
		DB db = DB.GetDB();
		Cursor cursor = db.rawQuery(strSQL);
		if (cursor.getCount() > 0) {
			cursor.moveToFirst();
			try {
				Ret[0] = new String(cursor.getBlob(0), "utf-8").trim();
				Ret[1] = new String(cursor.getBlob(1), "utf-8").trim();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cursor.close();
		db.close();
		return Ret;
	}

