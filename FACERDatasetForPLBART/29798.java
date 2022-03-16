    public void initCards()
    {
        cards = new ArrayList<>();

        cards.add(new AboutModel(0));
        cards.add(new AboutModel(1));
        cards.add(new AboutModel(2));
        cards.add(new AboutModel(3));
        cards.add(new AboutModel(4));

        mRecyclerView = findViewById(R.id.about_list);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        AboutAdapter adapter = new AboutAdapter(cards);
        mRecyclerView.setAdapter(adapter);
    }

