        @Override
        public void onItemClick(AdapterView<?> arg0, View view, int index, long id) {

            Bundle bundle = new Bundle();
            bundle.putString("headerImagePath", (String) view.getTag(R.string.album_art));
            bundle.putString("headerText", (String) view.getTag(R.string.title_text));
            bundle.putString("field2", (String) view.getTag(R.string.field_2));
            bundle.putString("subText", mHeaderText);
            bundle.putInt("fragmentId", getNewFragmentId());

            Intent intent = new Intent(mContext, BrowserSubListActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

        }

