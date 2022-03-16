    @SuppressLint("ApplySharedPref")
    @Override
    public void onItemClickListener(View view, int position) {
        final Weather weather = recyclerAdapter.getItem(position);
        final Intent intent = new Intent(getActivity(), MainActivity.class);
        final Bundle bundle = new Bundle();

        sharedPreferences.edit().putString("cityId", weather.getId()).commit();
        bundle.putBoolean("shouldRefresh", true);
        intent.putExtras(bundle);

        startActivity(intent);
    }

