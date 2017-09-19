$(function() {

	var $table = $('#ProductListTable');
	if ($table.length) {
		console.log('inside the table');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '5 Records', 'All' ] ],
			pageLength : 5,
			ajax : {
				url : jsonUrl,
				dataSrc : '',
			},
			columns : [ {
				data : 'name'
			}, {

				data : 'brand'
			}, {
				data : 'unitPrice',
				mRender : function(data, type, row) {
					return '&#8377; ' + data
				}
			}, {
				data : 'quantity'
			}

			]
		});

	}

})