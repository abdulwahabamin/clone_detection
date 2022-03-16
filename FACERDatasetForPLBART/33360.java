        @Override
        public CityNameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_city_search_list, parent, false);
            return new CityNameViewHolder(v);
        }

