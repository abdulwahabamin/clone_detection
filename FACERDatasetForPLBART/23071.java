	private boolean setCpuGovernor(String governor) {
		List<String> availableGovernors = getAvailableGovernors();
		if (availableGovernors != null) {
			if (availableGovernors.contains(governor)) {
				if (!governor.equals(getCPUGovernor())) {
					try {
						Process process = Runtime.getRuntime().exec("su");
						DataOutputStream os = new DataOutputStream(process.getOutputStream());
						// For every CPU (core) write the governor in the
						// scaling_governor file
						for (int i = 0; i < getNumCPUs(); i++) {
							os.writeBytes("echo '" + governor + "' >> /sys/devices/system/cpu/cpu" + i
									+ "/cpufreq/scaling_governor\n");
						}
						os.writeBytes("exit\n");
						os.flush();
						os.close();
						process.waitFor();
					} catch (Exception e) {
						Log.e(e.getClass().getName(), e.getMessage(), e);
						return false;
					}
				}
				return true;
			}
		}
		return false;

	}

