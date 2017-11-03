package com.directv.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author Keerthi G description :Class for reading the properties file
 * @version 1.0
 * @since 11/04/2014
 *
 */

public class PropertyFileReader {

	final static Logger log = Logger.getLogger(PropertyFileReader.class);

	public static String ehcacheConfigXmlLocation;

	public static String testSummaryFileLocation;

	public static String serverGraphsFileLocation;

	public static String jmeterGraphsFileLocation;

	public static String testReportFileLocation;

	public static long liveMonJMXWaitTime;

	public static String jmeterInstallationPath;

	public static String restWebServiceHost;

	private static String restWebServiceRequestURL;
	private static String appDynamicsRequestURL;
	private static String appDynamicsUrlPath;

	private static String appDynamicsUserName;

	private static String appDynamicsPassword;

	// Below are the clodera service properties

	private static String clouderaUsername;

	private static String clouderaPassword;

	private static String awsFlumeHostName;
	private static String awsFlumePortNumber;
	private static String awsFlumeApiVersion;

	private static String awsFlumeClusterType;
	private static String awsFlumeClusterName;

	private static String msdcFlumeHostName;
	private static String msdcFlumePortNumber;

	private static String msdcFlumeApiVersion;
	private static String msdcFlumeHostType;

	private static String msdcFlumeHostTypeName;

	private static String awsHdfsHostName;
	private static String awsHdfsPortNumber;

	private static String awsHdfsApiVersion;
	private static String awsHdfsHostType;
	private static String awsHdfsClusterType;


	private static String awsHdfsClusterName;

	private static String awsHdfsServiceName;



	private static String msdcHdfsHostName;

	private static String msdcHdfsPortNumber;

	private static String msdcHdfsApiVersion;
	private static String msdcHdfsClusterType;

	private static String msdcHdfsClusterName;
	private static String msdcHdfsServiceName;
	private static String msdcHdfsHostType;

	private static String bytes_written_role;
	private static String bytes_read_role;
	private static String flush_nanos_num_ops_role;
	private static String clouderaReportTemplateLocation;
	private static String jmxFilePathLocation;

	private static String spiraWSDLURL;
	
	private static String spiraServicev4NamespaceURI;
	
	public static int spiraProjectId;
	
	public static String spiraServiceInfNamespaceURI;
	
	private static String ambariRequestURL;
	private static String ambariApiVersion;
	private static String ambariUserName;
	private static String ambariPassword;
	public static String SERVER_STD_NAMING_CONVECTION;		
	public static int SERVER_SSH_PORT;
	public static String CMD_N_CPU_CORES;
	public static String CMD_CPU_USAGE;
	public static String CMD_DISK_USAGE;
	public static String CMD_HEAP;
	public static String SERVER_HEALTH_NA;
	public static String PPK_FILE_PATH;
	
	public static String openStackUbuntuOsUserName;
	
	public static String USERGUIDE_FILE_PATH_NAME;
	
	public static String WEBLOGIC_URL;
	public static String configFileLocatio = "/newpartition/opt/dtv/config/Config_phase3EE.properties";
	private static String updatedJmxFilePathLocation ;

	public static Properties readPropertiesFile() {

		Properties csgProp = new Properties();
		InputStream in = null;

		try {
			in = new FileInputStream(configFileLocatio);
			// InputStream in =
			// PropertyFileReader.class.getClassLoader().getResourceAsStream("/newpartition/opt/dtv/config/Config.properties");
			csgProp.load(in);
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.fillInStackTrace());
		}
		finally{
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.error("PropertyFileReader : inputstream closing : " + e.fillInStackTrace());
				}
			}
		}
		return csgProp;
	}

	/**
	 * method name - getEhcacheConfigXmlLocation description - reads the key
	 * value from properties file and returns the value
	 *
	 * @return String
	 */
	public static String getEhcacheConfigXmlLocation() {
		Properties csgProperties = readPropertiesFile();
		ehcacheConfigXmlLocation = csgProperties
				.getProperty("ehcacheConfigXmlLocation");
		return ehcacheConfigXmlLocation;
	}

	/**
	 * method name - getTestSummaryFileLocation description - reads the key
	 * value from properties file and returns the value
	 *
	 * @return String
	 */
	public static String getTestSummaryFileLocation() {
		Properties csgProperties = readPropertiesFile();
		testSummaryFileLocation = csgProperties
				.getProperty("testSummaryFileLocation");
		return testSummaryFileLocation;
	}

	/**
	 * method name - getTestSummaryFileLocation description - reads the key
	 * value from properties file and returns the value
	 *
	 * @return String
	 */
	public static String getServerGraphsFileLocation() {
		Properties csgProperties = readPropertiesFile();
		serverGraphsFileLocation = csgProperties
				.getProperty("testServerGraphLocation");
		return serverGraphsFileLocation;
	}

	/**
	 * method name - getTestSummaryFileLocation description - reads the key
	 * value from properties file and returns the value
	 *
	 * @return String
	 */
	public static String getTestReportFileLocation() {
		Properties csgProperties = readPropertiesFile();
		testReportFileLocation = csgProperties
				.getProperty("testReportFileLocation");
		return testReportFileLocation;
	}

	/**
	 * method name - getJmeterGraphsFileLocation description - reads the key
	 * value from properties file and returns the value
	 *
	 * @return String
	 */
	public static String getJmeterGraphsFileLocation() {
		Properties csgProperties = readPropertiesFile();
		jmeterGraphsFileLocation = csgProperties
				.getProperty("jmeterGraphsFileLocation");
		return jmeterGraphsFileLocation;
	}

	/**
	 * method name - getLiveMonJMXWaitTime description - reads the key value
	 * from properties file and returns the value
	 *
	 * @return String
	 */
	public static long getLiveMonJMXWaitTime() {
		Properties csgProperties = readPropertiesFile();
		liveMonJMXWaitTime = Long.parseLong(csgProperties
				.getProperty("liveMonJMXWaitTime"));
		return liveMonJMXWaitTime;
	}

	/**
	 * method name - getJmeterInstallationPath description - reads the key value
	 * from properties file and returns the value
	 *
	 * @return String
	 */
	public static String getJmeterInstallationPath() {
		Properties csgProperties = readPropertiesFile();
		jmeterInstallationPath = csgProperties
				.getProperty("jmeterInstallationPath");
		return jmeterInstallationPath;
	}

	/**
	 * method name - getRestWebServiceHost description - reads the key value
	 * from properties file and returns the value
	 *
	 * @return String
	 */
	public static String getRestWebServiceHost() {
		Properties csgProperties = readPropertiesFile();
		restWebServiceHost = csgProperties.getProperty("restWebServiceHost");
		return restWebServiceHost;
	}

	/**
	 * method name - getRestWebServiceHost description - reads the key value
	 * from properties file and returns the value
	 *
	 * @return String
	 */
	public static String getRestWebServiceRequestURL() {
		Properties csgProperties = readPropertiesFile();
		restWebServiceRequestURL = csgProperties
				.getProperty("restWebServiceRequestURL");
		return restWebServiceRequestURL;
	}

	/**
	 * method name - getAppDynamicsRequestURL description - reads the key value
	 * from properties file and returns the value
	 *
	 * @return String
	 */
	public static String getAppDynamicsRequestURL() {
		Properties csgProperties = readPropertiesFile();
		appDynamicsRequestURL = csgProperties
				.getProperty("appDynamicsRequestURL");
		return appDynamicsRequestURL;
	}

	/**
	 * method name - getAppDynamicsURLPath description - reads the key value
	 * from properties file and returns the value
	 *
	 * @return String
	 */
	public static String getAppDynamicsURLPath() {
		Properties csgProperties = readPropertiesFile();
		appDynamicsUrlPath = csgProperties.getProperty("appDynamicsUrlPath");
		return appDynamicsUrlPath;
	}

	/**
	 * method name - getAppDynamicsUserName description - reads the key value
	 * from properties file and returns the value
	 *
	 * @return String
	 */
	public static String getAppDynamicsUserName() {
		Properties csgProperties = readPropertiesFile();
		appDynamicsUserName = csgProperties.getProperty("appDynamicsUserName");
		return appDynamicsUserName;
	}

	/**
	 * method name - getAppDynamicsPassword description - reads the key value
	 * from properties file and returns the value
	 *
	 * @return String
	 */
	public static String getAppDynamicsPassword() {
		Properties csgProperties = readPropertiesFile();
		appDynamicsPassword = csgProperties.getProperty("appDynamicsPassword");
		return appDynamicsPassword;
	}

	/**
	 * @return the clouderaUsername
	 */
	public static String getClouderaUsername() {
		Properties csgProperties = readPropertiesFile();
		clouderaUsername = csgProperties.getProperty("clouderaUsername");
		return clouderaUsername;
	}

	/**
	 * @return the clouderaPassword
	 */
	public static String getClouderaPassword() {
		Properties csgProperties = readPropertiesFile();
		clouderaPassword = csgProperties.getProperty("clouderaPassword");
		return clouderaPassword;
	}

	/**
	 * @return the awsFlumeHostName
	 */
	public static String getAwsFlumeHostName() {
		Properties csgProperties = readPropertiesFile();
		awsFlumeHostName = csgProperties.getProperty("awsFlumeHostName");
		return awsFlumeHostName;
	}

	/**
	 * @return the awsFlumePortNumber
	 */
	public static String getAwsFlumePortNumber() {
		Properties csgProperties = readPropertiesFile();
		awsFlumePortNumber = csgProperties.getProperty("awsFlumePortNumber");
		return awsFlumePortNumber;
	}

	/**
	 * @return the awsFlumeApiVersion
	 */
	public static String getAwsFlumeApiVersion() {
		Properties csgProperties = readPropertiesFile();
		awsFlumeApiVersion = csgProperties.getProperty("awsFlumeApiVersion");
		return awsFlumeApiVersion;
	}

	/**
	 * @return the awsFlumeClusterType
	 */
	public static String getAwsFlumeClusterType() {
		Properties csgProperties = readPropertiesFile();
		awsFlumeClusterType = csgProperties.getProperty("awsFlumeClusterType");
		return awsFlumeClusterType;
	}

	/**
	 * @return the awsFlumeClusterName
	 */
	public static String getAwsFlumeClusterName() {
		Properties csgProperties = readPropertiesFile();
		awsFlumeClusterName = csgProperties.getProperty("awsFlumeClusterName");
		return awsFlumeClusterName;
	}

	/**
	 * @return the msdcFlumeHostName
	 */
	public static String getMsdcFlumeHostName() {
		Properties csgProperties = readPropertiesFile();
		msdcFlumeHostName = csgProperties.getProperty("msdcFlumeHostName");
		return msdcFlumeHostName;
	}

	/**
	 * @return the msdcFlumePortNumber
	 */
	public static String getMsdcFlumePortNumber() {
		Properties csgProperties = readPropertiesFile();
		msdcFlumePortNumber = csgProperties.getProperty("msdcFlumePortNumber");
		return msdcFlumePortNumber;
	}

	/**
	 * @return the msdcFlumeApiVersion
	 */
	public static String getMsdcFlumeApiVersion() {
		Properties csgProperties = readPropertiesFile();
		msdcFlumeApiVersion = csgProperties.getProperty("msdcFlumeApiVersion");
		return msdcFlumeApiVersion;
	}

	/**
	 * @return the msdcFlumeHostType
	 */
	public static String getMsdcFlumeHostType() {
		Properties csgProperties = readPropertiesFile();
		msdcFlumeHostType = csgProperties.getProperty("msdcFlumeHostType");
		return msdcFlumeHostType;
	}

	/**
	 * @return the msdcFlumeHostTypeName
	 */
	public static String getMsdcFlumeHostTypeName() {
		Properties csgProperties = readPropertiesFile();
		msdcFlumeHostTypeName = csgProperties
				.getProperty("msdcFlumeHostTypeName");
		return msdcFlumeHostTypeName;
	}

	/**
	 * @return the awsHdfsHostName
	 */
	public static String getAwsHdfsHostName() {
		Properties csgProperties = readPropertiesFile();
		awsHdfsHostName = csgProperties.getProperty("awsHdfsHostName");
		return awsHdfsHostName;
	}

	/**
	 * @return the awsHdfsPortNumber
	 */
	public static String getAwsHdfsPortNumber() {
		Properties csgProperties = readPropertiesFile();
		awsHdfsPortNumber = csgProperties.getProperty("awsHdfsPortNumber");
		return awsHdfsPortNumber;
	}

	/**
	 * @return the awsHdfsApiVersion
	 */
	public static String getAwsHdfsApiVersion() {
		Properties csgProperties = readPropertiesFile();
		awsHdfsApiVersion = csgProperties.getProperty("awsHdfsApiVersion");
		return awsHdfsApiVersion;
	}

	/**
	 * @return the awsHdfsHostType
	 */
	public static String getAwsHdfsHostType() {
		Properties csgProperties = readPropertiesFile();
		awsHdfsHostType = csgProperties.getProperty("awsHdfsHostType");
		return awsHdfsHostType;
	}

	/**
	 * @return the awsHdfsServiceName
	 */
	public static String getAwsHdfsServiceName() {
		Properties csgProperties = readPropertiesFile();
		awsHdfsServiceName = csgProperties.getProperty("awsHdfsServiceName");
		return awsHdfsServiceName;
	}

	/**
	 * @return the awsHdfsClusterName
	 */
	public static String getAwsHdfsClusterName() {
		Properties csgProperties = readPropertiesFile();
		awsHdfsClusterName = csgProperties.getProperty("awsHdfsClusterName");
		return awsHdfsClusterName;
	}

	/**
	 * @return the awsHdfsClusterType
	 */
	public static String getAwsHdfsClusterType() {
		Properties csgProperties = readPropertiesFile();
		awsHdfsClusterType = csgProperties.getProperty("awsHdfsClusterType");
		return awsHdfsClusterType;
	}

	/**
	 * @return the msdcHdfsHostName
	 */
	public static String getMsdcHdfsHostName() {
		Properties csgProperties = readPropertiesFile();
		msdcHdfsHostName = csgProperties.getProperty("msdcHdfsHostName");
		return msdcHdfsHostName;
	}

	/**
	 * @return the msdcHdfsPortNumber
	 */
	public static String getMsdcHdfsPortNumber() {
		Properties csgProperties = readPropertiesFile();
		msdcHdfsPortNumber = csgProperties.getProperty("msdcHdfsPortNumber");
		return msdcHdfsPortNumber;
	}

	/**
	 * @return the msdcHdfsApiVersion
	 */
	public static String getMsdcHdfsApiVersion() {
		Properties csgProperties = readPropertiesFile();
		msdcHdfsApiVersion = csgProperties.getProperty("msdcHdfsApiVersion");
		return msdcHdfsApiVersion;
	}

	/**
	 * @return the msdcHdfsClusterType
	 */
	public static String getMsdcHdfsClusterType() {
		Properties csgProperties = readPropertiesFile();
		msdcHdfsClusterType = csgProperties.getProperty("msdcHdfsClusterType");
		return msdcHdfsClusterType;
	}

	/**
	 * @return the msdcHdfsClusterName
	 */
	public static String getMsdcHdfsClusterName() {
		Properties csgProperties = readPropertiesFile();
		msdcHdfsClusterName = csgProperties.getProperty("msdcHdfsClusterName");
		return msdcHdfsClusterName;
	}

	/**
	 * @return the msdcHdfsServiceName
	 */
	public static String getMsdcHdfsServiceName() {
		Properties csgProperties = readPropertiesFile();
		msdcHdfsServiceName = csgProperties.getProperty("msdcHdfsServiceName");
		return msdcHdfsServiceName;
	}

	/**
	 * @return the msdcHdfsHostType
	 */
	public static String getMsdcHdfsHostType() {
		Properties csgProperties = readPropertiesFile();
		msdcHdfsHostType = csgProperties.getProperty("msdcHdfsHostType");
		return msdcHdfsHostType;
	}

	/**
	 * @return the bytes_written_role
	 */
	public static String getBytes_written_role() {
		Properties csgProperties = readPropertiesFile();
		bytes_written_role = csgProperties.getProperty("bytes_written_role");
		return bytes_written_role;
	}

	/**
	 * @return the bytes_read_role
	 */
	public static String getBytes_read_role() {
		Properties csgProperties = readPropertiesFile();
		bytes_read_role = csgProperties.getProperty("bytes_read_role");
		return bytes_read_role;
	}

	/**
	 * @return the flush_nanos_num_ops_role
	 */
	public static String getFlush_nanos_num_ops_role() {
		Properties csgProperties = readPropertiesFile();
		flush_nanos_num_ops_role = csgProperties.getProperty("flush_nanos_num_ops_role");
		return flush_nanos_num_ops_role;
	}
	public static String getClouderaReportTemplateLocation() {
		Properties csgProperties = readPropertiesFile();
		clouderaReportTemplateLocation = csgProperties.getProperty("clouderaReportTemplateLocation");
		return clouderaReportTemplateLocation;
	}
	/**
		 * method name - getJmxFilePathLocation
		 * description - reads the key value from properties file and returns the value
		 * @return String
		 */
		public static String getJmxFilePathLocation(){
		Properties csgProperties = readPropertiesFile();
		jmxFilePathLocation = csgProperties.getProperty("jmxFilePathLocation");
		return jmxFilePathLocation;
	}
		/**
		 * method name - getSpiraTeamWSDLLink
		 * description - reads the key value from properties file and returns the value
		 * @return String 
		 */
		public static String getSpiraTeamWSDLLink(){
		Properties csgProperties = readPropertiesFile();
		spiraWSDLURL = csgProperties.getProperty("SpiraWSDLLink");
		return spiraWSDLURL;
		}
		
		/**
		 * method name - getSpiraServicev4NamespaceURI
		 * description - reads the key value from properties file and returns the value
		 * @return String 
		 */
		public static String getSpiraServicev4NamespaceURI(){
		Properties csgProperties = readPropertiesFile();
		spiraServicev4NamespaceURI = csgProperties.getProperty("SpiraTeamv4NamespaceURI");
		return spiraServicev4NamespaceURI;
		}
		
		/**
		 * method name - getSpiraServicev4NamespaceURI
		 * description - reads the key value from properties file and returns the value
		 * @return String 
		 */
		public static int getSpiraProjectId(){
		Properties csgProperties = readPropertiesFile();
		spiraProjectId = Integer.parseInt(csgProperties.getProperty("spiraProjectId"));
		return spiraProjectId;
		}
			
		/**
		 * method name - getSpiraServiceInfNamespaceURI
		 * description - reads the key value from properties file and returns the value
		 * @return String 
		 */
		public static String getSpiraServiceInfNamespaceURI(){
		Properties csgProperties = readPropertiesFile();
		spiraServiceInfNamespaceURI = csgProperties.getProperty("SpiraTeaminfNamespaceURI");
		return spiraServiceInfNamespaceURI;
		}
		
		public static String getUpdatedJmxFilePathLocation() {
			Properties csgProperties = readPropertiesFile();
			updatedJmxFilePathLocation = csgProperties.getProperty("updatedJmxFilePathLocation");
			return updatedJmxFilePathLocation;
		}

		public static String getServerStandardNamingConvection() {
			Properties csgProperties = readPropertiesFile();
			SERVER_STD_NAMING_CONVECTION = csgProperties.getProperty("SERVER_STD_NAMING_CONVECTION");
			return SERVER_STD_NAMING_CONVECTION;
		}

		public static int getServerSSHPort() {
			Properties csgProperties = readPropertiesFile();
			SERVER_SSH_PORT = Integer.parseInt(csgProperties.getProperty("SERVER_SSH_PORT"));
			return SERVER_SSH_PORT;
		}

		public static String getCommandNCPUCores() {
			Properties csgProperties = readPropertiesFile();
			CMD_N_CPU_CORES = csgProperties.getProperty("CMD_N_CPU_CORES");
			return CMD_N_CPU_CORES;
		}

		public static String getCommandCPUUsage() {
			Properties csgProperties = readPropertiesFile();
			CMD_CPU_USAGE = csgProperties.getProperty("CMD_CPU_USAGE");
			return CMD_CPU_USAGE;
		}

		public static String getCommandDiskUsage() {
			Properties csgProperties = readPropertiesFile();
			CMD_DISK_USAGE = csgProperties.getProperty("CMD_DISK_USAGE");
			return CMD_DISK_USAGE;
		}

		public static String getCommandHeap() {
			Properties csgProperties = readPropertiesFile();
			CMD_HEAP = csgProperties.getProperty("CMD_HEAP");
			return CMD_HEAP;
		}

		public static String getStringServerHealthNA() {
			Properties csgProperties = readPropertiesFile();
			SERVER_HEALTH_NA = csgProperties.getProperty("SERVER_HEALTH_NA");
			return SERVER_HEALTH_NA;
		}
		public static String getPPK_FILE_PATH() {
			Properties csgProperties = readPropertiesFile();
			PPK_FILE_PATH = csgProperties.getProperty("PPK_FILE_PATH");
			return PPK_FILE_PATH;
		}
		public static String getOpenStackUbuntuOsUserName() {
			Properties csgProperties = readPropertiesFile();
			openStackUbuntuOsUserName = csgProperties.getProperty("openStackUbuntuOsUserName");
			return openStackUbuntuOsUserName;
		}
		/**
		 * @return the uSERGUIDE_FILE_PATH_NAME
		 */
		public static String getUSERGUIDE_FILE_PATH_NAME() {
			Properties csgProperties = readPropertiesFile();
			USERGUIDE_FILE_PATH_NAME = csgProperties.getProperty("USERGUIDE_FILE_PATH_NAME");
			return USERGUIDE_FILE_PATH_NAME;
		}
		/**
		 * @return the wEBLOGIC_URL
		 */
		public static String getWEBLOGIC_URL() {
			Properties csgProperties = readPropertiesFile();
			WEBLOGIC_URL = csgProperties.getProperty("WEBLOGIC_URL");
			return WEBLOGIC_URL;
		}
		public static String getAmbariRequestURL() {
			Properties csgProperties = readPropertiesFile();
			ambariRequestURL = csgProperties.getProperty("ambariRequestURL");
			return ambariRequestURL;
		}
		
		public static String getAmbariApiVersion() {
			Properties csgProperties = readPropertiesFile();
			ambariApiVersion = csgProperties.getProperty("ambariApiVersion");
			return ambariApiVersion;
		}
		
		public static String getAmbariUserName() {
			Properties csgProperties = readPropertiesFile();
			ambariUserName = csgProperties.getProperty("ambariUserName");
			return ambariUserName;
		}
		
		public static String getAmbariPassword() {
			Properties csgProperties = readPropertiesFile();
			ambariPassword = csgProperties.getProperty("ambariPassword");
			return ambariPassword;
		}
}
