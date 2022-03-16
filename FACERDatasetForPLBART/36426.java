    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new RecyclerViewFilter();
        }
        return filter;
    }

