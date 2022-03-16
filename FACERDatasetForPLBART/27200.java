    public void setCondition(String condition) {
        TextView view = (TextView) getActivity().findViewById(R.id.header_condition);
        if (view != null) {
            view.setText(condition);
        }
    }

