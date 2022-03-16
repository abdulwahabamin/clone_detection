    /**
     * Initiate ViewPager and PagerAdapter
     */
    private void initPager() {
        // Initiate PagerAdapter
        PagerAdapter mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        if (ApolloUtils.isArtist(mimeType))
            // Show all albums for an artist
            mPagerAdapter.addFragment(new ArtistAlbumsFragment(bundle));
        // Show the tracks for an artist or album
        if(Playlists.CONTENT_TYPE.equals(mimeType)){
            mPagerAdapter.addFragment(new PlaylistListFragment(bundle));
        }
        else if(Genres.CONTENT_TYPE.equals(mimeType)){
        	mPagerAdapter.addFragment(new GenreListFragment(bundle));
        }
        else if(ApolloUtils.isArtist(mimeType)){
        	mPagerAdapter.addFragment(new ArtistListFragment(bundle));
        }
        else if(Audio.Albums.CONTENT_TYPE.equals(mimeType)){
        	mPagerAdapter.addFragment(new AlbumListFragment(bundle));
        }

        // Set up ViewPager
        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        mViewPager.setPageMargin(getResources().getInteger(R.integer.viewpager_margin_width));
        mViewPager.setPageMarginDrawable(R.drawable.viewpager_margin);
        mViewPager.setOffscreenPageLimit(mPagerAdapter.getCount());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOnPageChangeListener(new PageListener());
    }

