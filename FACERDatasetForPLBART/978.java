		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()){
			case R.id.target:
				sendMess("����Ŀ��");
				msgEditText.append("������\n");
				break;
			case R.id.load:
				sendMess("װ��/ж��");
				msgEditText.append("��װ��/ж��\n");
				break;
			case R.id.keep:
				sendMess("����");
				msgEditText.append("�ѱ���\n");
				break;
			case R.id.zero:
				sendMess("����");
				msgEditText.append("�ѹ���\n");
				break;
			case R.id.netWeight:
				sendMess("����");
				msgEditText.append("����Ϊ��\n");
				break;
			case R.id.turn:
				sendMess("��/��");
				msgEditText.append("�ѿ�/��\n");
				break;
			}
		}

