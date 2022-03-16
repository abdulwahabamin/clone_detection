    private void setUpListeners() {

        send.setOnClickListener(this);
        rv.addOnLayoutChangeListener(this);
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(manager.findLastCompletelyVisibleItemPosition()==list.size()-1)
                {
                    if (user!=null)
                    {
                        loadMore();
                    }
                }
            }
        });

    }

