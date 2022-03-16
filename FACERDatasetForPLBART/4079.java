	public static void saveState(Bundle outState) {

		Set<Integer> sections = S.state.keySet();
		if(!sections.isEmpty()) {
			for(Integer section: sections) {
				List<StateObject> objects=S.state.get(section);
				for(StateObject obj: objects) {
					switch(obj.getType()) {
						case StateObject.TYPE_INT:
							outState.putInt(section.toString()+"-"+StateObject.TYPE_INT+"-"+obj.getName(), obj.getObjectAsInt());
							break;
						case StateObject.TYPE_STRING:
                            //BLog.e("SAVE TO STATE: "+obj.getObjectAsString());
							outState.putString(section.toString()+"-"+StateObject.TYPE_STRING+"-"+obj.getName(), obj.getObjectAsString());
							break;
						case StateObject.TYPE_DOUBLE:
							outState.putDouble(section.toString()+"-"+StateObject.TYPE_DOUBLE+"-"+obj.getName(), obj.getObjectAsDouble());
							break;
						case StateObject.TYPE_LONG:
							outState.putLong(section.toString()+"-"+StateObject.TYPE_LONG+"-"+obj.getName(), obj.getObjectAsLong());
							break;
						default: break;
					}
				}
			}
		}
		if(!S.sections.isEmpty()) {
			int size=S.sections.size();
			if(size-2>=0) {
				outState.putInt(SECTION_SAVE_KEY_1, S.sections.get(S.sections.size() - 2).intValue());
				//BLog.e("SAVE", "section 1: " + S.sections.get(S.sections.size() - 2).intValue());
			}
			if(size-3>=0) {
				outState.putInt(SECTION_SAVE_KEY_2, S.sections.get(S.sections.size()-3).intValue());
				//BLog.e("SAVE", "section 2: "+S.sections.get(S.sections.size()-3).intValue());
			}
            if(size-4>=0) {
                outState.putInt(SECTION_SAVE_KEY_3, S.sections.get(S.sections.size()-4).intValue());
                //BLog.e("SAVE", "section 2: "+S.sections.get(S.sections.size()-3).intValue());
            }
			
			BLog.e("SAVE", "section: " + S.sections.get(size - 1).intValue());
			outState.putInt(SECTION_SAVE_KEY, S.sections.get(size-1).intValue());
		}
	}

