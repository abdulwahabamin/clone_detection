		@Override
		public void onClick(View v) {
			if(player!=null){
				if(!isReleased){
					player.stop();
					player.release();
					isReleased=true;
				}
				player=null;
			}

		}

