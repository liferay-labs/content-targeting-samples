;(function() {
	AUI().applyConfig(
		{
			groups: {
				'user-journey-selector': {
					base: MODULE_PATH + '/js/',
					combine: Liferay.AUI.getCombine(),
					modules: {
						'user-journey-selector': {
							path: 'user_journey_selector.js',
							requires: [
								'aui-base',
								'liferay-item-selector-dialog'
							]
						}
					},
					root: MODULE_PATH + '/js/'
				}
			}
		}
	);
})();