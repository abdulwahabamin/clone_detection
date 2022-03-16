	public static void UpdateWidget(android.content.Context content) {
		String strJSON = "";
		String strTime = "";
		String strJSONExt = "";
		String strTimeExt = "";

		String[] s1 = GetJSON(0);
		String[] s2 = GetJSON(1);

		strJSON = s1[0];
		strTime = s1[1];
		strJSONExt = s2[0];
		strTimeExt = s2[1];


		System.out.println("aaa");
		System.out.println(strTime + " --> " + strJSON);
		System.out.println(strTimeExt + " --> " + strJSONExt);
		System.out.println("bbb");

		String strCity1 = "";
		String strCity2 = "";
		Integer ImgID = 0;
		String strCurrTemp = "";
		String strTemp = "";
		String strWeather = "";

		try {
			JSONObject weather1 = new JSONObject(strJSON).getJSONObject("weatherinfo");
			JSONObject weather2 = new JSONObject(strJSONExt).getJSONObject("weatherinfo");

			//String strUpdateTime = weather1.getString("time").replace(":", "");
			// Get city name
			strCity1 = weather1.getString("city");
			strCity2 = weather2.getString("city");
			if (strCity1.trim().length() > 0 && strCity2.trim().length() > 0 && strCity1.trim().equals(strCity2.trim())) {
				
				ImgID = weather2.getInt("img1");
				if (ImgID.equals(0)) {
					ImgID = R.drawable.w0;
				} else if (ImgID.equals(1)) {
					ImgID = R.drawable.w1;
				} else if (ImgID.equals(2)) {
					ImgID = R.drawable.w2;
				} else if (ImgID.equals(3)) {
					ImgID = R.drawable.w3;
				} else if (ImgID.equals(4)) {
					ImgID = R.drawable.w4;
				} else if (ImgID.equals(5)) {
					ImgID = R.drawable.w5;
				} else if (ImgID.equals(6)) {
					ImgID = R.drawable.w6;
				} else if (ImgID.equals(7)) {
					ImgID = R.drawable.w7;
				} else if (ImgID.equals(8)) {
					ImgID = R.drawable.w8;
				} else if (ImgID.equals(9)) {
					ImgID = R.drawable.w9;
				} else if (ImgID.equals(10)) {
					ImgID = R.drawable.w10;
				} else if (ImgID.equals(11)) {
					ImgID = R.drawable.w11;
				} else if (ImgID.equals(12)) {
					ImgID = R.drawable.w12;
				} else if (ImgID.equals(13)) {
					ImgID = R.drawable.w13;
				} else if (ImgID.equals(14)) {
					ImgID = R.drawable.w14;
				} else if (ImgID.equals(15)) {
					ImgID = R.drawable.w5;
				} else if (ImgID.equals(16)) {
					ImgID = R.drawable.w16;
				} else if (ImgID.equals(17)) {
					ImgID = R.drawable.w17;
				} else if (ImgID.equals(18)) {
					ImgID = R.drawable.w8;
				} else if (ImgID.equals(19)) {
					ImgID = R.drawable.w19;
				} else if (ImgID.equals(20)) {
					ImgID = R.drawable.w20;
				} else if (ImgID.equals(21)) {
					ImgID = R.drawable.w21;
				} else if (ImgID.equals(22)) {
					ImgID = R.drawable.w22;
				} else if (ImgID.equals(23)) {
					ImgID = R.drawable.w23;
				} else if (ImgID.equals(24)) {
					ImgID = R.drawable.w24;
				} else if (ImgID.equals(25)) {
					ImgID = R.drawable.w25;
				} else if (ImgID.equals(26)) {
					ImgID = R.drawable.w26;
				} else if (ImgID.equals(27)) {
					ImgID = R.drawable.w27;
				} else if (ImgID.equals(28)) {
					ImgID = R.drawable.w28;
				} else if (ImgID.equals(29)) {
					ImgID = R.drawable.w29;
				} else if (ImgID.equals(30)) {
					ImgID = R.drawable.w30;
				} else if (ImgID.equals(31)) {
					ImgID = R.drawable.w31;
				}

				strCurrTemp = weather1.getString("temp") + "°";

				strWeather = weather2.getString("weather1");

				strTemp = weather2.getString("temp1").replace("℃", "°");

				AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(content.getApplicationContext());
				ComponentName thisWidget = new ComponentName(content.getApplicationContext(), WeatherWidget.class);
				int[] allWidgetIds = appWidgetManager.getAppWidgetIds(thisWidget);

				RemoteViews remoteViews = new RemoteViews(content.getApplicationContext().getPackageName(), R.layout.widget);
				remoteViews.setImageViewResource(R.id.imgImg, ImgID);
				remoteViews.setTextViewText(R.id.tvTemp, strCurrTemp);
				
				remoteViews.setTextViewText(R.id.tvCity, strCity1 + (strTime.trim().length() == 19 ? "" + strTime.trim().substring(11, 16).replace(":", "") : ""));

				remoteViews.setTextViewText(R.id.tvWeather, strWeather);
				remoteViews.setTextViewText(R.id.tvTempF, strTemp.replace("~", " ~ "));

				appWidgetManager.updateAppWidget(allWidgetIds, remoteViews);

				System.out.println("update widget over!");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

