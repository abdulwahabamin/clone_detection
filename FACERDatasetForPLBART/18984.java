    public PauseOnScrollHelper(Picasso picasso, AbsListView.OnScrollListener delegate,
                               boolean pauseOnScroll, boolean pauseOnFling) {
        this.delegate = delegate;
        this.picasso = picasso;
        this.pauseOnScroll = pauseOnScroll;
        this.pauseOnFling = pauseOnFling;
        picasso.continueDispatching();

    }

