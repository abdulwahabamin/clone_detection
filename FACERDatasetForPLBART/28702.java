        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);

            if(position == dots.length - 1) {
                autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.autoCompleteTvAddFirstStart);
                cityTextViewGenerator.generate(autoCompleteTextView, 8, EditorInfo.IME_ACTION_DONE, new MyConsumer<City>() {
                    @Override
                    public void accept(City city) {
                        selectedCity = city;
                    }
                }, new Runnable() {
                    @Override
                    public void run() {
                        performDone();
                    }
                });
            }
            container.addView(view);

            return view;
        }

