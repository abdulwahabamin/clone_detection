    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_image);

        mImageWeather = (ImageWeather) getIntent().getSerializableExtra(Extras.IMAGE_WEATHER);

        ViewCompat.setTransitionName(ivWeatherImage, Extras.VIEW_NAME_WEATHER_IMAGE);

        tvPraise.setOnClickListener(this);
        tvLocation.setText(mImageWeather.getLocation().getAddress());
        tvUserName.setText(mImageWeather.getUserName());
        tvSay.setText(mImageWeather.getSay());
        tvSay.setVisibility(TextUtils.isEmpty(mImageWeather.getSay()) ? View.GONE : View.VISIBLE);
        tvTag.setText(getTagText(mImageWeather.getTag()));
        tvTag.setMovementMethod(LinkMovementMethod.getInstance());
        setTimeAndPraise();

        Glide.with(this)
                .load(mImageWeather.getImageUrl())
                .placeholder(R.drawable.image_weather_placeholder)
                .error(R.drawable.image_weather_placeholder)
                .into(ivWeatherImage);
    }

