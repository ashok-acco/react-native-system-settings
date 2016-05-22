# react-native-system-settings

This module has been prepared by according to Android Configuration class;  https://developer.android.com/reference/android/content/res/Configuration.html

### Note:
  - The module doesn't include the all configuration values. However some additional setting values exist like UI Mode Type.
  - The module **doesn't handle the changes** of the phone states in real-time (for instance orientation changes)
  - ***Helping*** to improve that module would be welcomed.
		A feature that provides ***setting*** the system settings would be great.
		Another feature that provides getting the system settings from ***`iOS`*** would be great.

## installation

1. Run the command of `npm i --save react-native-system-settings` in the console.
2. After installing the npm package you need to link the native modules. You can do so using [rnpm](https://github.com/rnpm/rnpm).

`$ rnpm link react-native-system-settings`

Or you can do it manually as follows:

step-1. In your settings.gradle add the lines below:

	```
	include ':systemsettings'
	project(':systemsettings').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-system-settings/android')
	```


step-2. The package needs to be provided in the getPackages method of the MainActivity.java file. This file exists under the android folder in your react-native application directory. The path to this file is: android/app/src/main/java/com/your-app-name/MainActivity.java.

	```
	import com.systemsettings.SystemSettingsPackage;  // <-- Add this line

	protected List<ReactPackage> getPackages() {
	    return Arrays.<ReactPackage>asList(
	            new MainReactPackage(),
	            new SystemSettingsPackage()  // <-- Also add this line
			);
	}
	```


step-3. In your android/app/build.gradle add the following line:

	```
	dependencies {
	    compile fileTree(dir: "libs", include: ["*.jar"])
	    compile "com.android.support:appcompat-v7:23.0.1"
	    compile "com.facebook.react:react-native:+"
			compile project(':systemsettings')  // <-- Add this line
	}
	```


## usage

Define a new module variable by;<br>
`import SystemSettings from 'react-native-system-settings';`<br>
or<br>
`var SystemSettings = require('react-native-system-settings');`<br>
then system settings can gotten in somewhere in code<br>
```
SystemSettings.get(
	settings => console.log('settings: ', settings)
)
```

Sample result from Galaxy S3 (Genymotion);

	```
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
	```

### The values that can be existed in result object;

- densityDpi: Number
- fontScale: Number
- hardKeyboardHidden: One of 'undefined', 'no' or 'yes' strings
- keyboardHidden: One of 'undefined', 'no' or 'yes' strings
- keyboard: One of 'undefined', 'nokeys', 'qwerty' or '12key' strings
- orientation: One of 'undefined', 'portrait', 'landscape' or 'square' strings
- screenLayout: One of 'small', 'normal', 'large', 'xlarge' or 'undefined' strings <br>
	*small:* The screen is at least approximately 320x426 dp units.<br>
	*normal:* The screen is at least approximately 320x470 dp units.<br>
	*large:* The screen is at least approximately 480x640 dp units.<br>
	*xlarge:* The screen is at least approximately 720x960 dp units.<br>
	*undefined:* A screen layout size value indicating that no size has been set.
- screenHeightDp: Number
- screenWidthDp: Number
- smallestScreenWidthDp: Number
- uiModeType: One of 'undefined', 'normal', 'desk', 'car', 'television', 'appliance' or 'watch' strings
- locale: object<br>
	*locale.country:* One of 'US', 'GB', 'DE', 'FR', ... strings <br>
	*locale.displayCountry:* One of 'United States', 'United Kingdom', ... strings <br>
	*locale.displayLanguage:* One of 'English', 'Deutsch', ... strings <br>
	*locale.displayName:*	 One of 'English (United States)', 'Deutsch (Deutschland)', ... strings <br>
	*locale.language:*	 One of 'en', 'de', 'fr', 'tr', ... strings <br>
	*locale.localization:*	 One of 'en_US', 'de_DE', 'de_AT', 'fr_FR', 'tr_TR', ... strings <br>

# License

(The MIT License)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the 'Software'), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
