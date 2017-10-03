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
		
	case 'Manage Products':
		$("#manageProduct").addClass('active');
		break;


	default:
		if(menu =="Home")break;
		$("#listProducts").addClass('active');
		$('#categoryName_'+menu).addClass('active');
		break;
	}
	manageProduct
	
})