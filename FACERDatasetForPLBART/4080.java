	public static boolean loadState(Bundle inState) {
		boolean loaded=false;
		if(inState!=null && !inState.isEmpty()) {
			loaded=true;

            int section3 =inState.getInt(SECTION_SAVE_KEY_3);
            if(section3!=0)  {
                //BLog.e("LOAD", "section 2: "+section2);
                S.sections.add(Integer.valueOf(section3));
            }
			int section2 =inState.getInt(SECTION_SAVE_KEY_2);
			if(section2!=0)  {
				//BLog.e("LOAD", "section 2: "+section2);
				S.sections.add(Integer.valueOf(section2));
			}
			int section1 =inState.getInt(SECTION_SAVE_KEY_1);
			if(section1!=0) {
				//BLog.e("LOAD", "section 1: "+section1);
				S.sections.add(Integer.valueOf(section1));
			}
			
			int section =inState.getInt(SECTION_SAVE_KEY);
			S.sections.add(Integer.valueOf(section));
			BLog.e("LOAD", "section: " + section);

			String lastphoto = inState.getString(State.CAMERA_LAST_PHOTO);
			if(lastphoto!=null) {
				State.addCameraPhoto(lastphoto);
			}

			
			Set<String> keys = inState.keySet();
			for(String key: keys) {
				String[] pkeys = key.split("-");
				if(pkeys.length==3) {
					int ts = Sf.toInt(pkeys[0]);
					int typekey=Sf.toInt(pkeys[1]);
                    String objname=Sf.notNull(pkeys[2]);
                    //BLog.e("LOAD FROM STATE, key: "+key+" --  "+ts+"-"+typekey+" = "+inState.getString(key));
					if(typekey==StateObject.TYPE_INT) {
					
						addToState(ts,new StateObject(objname,inState.getInt(key)));
					} else if(typekey==StateObject.TYPE_DOUBLE) {
						addToState(ts,new StateObject(objname,inState.getDouble(key)));
					} else if(typekey==StateObject.TYPE_STRING) {

						addToState(ts, new StateObject(objname, inState.getString(key)));
					} else if(typekey==StateObject.TYPE_LONG) {

                        addToState(ts, new StateObject(objname, inState.getLong(key)));
                    }
				}
			}
			
		}
		return loaded;
	}

