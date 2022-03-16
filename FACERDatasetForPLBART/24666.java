	private void updateListView() {
		// user clicked the 'update' item
		// download the basic informations of mp3s
		String xml = downloadXML(AppConstant.URL.BASE_URL+"resources.xml");
		// put mp3 object into the mp3 list
		mp3Infos = parse(xml);

		// set this adapter to the list activity
		setListAdapter(buildSimpleAdapter(mp3Infos));
	}

