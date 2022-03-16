    public void show() {
        RelativeLayout rcSearch = view.findViewById(R.id.rv_search);
        rcSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SearchActivity.class);
                context.startActivity(intent);
                LocListWindow.this.dismiss();
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.rc_loc_list);
        List<CityBean> list = new ArrayList<>();

        list.add(getCity("CN101010100",context.getString(R.string.beijing)));
        list.add(getCity("CN101020100",context.getString(R.string.shanghai)));
        list.add(getCity("CN101280601",context.getString(R.string.shenzhen)));
        list.add(getCity("GB2643741",context.getString(R.string.London)));
        list.add(getCity("US3290117",context.getString(R.string.Ner_York)));
        list.add(getCity("CN101320101",context.getString(R.string.HongKong)));
        list.add(getCity("SG1880252",context.getString(R.string.Singapore)));
        list.add(getCity("AU2147714",context.getString(R.string.Sydney)));
        list.add(getCity("FR2988507",context.getString(R.string.Paris)));
        list.add(getCity("JP1850147",context.getString(R.string.Tokyo)));
        list.add(getCity("AE292223",context.getString(R.string.Dubai)));
        list.add(getCity("DE2950159",context.getString(R.string.Berlin)));
        list.add(getCity("NL2759794",context.getString(R.string.Amsterdam)));
        list.add(getCity("KR1835848",context.getString(R.string.Seoul)));
        list.add(getCity("RU524901",context.getString(R.string.Moscow)));
        list.add(getCity("CH2657896",context.getString(R.string.Zurich)));
        list.add(getCity("CA6167865",context.getString(R.string.Toronto)));
        list.add(getCity("ZA2499011",context.getString(R.string.Cape_Town)));
        list.add(getCity("TH1609350",context.getString(R.string.Bangkok)));
        list.add(getCity("ES3117735",context.getString(R.string.Madrid)));

        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        recyclerView.setAdapter(new LocLIstAdapter(LocListWindow.this, list, context));
    }

