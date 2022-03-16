    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onBindViewHolder(LocationsViewHolder holder, int position) {
        Typeface weatherFont = Typeface.createFromAsset(context.getAssets(), "fonts/weather.ttf");
        Weather weather = weatherArrayList.get(position);

        holder.cityTextView.setText(String.format("%s, %s", weather.getCity(), weather.getCountry()));
        holder.temperatureTextView.setText(weather.getTemperature());
        holder.descriptionTextView.setText(weather.getDescription());
        holder.iconTextView.setText(weather.getIcon());
        holder.iconTextView.setTypeface(weatherFont);

        holder.webView.getSettings().setJavaScriptEnabled(true);
        holder.webView.loadUrl("file:///android_asset/map.html?lat=" + weather.getLat()+ "&lon=" + weather.getLon() + "&zoom=" + 10 + "&appid=notneeded&displayPin=true");

        if (darkTheme || blackTheme) {
            holder.cityTextView.setTextColor(Color.WHITE);
            holder.temperatureTextView.setTextColor(Color.WHITE);
            holder.descriptionTextView.setTextColor(Color.WHITE);
            holder.iconTextView.setTextColor(Color.WHITE);
        }

        if (darkTheme) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#2e3c43"));
        }

        if (blackTheme) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#2f2f2f"));
        }
    }

