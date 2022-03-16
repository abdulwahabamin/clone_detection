        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            //返回的results�?�为过滤�?�的ArrayList<City>
            FilterResults results = new FilterResults();

            //无约�?�字符串则返回null
            if (charSequence == null || charSequence.length() == 0) {
                results.values = null;
                results.count = 0;
            } else {
                String prefixString = charSequence.toString().toLowerCase();
                //新建Values存放过滤�?�的数�?�
                ArrayList<City> newValues = new ArrayList<>();
                Stream.of(cities)
                        .filter(city -> (city.getCityName().contains(prefixString)
                                || city.getCityNameEn().contains(prefixString) || city.getParent().contains(prefixString)
                                || city.getRoot().contains(prefixString)))
                        .forEach(newValues::add);
                results.values = newValues;
                results.count = newValues.size();
            }
            return results;
        }

