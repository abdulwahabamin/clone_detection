		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			pd.dismiss();
			
/*			if (CALLING_FRAGMENT.equals("ALBUMS_FRAGMENT")) {

			} else if (CALLING_FRAGMENT.equals("ALBUM_ARTISTS_FLIPPED_FRAGMENT")) {
				AlbumArtistsFlippedFragment.getCursor();
				AlbumArtistsFlippedFragment.albumArtistsFlippedListViewAdapter.notifyDataSetChanged();
			} else if (CALLING_FRAGMENT.equals("GENRES_FLIPPED_FRAGMENT")) {
				GenresFlippedFragment.getCursor();
				GenresFlippedFragment.genresFlippedListViewAdapter.notifyDataSetChanged();
			} else {
				ArtistsFlippedFragment.artistsFlippedListView.setAdapter(null);
				ArtistsFlippedFragment.getCursor();
				ArtistsFlippedFragment.artistsFlippedListViewAdapter = new ArtistsFlippedListViewAdapter(mContext, ArtistsFlippedFragment.cursor);
				ArtistsFlippedFragment.artistsFlippedListView.setAdapter(ArtistsFlippedFragment.artistsFlippedListViewAdapter);
				ArtistsFlippedFragment.artistsFlippedListView.invalidate();
			}*/
			
			//Delete all the contents of the ArrayLists.
			clearArrayLists();
			dialogFragment.dismiss();
			Toast.makeText(parentActivity, R.string.changes_saved, Toast.LENGTH_SHORT).show();
			
		}

