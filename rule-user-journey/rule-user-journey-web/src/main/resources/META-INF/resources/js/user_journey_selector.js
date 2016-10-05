AUI.add(
	'user-journey-selector',
	function(A) {
		var Lang = A.Lang;

		var TPL_ARROW = '<div class="user-journey-arrow">&darr;</div>';

		var TPL_PAGE_NODE = '<div data-uuid="{uuid}" class="user-journey-node">{name}<span class="user-journey-delete-node">&times;</span></div>';

		var UJ = A.Component.create(
			{
				ATTRS: {
					buttonNode: {
						setter: A.one
					},

					eventName: {
						validator: Lang.isString
					},

					itemSelectorURL: {
						validator: Lang.isString
					},

					journeyArray: {
						validator: Lang.isArray
					},

					outputNode: {
						setter: A.one
					},

					selectorNode: {
						setter: A.one
					},

					strings:{}
				},

				AUGMENTS: [Liferay.PortletBase],

				EXTENDS: A.Base,

				NAME: 'user-journey-selector',

				NS: 'user-journey-selector',

				prototype: {
					initializer: function(config) {
						var instance = this;

						instance._bindUI();

						instance._render();
					},

					destructor: function() {
						var instance = this;

						(new A.EventHandle(instance._eventHandles)).detach();
					},

					_addNode: function(name, uuid) {
						var instance = this;

						var outputNode = instance.get('outputNode');
						var selectorNode = instance.get('selectorNode');

						var selectorChildren = selectorNode.all('*');

						var outputArray = A.JSON.parse(outputNode.val());

						var nodeTmpl = Lang.sub(
							TPL_PAGE_NODE,
							{
								name: name,
								uuid: uuid
							}
						);

						var node = A.Node.create(nodeTmpl);

						if (selectorChildren.size() > 0) {
							var arrow = A.Node.create(TPL_ARROW);

							selectorNode.appendChild(arrow);
						}

						selectorNode.appendChild(node);

						var nodeObject = {
							name: name,
							step: outputArray.length + 1,
							uuid: uuid
						};

						outputArray.push(nodeObject);

						outputNode.val(A.JSON.stringify(outputArray));
					},

					_bindUI: function() {
						var instance = this;

						var buttonNode = instance.get('buttonNode');

						var selectorNode = instance.get('selectorNode');

						var eventHandles = [];

						var eventName = instance.get('eventName');

						var strings = instance.get('strings');

						var itemSelectorUrl = instance.get('itemSelectorURL');

						eventHandles.push(
							buttonNode.on(
								'click',
								function(event) {
									var itemSelectorDialog = new A.LiferayItemSelectorDialog(
										{
											eventName: eventName,
											on: {
												selectedItemChange: function(event) {
													var selectedItem = event.newVal;

													if (selectedItem) {
														var pageName = selectedItem.layoutpath;
														var pageUuid = selectedItem.value;

														instance._addNode(pageName, pageUuid);
													}
												}
											},
											'strings.add': strings.add,
											title: strings.title,
											url: itemSelectorUrl
										}
									);

									itemSelectorDialog.open();
								}
							)
						);

						eventHandles.push(
							selectorNode.delegate(
								'click',
								instance._deleteNode,
								'.user-journey-delete-node',
								instance
							)
						);

						instance._eventHandles = eventHandles;
					},

					_deleteNode: function(event) {
						var instance = this;

						var deleteSpan = event.target;

						var uuidNode = deleteSpan.ancestor('div');

						var uuid = uuidNode.getData().uuid;

						var outputNode = instance.get('outputNode');

						var outputArray = A.JSON.parse(outputNode.val());

						var newOutputArray = [];

						var idx = 1;

						for (var k in outputArray) {
							var obj = outputArray[k];

							if (obj.uuid != uuid) {
								obj.step = idx;

								newOutputArray.push(obj);

								idx++;
							}
						}

						outputNode.val(A.JSON.stringify(newOutputArray));

						uuidNode.remove();

						instance._render();
					},

					_render: function() {
						var instance = this;

						var outputNode = instance.get('outputNode');
						var selectorNode = instance.get('selectorNode');

						selectorNode.all('> *').remove();

						var outputArray = A.JSON.parse(outputNode.val());

						outputNode.val('[]');

						for (var k in outputArray) {
							var obj = outputArray[k];

							instance._addNode(obj.name, obj.uuid);
						}
					}
				}
			}
		);

		UserJourneySelector = UJ;
	},
	'',
	{
		requires: ['aui-base', 'liferay-item-selector-dialog']
	}
);