    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView:called");

        View view = inflater.inflate(R.layout.fragment_playlist, container, false);
        ButterKnife.bind(this, view);

        if (itemsRv.getLayoutManager() == null) {
            itemsRv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        }

        appBarLayout.setOnStateChangeListener(new StateAwareAppBarLayout.OnStateChangeListener() {
            @Override
            public void onStateChange(StateAwareAppBarLayout.State toolbarChange) {
                Log.d(TAG, "state="+toolbarChange);
                switch (toolbarChange) {
                    case COLLAPSED:
                        backIb.setColorFilter(titleColor, PorterDuff.Mode.SRC_IN);
                        break;
                    default:
                        backIb.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
                        break;
                }
            }
        });

        backIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onBackIbClick();
            }
        });

        shuffleFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onShuffleAllClick();
            }
        });

        mPresenter.onCreateView();

        return view;
    }

