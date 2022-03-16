    @Override
    public void onCreateOptionsMenu(Menu menu , MenuInflater inflater) {
        activity().getMenuInflater().inflate(R.menu.menu_graph, menu);
        this.menu = menu;
        this.menu.getItem(0).setIcon(ContextCompat.getDrawable(context() , R.drawable.ic_radio_button_unchecked_white_24dp));
    }

