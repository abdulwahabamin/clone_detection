		public ViewHolder(View itemView, ClickListener clickListener) {
			super(itemView);
			gridItemImage = (ImageView) itemView.findViewById(R.id.grid_image);
			gridItemTitle = (TextView) itemView.findViewById(R.id.grid_title);
			this.clickListener = clickListener;
			itemView.setOnClickListener(this);
		}

