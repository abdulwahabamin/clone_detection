	private boolean setCpuMaxFrequency(int frequency) {

		try {
			// If the frequency isn't one of the available try to choose the
			// closest one.
			int freq = getClosestFreqToAvailable(frequency);
			if (freq <= 0)
				// problem comparing frequencies to those available
				return false;
			else {
				if (freq != getMaxCPUFrequency()) {
					Process process = Runtime.getRuntime().exec("su");
					DataOutputStream os = new DataOutputStream(process.getOutputStream());
					// For every CPU (core) write the max frequency in the file
					// scaling_max_freq
					for (int i = 0; i < getNumCPUs(); i++) {
						os.writeBytes("echo '" + freq + "' >> /sys/devices/system/cpu/cpu" + i
								+ "/cpufreq/scaling_max_freq\n");
					}
					os.writeBytes("exit\n");
					os.flush();
					os.close();
					process.waitFor();
				}
			}
		} catch (Exception e) {
			Log.e(e.getClass().getName(), e.getMessage(), e);
			return false;
		}
		return true;
	}

