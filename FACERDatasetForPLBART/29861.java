        About3ViewHolder(View view) {
            super(view);
            this.context = view.getContext();
            view.callOnClick();
            setUpOnClick(view);
        }

