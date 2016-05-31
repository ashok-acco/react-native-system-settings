# react-native-system-settings

This module has been prepared by according to Android Configuration class;  https://developer.android.com/reference/android/content/res/Configuration.html

### Note:
  - The module doesn't include the all configuration values. However some additional setting values exist like UI Mode Type and is24HourFormat.
  - The module **doesn't handle the changes** of the phone states in real-time (for instance orientation changes)
  - ***Contributions*** are welcomed.
		A feature that provides ***setting*** the system settings would be great.
		Another feature that provides getting the system settings from ***`iOS`*** would also be great.

## installation

### With [rnpm](https://github.com/rnpm/rnpm) using;

1. Run the command of `npm i --save react-native-system-settings` in the console.
2. Link the native module by using the command below:

`$ rnpm link react-native-system-settings`

3. And finally run the command of `react-native run-android`

### Manually;

1. Run the command of `npm i --save react-native-system-settings` in the console.
2. In your settings.gradle add the lines below:

	```
	include ':systemsettings'
	project(':systemsettings').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-system-settings/android')
	```

3. In your android/app/build.gradle add the following line:

	```
	dependencies {
	    compile fileTree(dir: "libs", include: ["*.jar"])
	    compile "com.android.support:appcompat-v7:23.0.1"
	    compile "com.facebook.react:react-native:+"
			compile project(':systemsettings')  // <-- Add this line
	}
	```

4. The package needs to be provided in the getPackages method of the MainActivity.java file. This file exists under the android folder in your react-native application directory. The path to this file is: android/app/src/main/java/com/your-app-name/MainActivity.java.

	```
	import com.systemsettings.SystemSettingsPackage;  // <-- Add this line

	protected List<ReactPackage> getPackages() {
	    return Arrays.<ReactPackage>asList(
	            new MainReactPackage(),
	            new SystemSettingsPackage()  // <-- Also add this line
			);
	}
	```
5. And finally run the command of `react-native run-android`





## usage

Define a new module variable by using ES6 syntax;<br>
`import SystemSettings from 'react-native-system-settings';`<br>
or by using `require` method;<br>
`var SystemSettings = require('react-native-system-settings');`<br>
then system settings can gotten in somewhere in code:<br>
```
SystemSettings.get(
	settings => console.log('settings: ', settings)
)
```
Also ***promise-then*** can be used:
```
SystemSettings.get().then(settings => console.log('settings: ', settings)).done()
```
Also ***ES7 `async-await`*** method can be used!
```
class App extends React.Component {
	componentWillMount() {
		this._loadInitialState()
	}
	
	_loadInitialState = async () => {
		try {
			let settings = await SystemSettings.get()
			// Now settings variable is filled and can be used!
		} catch (error) {}
	};
}
```


Sample result from Galaxy S3 (Genymotion);

	```
	{
		densityDpi: 320,
		fontScale: 1,
		hardKeyboardHidden: "no",
		keyboard: "qwerty",
		keyboardHidden: "no",
		localization: {
			country: "US",
			displayCountry: "United States",
			displayLanguage: "English",
			displayName: "English (United States)",
			is24HourFormat: false,
			language: "en",
			locale: "en_US"
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
- localization: object<br>
	*localization.country:* One of 'US', 'GB', 'DE', 'FR', ... strings <br>
	*localization.displayCountry:* One of 'United States', 'United Kingdom', ... strings <br>
	*localization.displayLanguage:* One of 'English', 'Deutsch', ... strings <br>
	*localization.displayName:*	 One of 'English (United States)', 'Deutsch (Deutschland)', ... strings <br>
	*localization.is24HourFormat:*	One of `true` and `false` values
	*localization.language:*	 One of 'en', 'de', 'fr', 'tr', ... strings <br>
	*localization.locale:*	 One of 'en_US', 'de_DE', 'de_AT', 'fr_FR', 'tr_TR', ... strings <br>

# License

(The MIT License)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the 'Software'), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
