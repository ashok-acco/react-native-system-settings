import {NativeModules} from 'react-native'
var SystemSettings = NativeModules.SystemSettings


function get (
	callback?: ?(result: ?object) => void
): Promise {
	return new Promise((resolve, reject) => {
		SystemSettings.get(function(result){
			var value = result ? result : null
			callback && callback(value)
			resolve(value)
		})
	})
}


module.exports = {
	get,
}
