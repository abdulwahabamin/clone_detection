		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int position, long dbID) {
			Intent intent = null;
			switch (position) {
			case 0:
				intent = new Intent(getActivity(), MainActivity.class);
				intent.putExtra("TARGET_FRAGMENT", "ARTISTS");
				//intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 1:
				intent = new Intent(getActivity(), MainActivity.class);
				intent.putExtra("TARGET_FRAGMENT", "ALBUM_ARTISTS");
				//intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 2:
				intent = new Intent(getActivity(), MainActivity.class);
				intent.putExtra("TARGET_FRAGMENT", "ALBUMS");
				//intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 3:
				intent = new Intent(getActivity(), MainActivity.class);
				intent.putExtra("TARGET_FRAGMENT", "SONGS");
				//intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 4:
				intent = new Intent(getActivity(), MainActivity.class);
				intent.putExtra("TARGET_FRAGMENT", "PLAYLISTS");
				//intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 5:
				intent = new Intent(getActivity(), MainActivity.class);
				intent.putExtra("TARGET_FRAGMENT", "GENRES");
				//intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			case 6:
				intent = new Intent(getActivity(), MainActivity.class);
				intent.putExtra("TARGET_FRAGMENT", "FOLDERS");
				//intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
				break;
			}
			
		}

