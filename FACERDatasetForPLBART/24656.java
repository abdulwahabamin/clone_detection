	@Override
	protected void onResume() {
		
		FileUtils utils = new FileUtils();
		infos = utils.getMP3Files("mp3/");
		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

		for (MP3Info info : infos) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("mp3_name", info.getMp3Name());
			map.put("mp3_size", info.getMp3Size());
			list.add(map);
		}

		 SimpleAdapter adapter=new
		 SimpleAdapter(this,list,R.layout.mp3info_item,new
		 String[]{"mp3_name","mp3_size"},new
		 int[]{R.id.mp3_name,R.id.mp3_size});

		setListAdapter(adapter);
		super.onResume();
	}

