		@Override
		public void onClick(View v) {
			if(player!=null&&isReleased==false){
				if(!isPausing){
					player.pause();
					isPausing=true;
				}
			}

		}

