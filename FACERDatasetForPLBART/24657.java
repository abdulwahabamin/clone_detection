	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		if(infos!=null){
			MP3Info info=infos.get(position);
			Intent intent=new Intent();
			intent.putExtra("mp3info", info);
			intent.setClass(this, PlayerActivity.class);
			startActivity(intent);
		}
		
	}

