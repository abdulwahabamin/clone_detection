	public static String GetWeatherInfo(String url) {
		BufferedReader in = null;
		String data = "";
		url += "?t=" + System.currentTimeMillis();
		System.out.println("the url is " + url);
		
		//url = "http://akasuna.com/p.php?url=" + url;
		//System.out.println("new url is " + url);
		HttpClient client = new DefaultHttpClient();
		try {
			URI website = new URI(url);
			HttpGet request = new HttpGet();
			request.setURI(website);
			HttpResponse response = client.execute(request);
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String l = "";
			String nl = System.getProperty("line.separator");
			while ((l = in.readLine()) != null) {
				sb.append(l + nl);
			}
			in.close();
			data = sb.toString();
			System.out.println("json is " + data);
			return data;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString());
		}
		System.out.println("json is " + data);
		return data;
	}

