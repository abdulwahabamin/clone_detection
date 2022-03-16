    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_player, container, false);
        ButterKnife.bind(this, view);

        mPresenter.onCreateView();

        musicPlayerSupl.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelStateChanged(View panel,
                                            SlidingUpPanelLayout.PanelState previousState,
                                            SlidingUpPanelLayout.PanelState newState) {
                if (newState == SlidingUpPanelLayout.PanelState.EXPANDED) {
                    smallAlbumArtCv.setVisibility(View.VISIBLE);
                } else {
                    smallAlbumArtCv.setVisibility(View.GONE);
                    if (newState == SlidingUpPanelLayout.PanelState.COLLAPSED) {
                        mQueueLayoutManager.scrollToPositionWithOffset(mCurrentQueueIndex, 0);
                    }
                }
            }
        });

        songCurrentPositionSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                elapsedTimeTv.setText(DateUtils.formatElapsedTime(progress / 1000));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                stopSeekbarUpdate();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mPresenter.onSeekbarStopTrackingTouch(seekBar.getProgress());
            }
        });

        if (playingQueueRv.getLayoutManager() == null) {
            mQueueLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
            playingQueueRv.setLayoutManager(mQueueLayoutManager);
        }

        heartIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.onHeartIvClick();
            }
        });

        return view;
    }

