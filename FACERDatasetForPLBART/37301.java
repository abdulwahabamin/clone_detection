    private void init() {
        setOrientation(HORIZONTAL);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.image_weather_tag, this, false);
        addView(view, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        tagViews.add(findViewById(R.id.tv_tag_plant));
        tagViews.add(findViewById(R.id.tv_tag_people));
        tagViews.add(findViewById(R.id.tv_tag_weather));
        tagViews.add(findViewById(R.id.tv_tag_architecture));
        tagViews.add(findViewById(R.id.tv_tag_animal));
        for (View tag : tagViews) {
            tag.setOnClickListener(this);
        }
        tagViews.get(2).setSelected(true);
    }

