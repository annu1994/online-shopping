$(function() {

	switch (menu) {

	case 'About us':
		$("#about").addClass('active');
		break;

	case 'Contact us':
		$("#contact").addClass('active');
		break;
	case 'All Products':
		$("#listProducts").addClass('active');
		break;

	default:
		if(menu =="Home")break;
		$("#listProducts").addClass('active');
		$('#categoryName_'+menu).addClass('active');
		break;
	}
	
	/*var table = $('#ProductListTable');
	var product=[
		['1','ajhhhbshs'],
		['1','ajhhhbshs'],
		['1','ajhhhbshs'],
		['1','ajhhhbshs'],
		['1','ajhhhbshs'],
		['1','ajhhhbshs'],
		['1','ajhhhbshs']
	];
	if (table .length) {
		console.log("inside the table");

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '5 Records', 'All' ] ],
			pageLength : 5,
			data:product
			ajax : {
				url : jsonUrl,
				datasrc : '',
			},
			columns : [ {
				data : 'name'
			}, {

				data : 'brand'
			}, {
				data : 'unitprice'
			}, {
				data : 'quantity'
			}

			]
		});

	}

*/
})