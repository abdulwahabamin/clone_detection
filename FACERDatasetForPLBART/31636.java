		@Override
		protected Void doInBackground(String... sql) {
			// TODO Auto-generated method stub
			try {
				DB db = DB.GetDB();
				Cursor cursor = db.rawQuery(sql[0]);
				int count = cursor.getCount();
				if (count > 0) {
					no = new String[count];
					name = new String[count];
					if (Level.equalsIgnoreCase("a")) {
						position_no = new String[count];
					}
					int i = 0;
					for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
						byte byte_no[] = cursor.getBlob(0);
						byte byte_name[] = cursor.getBlob(1);
						try {
							no[i] = new String(byte_no, "utf-8").trim();
							name[i] = new String(byte_name, "utf-8").trim();
							if (Level.equalsIgnoreCase("a")) {
								position_no[i] = new String(cursor.getBlob(2), "utf-8").trim();
							}
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						newdata.add(name[i]);
						i++;
					}
				}
				cursor.close();
				db.close();
			} catch (Exception e) {
				ErrMSG = e.toString();
			}
			return null;
		}

