		@Override
		protected void onPostExecute(Boolean result) {
			//ImageView searchShortImg = (ImageView) searchHeader.findViewById(R.id.search_short_img);
			//TextView searchShortText = (TextView) searchHeader.findViewById(R.id.search_short_text);
			//searchShortText.setText(packet.getString(SearchPacket.STRING_TERM));
			//searchShortImg.setImageDrawable(getResources().getDrawable(packet.getInt(SearchPacket.INT_ICON)));

			updating.setVisibility(View.GONE);
			loading.setVisibility(View.GONE);
			refresh();
		}

