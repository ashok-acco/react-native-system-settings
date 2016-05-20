# react-native-system-settings

This module has been prepared by according to Android Configuration class;  https://developer.android.com/reference/android/content/res/Configuration.html

### Note:
  - The module doesn't include the all configuration values. However some additional setting values exist like UI Mode Type.
  - The module **doesn't handle the changes** of the phone states in real-time (for instance orientation changes)
  - ***Helping*** to improve that module would be welcomed.
		A feature that provides ***setting*** the system settings would be great.
		Another feature that provides getting the system settings from ***`iOS`*** would be great.

## installation

In your settings.gradle add the lines below:


	include ':systemsettings'
	project(':systemsettings').projectDir = new File(rootProject.projectDir, '../node_modules/systemsettings/android')



The package needs to be provided in the getPackages method of the MainActivity.java file. This file exists under the android folder in your react-native application directory. The path to this file is: android/app/src/main/java/com/your-app-name/MainActivity.java.


	import com.systemsettings.SystemSettingsPackage;  // <-- Add this line

	protected List<ReactPackage> getPackages() {
	    return Arrays.<ReactPackage>asList(
	            new MainReactPackage(),
	            new SystemSettingsModule()  // <-- Also add this line
			);
	}



In your android/app/build.gradle add the following line:


	dependencies {
	    compile fileTree(dir: "libs", include: ["*.jar"])
	    compile "com.android.support:appcompat-v7:23.0.1"
	    compile "com.facebook.react:react-native:+"
			compile project(':systemsettings')  // <-- Add this line
	}



## usage

`import SystemSettings from 'react-native-system-settings';`
or
`var SystemSettings = require('react-native-system-settings');`


Sample result from Galaxy S3 (Genymotion);

	{
		densityDpi: 320,
		fontScale: 1,
		hardKeyboardHidden: "no",
		keyboard: "qwerty",
		keyboardHidden: "no",
		locale: {
			country: "US",
			displayCountry: "United States",
			displayLanguage: "English",
			displayName: "English (United States)",
			language: "en",
			localization: "en_US"
		},
		orientation: "portrait",
		screenHeightDp: 615,
		screenLayout: "normal",
		screenWidthDp: 360,
		smallestScreenWidthDp: 360,
		uiModeType: "normal"
	}


### The values that can be existed in result object;

- densityDpi: number
- fontScale: number
- hardKeyboardHidden: enum('undefined', 'no', 'yes')
- keyboardHidden: enum('undefined', 'no', 'yes')
- keyboard: enum('undefined', 'nokeys', 'qwerty', '12key')
- orientation: enum('undefined', 'portrait', 'landscape', 'square')
- screenLayout: enum('small', 'normal', 'large', 'xlarge', 'undefined') <br>
	*small:* The screen is at least approximately 320x426 dp units.<br>
	*normal:* The screen is at least approximately 320x470 dp units.<br>
	*large:* The screen is at least approximately 480x640 dp units.<br>
	*xlarge:* The screen is at least approximately 720x960 dp units.<br>
	*undefined:* A screen layout size value indicating that no size has been set.
- screenHeightDp: number
- screenWidthDp: number
- smallestScreenWidthDp: number
- uiModeType: enum('undefined', 'normal', 'desk', 'car', 'television', 'appliance', 'watch')
- locale: object<br>
	locale.country: enum('US', 'GB', 'DE', 'FR', ...)<br>
	locale.displayCountry: enum('United States', 'United Kingdom', ...)<br>
	locale.displayLanguage: enum('English', 'Deutsch', ...)<br>
	locale.displayName: enum('English (United States)', 'Deutsch (Deutschland)', ...)<br>
	locale.language: enum('en', 'de', 'fr', 'tr', ...)<br>
	locale.localization: enum('en_US', 'de_DE', 'de_AT', 'fr_FR', 'tr_TR', ...)<br>
