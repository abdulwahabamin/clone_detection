    private void buildUI() {
        setContentView(R.layout.tv_category_details_activity);

        TitleView categoryTitle = (TitleView)findViewById(R.id.category_title);
        categoryTitle.setTitle(title);

        /*
        ArrayObjectAdapter actionsAdapter = new ArrayObjectAdapter();
        actionsAdapter.add(new Action(R.id.play_all_now_action, getActivity().getString(R.string.play_all_now)));
        actionsAdapter.add(new Action(R.id.play_all_next_action, getActivity().getString(R.string.play_all_next)));
        actionsAdapter.add(new Action(R.id.queue_all_last_action, getActivity().getString(R.string.queue_all)));
        detailsOverview.setActionsAdapter(actionsAdapter);
        adapter.add(detailsOverview);
        */

        VerticalGridView list = (VerticalGridView) findViewById(android.R.id.list);
        adapter = new CursorObjectAdapter(new SongRowPresenter());
        list.setAdapter(new ClickableItemBridgeAdapter(adapter, this));
    }

