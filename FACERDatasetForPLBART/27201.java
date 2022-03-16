    public void setDate(@NonNull Date date) {
        TextView view = (TextView) getActivity().findViewById(R.id.header_date);
        if (view != null) {
            SimpleDateFormat format =
                    new SimpleDateFormat("EE, dd MMM, HH:mm", Locale.getDefault());
            String value = format.format(date);
            view.setText(value);
        }
    }

