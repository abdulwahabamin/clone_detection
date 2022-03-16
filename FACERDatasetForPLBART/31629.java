	public static void SaveJSON() {
		String strJSON = "";
		String strJSONExt = "";

		strJSON = GetWeatherInfo(Config.URL.replace("areano", Check_position_no()));
		strJSONExt = GetWeatherInfo(Config.URLExt.replace("areano", Check_position_no()));

		try {
			JSONObject weather = new JSONObject(strJSON).getJSONObject("weatherinfo");
			JSONObject weatherExt = new JSONObject(strJSONExt).getJSONObject("weatherinfo");

			System.out.println("city is " + weather.getString("city"));
			if (weather.getString("city").length() > 0 && weatherExt.getString("city").length() > 0) {
				String strSQL = "update weatherinfo set json = '" + strJSON.replace("'", "''") + "', datetime = datetime(CURRENT_TIMESTAMP,'localtime') where type = 0";
				DB db = DB.GetDB();
				db.execSQL(strSQL);
				db.close();

				DB s1 = DB.GetDB();
				strSQL = "insert into weatherinfo (json, datetime, type) values ('" + strJSON.replace("'", "''") + "', datetime(CURRENT_TIMESTAMP,'localtime'), 2)";
				s1.execSQL(strSQL);
				s1.close();
			}

			System.out.println("city is " + weatherExt.getString("city"));
			if (weather.getString("city").length() > 0 && weatherExt.getString("city").length() > 0) {
				String strSQL = "update weatherinfo set json = '" + strJSONExt.replace("'", "''") + "', datetime = datetime(CURRENT_TIMESTAMP,'localtime') where type = 1";
				DB db = DB.GetDB();
				db.execSQL(strSQL);
				db.close();

				DB s1 = DB.GetDB();
				strSQL = "insert into weatherinfo (json, datetime, type) values ('" + strJSONExt.replace("'", "''") + "', datetime(CURRENT_TIMESTAMP,'localtime'), 3)";
				s1.execSQL(strSQL);
				s1.close();
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
	}

