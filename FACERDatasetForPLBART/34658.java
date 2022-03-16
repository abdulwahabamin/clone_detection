    private void initView(View view) {
        listView = (ListView) view.findViewById(R.id.province_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CityFragment cityFragment = (CityFragment) getActivity().getSupportFragmentManager()
                        .findFragmentByTag(CityFragment.TAG);
                if (cityFragment == null) {
                    cityFragment = new CityFragment();
                }
                CityPresenter cityPresenter = new CityPresenter(cityFragment);
                Bundle bundle = new Bundle();
                bundle.putString("ProvinceName",((ProvinceContext)parent.getItemAtPosition(position)).getName());
                cityFragment.setArguments(bundle);
                cityPresenter.loadCityData(((ProvinceContext)parent.getItemAtPosition(position)).getName());
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        cityFragment, CityFragment.TAG).commit();
                getActivity().getSupportFragmentManager().beginTransaction().show(cityFragment).commit();
            }
        });
    }

