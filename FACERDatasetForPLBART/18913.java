		@Override
		public void onItemClick(AdapterView<?> arg0, View view, int index, long id) {

            //Determine the new activity's fragment id.
            int newFragmentId = getNewFragmentId();

            Intent intent;
            if (newFragmentId==Common.ALBUMS_FLIPPED_FRAGMENT) {
                intent = new Intent(mContext, BrowserSubListActivity.class);
            } else {
                intent = new Intent(mContext, BrowserSubGridActivity.class);
            }

            Bundle bundle = new Bundle();
            bundle.putString("headerImagePath", (String) view.getTag(R.string.album_art));
            bundle.putString("headerText", (String) view.getTag(R.string.title_text));
            bundle.putString("subText", (String) view.getTag(R.string.field_1));
            bundle.putInt("fragmentId", newFragmentId);

            intent.putExtras(bundle);
            startActivity(intent);
            getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

		}

