		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.target:
				sendMess("连接目标");
				msgEditText.append("已连接\n");
				break;
			case R.id.load:
				sendMess("装载/卸载");
				msgEditText.append("已装载/卸载\n");
				break;
			case R.id.keep:
				sendMess("保持");
				msgEditText.append("已保持\n");
				break;
			case R.id.zero:
				sendMess("归零");
				msgEditText.append("已归零\n");
				break;
			case R.id.netWeight:
				sendMess("净重");
				msgEditText.append("净重为：\n");
				break;
			case R.id.turn:
				sendMess("开/关");
				msgEditText.append("已开/关\n");
				break;
			}
		}

